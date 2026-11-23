package Q8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyTest {

    @Test
    void clampsLevelToSupportedRange() throws Exception {
        Difficulty difficulty = new Difficulty(0);
        assertEquals(1, difficulty.getLevel());
        assertEquals(20, difficulty.getRange());
        assertEquals(7, difficulty.getTries());

        difficulty.setLevel(99);
        assertEquals(3, difficulty.getLevel());
        assertEquals(100, difficulty.getRange());
        assertEquals(5, difficulty.getTries());
    }

    @Test
    void providesMediumDifficultySettings() throws Exception {
        Difficulty difficulty = new Difficulty(2);

        assertEquals(2, difficulty.getLevel());
        assertEquals(50, difficulty.getRange());
        assertEquals(6, difficulty.getTries());
    }

    @Test
    void setLevelClampsBothBoundaries() throws Exception {
        Difficulty difficulty = new Difficulty(1);

        difficulty.setLevel(-10);
        assertEquals(1, difficulty.getLevel());
        assertEquals(20, difficulty.getRange());

        difficulty.setLevel(10);
        assertEquals(3, difficulty.getLevel());
        assertEquals(100, difficulty.getRange());
    }
}
