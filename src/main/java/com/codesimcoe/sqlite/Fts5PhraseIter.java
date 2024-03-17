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
 * struct Fts5PhraseIter {
 *     const unsigned char *a;
 *     const unsigned char *b;
 * }
 * }
 */
public class Fts5PhraseIter {

    Fts5PhraseIter() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        sqlite3_h.C_POINTER.withName("a"),
        sqlite3_h.C_POINTER.withName("b")
    ).withName("Fts5PhraseIter");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout a$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("a"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const unsigned char *a
     * }
     */
    public static final AddressLayout a$layout() {
        return a$LAYOUT;
    }

    private static final long a$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const unsigned char *a
     * }
     */
    public static final long a$offset() {
        return a$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const unsigned char *a
     * }
     */
    public static MemorySegment a(MemorySegment struct) {
        return struct.get(a$LAYOUT, a$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const unsigned char *a
     * }
     */
    public static void a(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(a$LAYOUT, a$OFFSET, fieldValue);
    }

    private static final AddressLayout b$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("b"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const unsigned char *b
     * }
     */
    public static final AddressLayout b$layout() {
        return b$LAYOUT;
    }

    private static final long b$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const unsigned char *b
     * }
     */
    public static final long b$offset() {
        return b$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const unsigned char *b
     * }
     */
    public static MemorySegment b(MemorySegment struct) {
        return struct.get(b$LAYOUT, b$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const unsigned char *b
     * }
     */
    public static void b(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(b$LAYOUT, b$OFFSET, fieldValue);
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
