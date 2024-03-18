package fr.sciam.ffmsqlite;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class SQLite {

//  private static final String LIBRARY_NAME = "sqlite3";

  public static void main(final String[] args) throws NoSuchMethodException, IllegalAccessException {

    if (args.length == 0) {
      System.err.println("One parameter is required :  path to SQLite lib");
      System.exit(1);
    }

    Linker linker = Linker.nativeLinker();

    try (Arena arena = Arena.ofConfined()) {

//      Path path = Path.of("C:\\Users\\clem\\repositories\\ffm-sqlite\\src\\main\\resources\\sqlite3.dll");
//      System.out.println(Files.exists(path));
//      SymbolLookup lookup = SymbolLookup.libraryLookup(
//        path,
//        arena
//      );

      String libPath = args[0];
      SymbolLookup lookup = SymbolLookup.libraryLookup(libPath, arena);

//      SymbolLookup lookup = SymbolLookup.loaderLookup();
//      System.out.println(lookup);

      String databaseFilename = "ffm.db";
      MemorySegment filenameSegment = arena.allocateFrom(databaseFilename);

      /*
        int sqlite3_open(
          const char *filename,       Database filename (UTF-8)
          sqlite3 **ppDb              OUT: SQLite db handle
        );
       */
      FunctionDescriptor openDesc = FunctionDescriptor.of(
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
      );

      String openFunctionName = "sqlite3_open";
      MemorySegment openSegment = lookup.find(openFunctionName)
        .orElseThrow(() -> new IllegalStateException("Impossible de localiser la fonction " + openFunctionName));
      MethodHandle openHandle = linker.downcallHandle(openSegment, openDesc);

      MemorySegment dbPtrPtr = arena.allocate(ValueLayout.ADDRESS);

      try {
        int code = (int) openHandle.invokeExact(filenameSegment, dbPtrPtr);
        if (code == 0) {
          System.out.println("Database " + databaseFilename + " successfully opened !");
        } else {
          System.err.println("Failed to load database (error code = " + code + ")");
        }

      } catch (Throwable e) {
        throw new IllegalStateException("Failed to invoke native function " + openFunctionName, e);
      }

      MemorySegment dbPtr = dbPtrPtr.get(ValueLayout.ADDRESS, 0);

      // Set up the callback
      MethodHandle traceCallbackHandle = MethodHandles.lookup()
        .findStatic(
          SQLite.class,
          "traceCallback",
          MethodType.methodType(
            int.class,
            MemorySegment.class,
            MemorySegment.class,
            MemorySegment.class,
            MemorySegment.class
          )
        );

      FunctionDescriptor traceCallbackDesc = FunctionDescriptor.of(
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
      );
      MemorySegment upcallStub = linker.upcallStub(traceCallbackHandle, traceCallbackDesc, arena);

      // Set up the trace configuration
      FunctionDescriptor traceDesc = FunctionDescriptor.of(
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS,
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
      );
      MemorySegment traceSegment = lookup.find("sqlite3_trace_v2").orElseThrow();
      MethodHandle traceHandle = linker.downcallHandle(traceSegment, traceDesc);
      try {
        int traceCode = (int) traceHandle.invokeExact(
          dbPtr,
          0x01, // SQLITE_TRACE_STMT
          upcallStub,
          MemorySegment.NULL
        );

        System.out.println("traceCode " + traceCode);

      } catch (Throwable e) {
        throw new IllegalStateException(e);
      }
//      sqlite3_trace_v2(db, SQLITE_TRACE_STMT, traceCallback, NULL);




      String query = """
          CREATE TABLE IF NOT EXISTS jedi (
            id serial,
            name varchar NOT NULL,
            rank varchar NOT NULL
          )""";
      MemorySegment querySegment = arena.allocateFrom(query);

      /*
       int sqlite3_exec(
         sqlite3*,                                      An open database
         const char *sql,                               SQL to be evaluated
         int( * callback)( void*,int,char**,char**),    Callback function
         void *,                                        1st argument to callback
         char **errmsg                                  Error msg written here
       );
       */
      FunctionDescriptor execDesc = FunctionDescriptor.of(
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
      );

      MemorySegment execSegment = lookup.find("sqlite3_exec").orElseThrow();
      MethodHandle execHandle = linker.downcallHandle(execSegment, execDesc);

      MemorySegment errorMessagePointer = arena.allocate(ValueLayout.ADDRESS);
      try {

        // Setup callback
//        MethodHandle callbackHandle = MethodHandles.lookup().findStatic(
//          SQLite.class,
//          "callback",
//          MethodType.methodType(
//            int.class,
//            MemorySegment.class,
//            MemorySegment.class,
//            MemorySegment.class,
//            MemorySegment.class
//          )
//        );
//
//        FunctionDescriptor callbackDescriptor = FunctionDescriptor.of(
//          ValueLayout.JAVA_INT,
//          ValueLayout.ADDRESS,
//          ValueLayout.JAVA_INT,
//          ValueLayout.ADDRESS,
//          ValueLayout.ADDRESS
//        );
//        MemorySegment callbackSegment = linker.upcallStub(callbackHandle, callbackDescriptor, Arena.ofAuto());


        int execResult = (int) execHandle.invokeExact(
          dbPtr,
          querySegment,
          MemorySegment.NULL, // callbackSegment,
          MemorySegment.NULL,
          errorMessagePointer
        );

        if (execResult == 0) {
          System.out.println("jedi table query successfully executed");
        } else {
          System.err.println("sqlite3_exec failed: " + execResult);
          MemorySegment errorMessageMemorySegment = errorMessagePointer.get(ValueLayout.ADDRESS, 0);
          System.err.println("SQL error: " + errorMessageMemorySegment.getString(0));

          FunctionDescriptor freeDesc = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
          MemorySegment freeSegment = lookup.find("sqlite3_free").orElseThrow();
          MethodHandle freeHandle = linker.downcallHandle(freeSegment, freeDesc);

          freeHandle.invokeExact(errorMessageMemorySegment);
        }

      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    }
  }

  static int traceCallback(
    final MemorySegment m1,
    final MemorySegment m2,
    final MemorySegment m3,
    final MemorySegment m4) {

    System.out.println("Appel de traceCallback()");

    return 0;
  }

//  int callback(void* data, int argc, char** argv, char** azColName);
//
//  data: A pointer to the first argument passed in the void* parameter below.
//  argc: The number of columns in the result set.
//  argv: An array of pointers to strings representing column values for the current row.
//    azColName: An array of pointers to strings representing column names.
//  public static int callback(
//    final MemorySegment pointer,
//    final MemorySegment columnsCount,
//    final MemorySegment columnsText,
//    final MemorySegment columnsName) {
//
//    System.out.println("In SQLite java Callback !");
//    return 0;
//  }

//  static {
//    System.loadLibrary(LIBRARY_NAME);
//  }
}
