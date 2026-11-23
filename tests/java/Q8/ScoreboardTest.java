package Q8;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreboardTest {

    @Test
    void startsEmptyAndAddsEntries() {
        Scoreboard scoreboard = new Scoreboard();

        assertTrue(scoreboard.getScoreBoard().isEmpty());
        scoreboard.addNewEntry("Alice", 4, 2);

        assertEquals(1, scoreboard.getScoreBoard().size());
        assertEquals("Alice", scoreboard.getScoreBoard().getFirst().name());
    }

    @Test
    void sortsEntriesByFewestGuesses() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.addNewEntry("Alice", 8, 1);
        scoreboard.addNewEntry("Bob", 3, 3);
        scoreboard.addNewEntry("Cara", 5, 2);

        assertEquals("Bob", scoreboard.getScoreBoard().getFirst().name());
        assertEquals("Cara", scoreboard.getScoreBoard().get(1).name());
        assertEquals("Alice", scoreboard.getScoreBoard().get(2).name());
    }

    @Test
    void tiesUseHighestDifficultyFirst() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.addNewEntry("Easy", 4, 1);
        scoreboard.addNewEntry("Hard", 4, 3);
        scoreboard.addNewEntry("Medium", 4, 2);

        assertEquals("Hard", scoreboard.getScoreBoard().getFirst().name());
        assertEquals("Medium", scoreboard.getScoreBoard().get(1).name());
        assertEquals("Easy", scoreboard.getScoreBoard().get(2).name());
    }

    @Test
    void sortMethodIsPrivateAndNoLongerNeedsManualInvocation() throws Exception {
        Method sortAsc = Scoreboard.class.getDeclaredMethod("sortAsc");
        assertTrue(java.lang.reflect.Modifier.isPrivate(sortAsc.getModifiers()));
    }
}
