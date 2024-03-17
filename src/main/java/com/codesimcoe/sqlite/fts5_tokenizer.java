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
 * struct fts5_tokenizer {
 *     int (*xCreate)(void *, const char **, int, Fts5Tokenizer **);
 *     void (*xDelete)(Fts5Tokenizer *);
 *     int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int));
 * }
 * }
 */
public class fts5_tokenizer {

    fts5_tokenizer() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        sqlite3_h.C_POINTER.withName("xCreate"),
        sqlite3_h.C_POINTER.withName("xDelete"),
        sqlite3_h.C_POINTER.withName("xTokenize")
    ).withName("fts5_tokenizer");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    /**
     * {@snippet lang=c :
     * int (*xCreate)(void *, const char **, int, Fts5Tokenizer **)
     * }
     */
    public static class xCreate {

        xCreate() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, MemorySegment _x1, int _x2, MemorySegment _x3);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xCreate.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xCreate.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, int _x2, MemorySegment _x3) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xCreate$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xCreate"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*xCreate)(void *, const char **, int, Fts5Tokenizer **)
     * }
     */
    public static final AddressLayout xCreate$layout() {
        return xCreate$LAYOUT;
    }

    private static final long xCreate$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*xCreate)(void *, const char **, int, Fts5Tokenizer **)
     * }
     */
    public static final long xCreate$offset() {
        return xCreate$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*xCreate)(void *, const char **, int, Fts5Tokenizer **)
     * }
     */
    public static MemorySegment xCreate(MemorySegment struct) {
        return struct.get(xCreate$LAYOUT, xCreate$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*xCreate)(void *, const char **, int, Fts5Tokenizer **)
     * }
     */
    public static void xCreate(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xCreate$LAYOUT, xCreate$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*xDelete)(Fts5Tokenizer *)
     * }
     */
    public static class xDelete {

        xDelete() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.ofVoid(
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xDelete.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xDelete.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr,MemorySegment _x0) {
            try {
                 DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xDelete$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xDelete"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*xDelete)(Fts5Tokenizer *)
     * }
     */
    public static final AddressLayout xDelete$layout() {
        return xDelete$LAYOUT;
    }

    private static final long xDelete$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*xDelete)(Fts5Tokenizer *)
     * }
     */
    public static final long xDelete$offset() {
        return xDelete$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*xDelete)(Fts5Tokenizer *)
     * }
     */
    public static MemorySegment xDelete(MemorySegment struct) {
        return struct.get(xDelete$LAYOUT, xDelete$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*xDelete)(Fts5Tokenizer *)
     * }
     */
    public static void xDelete(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xDelete$LAYOUT, xDelete$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int))
     * }
     */
    public static class xTokenize {

        xTokenize() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, MemorySegment _x1, int _x2, MemorySegment _x3, int _x4, MemorySegment _x5);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER,
            sqlite3_h.C_INT,
            sqlite3_h.C_POINTER
        );

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = sqlite3_h.upcallHandle(xTokenize.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(xTokenize.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, int _x2, MemorySegment _x3, int _x4, MemorySegment _x5) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4, _x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout xTokenize$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("xTokenize"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int))
     * }
     */
    public static final AddressLayout xTokenize$layout() {
        return xTokenize$LAYOUT;
    }

    private static final long xTokenize$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int))
     * }
     */
    public static final long xTokenize$offset() {
        return xTokenize$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int))
     * }
     */
    public static MemorySegment xTokenize(MemorySegment struct) {
        return struct.get(xTokenize$LAYOUT, xTokenize$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*xTokenize)(Fts5Tokenizer *, void *, int, const char *, int, int (*)(void *, int, const char *, int, int, int))
     * }
     */
    public static void xTokenize(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(xTokenize$LAYOUT, xTokenize$OFFSET, fieldValue);
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
