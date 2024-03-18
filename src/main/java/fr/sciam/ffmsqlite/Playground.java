package com.sciam.ffmsqlite;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static fr.sciam.sqlite.SQLite3.C_POINTER;
import static fr.sciam.sqlite.SQLite3.sqlite3_exec;
import static fr.sciam.sqlite.SQLite3.sqlite3_free;
import static fr.sciam.sqlite.SQLite3.sqlite3_open;


public class Playground {

  private static final String LIBRARY_NAME = "sqlite3";

  public static void main(final String[] args) {

    System.loadLibrary(LIBRARY_NAME);

    try (Arena arena = Arena.ofConfined()) {

      MemorySegment databasePointer = arena.allocate(C_POINTER);

      int rc = sqlite3_open(arena.allocateFrom("ffm.db"), databasePointer);
      MemorySegment dbPtrPtr = databasePointer.get(C_POINTER, 0);

      // create a new table
      String query = """
          CREATE TABLE IF NOT EXISTS jedi (
            id serial,
            name varchar NOT NULL,
            rank varchar NOT NULL
          )""";
      MemorySegment sqlSegment = arena.allocateFrom(query);

      MemorySegment errorMessagePointer = arena.allocate(C_POINTER);
      rc = sqlite3_exec(dbPtrPtr, sqlSegment, MemorySegment.NULL, MemorySegment.NULL, errorMessagePointer);

      if (rc != 0) {
        System.err.println("sqlite3_exec failed: " + rc);
        System.err.println("SQL error: " + errorMessagePointer.get(C_POINTER, 0).getString(0));
        sqlite3_free(errorMessagePointer.get(C_POINTER, 0));
      } else {
        System.out.println("employee table created");
      }
    }
  }
}
