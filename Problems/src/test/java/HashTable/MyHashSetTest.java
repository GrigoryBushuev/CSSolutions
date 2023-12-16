package HashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    @Test
    void add() {
        var sut = new MyHashSet();
        sut.add(1);
        sut.add(2);
        sut.add(3);
    }

    @Test
    void contains() {
        var sut = new MyHashSet();
        sut.add(1);

        assertTrue(sut.contains(1));
        assertFalse(sut.contains(2));
    }

    @Test
    void remove() {
        var sut = new MyHashSet();
        sut.add(1);
        sut.add(2);
        sut.add(3);

        sut.remove(2);

        assertTrue(sut.contains(1));
        assertFalse(sut.contains(2));
    }
}