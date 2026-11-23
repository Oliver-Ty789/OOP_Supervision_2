package Q8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntryTest {

    @Test
    void storesEntryValues() {
        Entry entry = new Entry("Alice", 4, 2);

        assertEquals("Alice", entry.name());
        assertEquals(4, entry.numOfGuesses());
        assertEquals(2, entry.level());
    }

    @Test
    void clampsNegativeGuessesToZero() {
        Entry entry = new Entry("Bob", -3, 1);

        assertEquals(0, entry.numOfGuesses());
    }

    @Test
    void supportsZeroGuesses() {
        Entry entry = new Entry("Cara", 0, 3);

        assertEquals(0, entry.numOfGuesses());
        assertEquals(3, entry.level());
    }
}
