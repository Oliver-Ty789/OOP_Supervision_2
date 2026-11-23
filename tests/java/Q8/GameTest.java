package Q8;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void checkPlayersGuessReportsTooLowAndIncrementsPlayer() throws Exception {
        Game game = new Game();
        Player player = new Player("Alice");
        setField(game, "targetNumber", 50);
        setField(game, "player", player);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            invokeCheckPlayersGuess(game, 25);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals(1, player.getNumOfGuesses());
        assertTrue(output.toString().contains("Too Low!"));
    }

    @Test
    void checkPlayersGuessReportsTooHighAndIncrementsPlayer() throws Exception {
        Game game = new Game();
        Player player = new Player("Bob");
        setField(game, "targetNumber", 25);
        setField(game, "player", player);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            invokeCheckPlayersGuess(game, 50);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals(1, player.getNumOfGuesses());
        assertTrue(output.toString().contains("Too High!"));
    }

    private static void setField(Game game, String name, Object value) throws Exception {
        Field field = Game.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(game, value);
    }

    private static void invokeCheckPlayersGuess(Game game, int guess) throws Exception {
        Method method = Game.class.getDeclaredMethod("checkPlayersGuess", int.class);
        method.setAccessible(true);
        method.invoke(game, guess);
    }
}
