// Generated by jextract

package com.codesimcoe.sqlite;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct fts5_api {
 *     int iVersion;
 *     int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *));
 *     int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *);
 *     int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *));
 * }
 * }
 */
public class fts5_api {

    fts5_api() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        sqlite3_h.C_INT.withName("iVersion"),
        MemoryLayout.paddingLayout(4),
        sqlite3_h.C_POINTER.withName("xCreateTokenizer"),
        sqlite3_h.C_POINTER.withName("xFindTokenizer"),
        sqlite3_h.C_POINTER.withName("xCreateFunction")
    ).withName("fts5_api");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt iVersion$LAYOUT = (OfInt)$LAYOUT.select(groupElement("iVersion"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int iVersion
     * }
     */
    public static final OfInt iVersion$layout() {
        return iVersion$LAYOUT;
    }

    private static final long iVersion$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int iVersion
     * }
     */
    public static final long iVersion$offset() {
        return iVersion$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int iVersion
     * }
     */
    public static int iVersion(MemorySegment struct) {
        return struct.get(iVersion$LAYOUT, iVersion$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int iVersion
     * }
     */
    public static void iVersion(MemorySegment struct, int fieldValue) {
        struct.set(iVersion$LAYOUT, iVersion$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *))
     * }
     */
    public static class xCreateTokenizer {

        xCreateTokenizer() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3, MemorySegment _x4);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xCreateTokenizer.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xCreateTokenizer.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3, MemorySegment _x4) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xCreateTokenizer$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xCreateTokenizer"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *))
     * }
     */
    public static final AddressLayout xCreateTokenizer$layout() {
        return xCreateTokenizer$LAYOUT;
    }

    private static final long xCreateTokenizer$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *))
     * }
     */
    public static final long xCreateTokenizer$offset() {
        return xCreateTokenizer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *))
     * }
     */
    public static MemorySegment xCreateTokenizer(MemorySegment struct) {
        return struct.get(xCreateTokenizer$LAYOUT, xCreateTokenizer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*xCreateTokenizer)(fts5_api *, const char *, void *, fts5_tokenizer *, void (*)(void *))
     * }
     */
    public static void xCreateTokenizer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xCreateTokenizer$LAYOUT, xCreateTokenizer$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *)
     * }
     */
    public static class xFindTokenizer {

        xFindTokenizer() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xFindTokenizer.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xFindTokenizer.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xFindTokenizer$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xFindTokenizer"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *)
     * }
     */
    public static final AddressLayout xFindTokenizer$layout() {
        return xFindTokenizer$LAYOUT;
    }

    private static final long xFindTokenizer$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *)
     * }
     */
    public static final long xFindTokenizer$offset() {
        return xFindTokenizer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *)
     * }
     */
    public static MemorySegment xFindTokenizer(MemorySegment struct) {
        return struct.get(xFindTokenizer$LAYOUT, xFindTokenizer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*xFindTokenizer)(fts5_api *, const char *, void **, fts5_tokenizer *)
     * }
     */
    public static void xFindTokenizer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xFindTokenizer$LAYOUT, xFindTokenizer$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *))
     * }
     */
    public static class xCreateFunction {

        xCreateFunction() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3, MemorySegment _x4);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xCreateFunction.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xCreateFunction.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3, MemorySegment _x4) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xCreateFunction$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xCreateFunction"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *))
     * }
     */
    public static final AddressLayout xCreateFunction$layout() {
        return xCreateFunction$LAYOUT;
    }

    private static final long xCreateFunction$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *))
     * }
     */
    public static final long xCreateFunction$offset() {
        return xCreateFunction$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *))
     * }
     */
    public static MemorySegment xCreateFunction(MemorySegment struct) {
        return struct.get(xCreateFunction$LAYOUT, xCreateFunction$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*xCreateFunction)(fts5_api *, const char *, void *, fts5_extension_function, void (*)(void *))
     * }
     */
    public static void xCreateFunction(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xCreateFunction$LAYOUT, xCreateFunction$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction) (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction) (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

