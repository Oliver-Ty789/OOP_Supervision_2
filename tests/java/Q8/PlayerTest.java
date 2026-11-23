package Q8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void storesNameAndInitialGuessCount() {
        Player player = new Player("Alice");

        assertEquals("Alice", player.getName());
        assertEquals(0, player.getNumOfGuesses());
    }

    @Test
    void incrementGuessesIncreasesCountByOne() {
        Player player = new Player("Bob");

        player.incrementGuesses();

        assertEquals(1, player.getNumOfGuesses());
    }

    @Test
    void incrementGuessesTracksMultipleGuesses() {
        Player player = new Player("Cara");

        player.incrementGuesses();
        player.incrementGuesses();
        player.incrementGuesses();

        assertEquals(3, player.getNumOfGuesses());
    }
}
