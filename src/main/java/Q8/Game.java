package Q8;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {

    // contains fields of all the classes we use for the Game.
    // Game specific fields
    private int targetNumber;
    private int guess;
    private final Random rng = new Random();
    private final Scanner scanner = new Scanner(System.in);

    // class fields
    private Player player;
    private Difficulty difficulty = new Difficulty(1);
    private final Scoreboard scoreboard = new Scoreboard();

    // doesn't need a constructor as all fields are handled externally or in callable methods

    private void checkPlayersGuess(int guess) throws Exception{
        // increment player numOfGuesses
        // checks if guess is the same as the target number
        // if so, call win method
        // else if guess is lower, out lower
        // else out higher

        player.incrementGuesses();
        if (guess == targetNumber){
            win();
        }
        else if(guess < targetNumber){
            System.out.println("Too Low!");
        }
        else {
            System.out.println("Too High!");
        }
    }

    private void guessing() throws Exception{
        // if the number hasn't been guessed or ran out of tries

        // take player input, repeat if not valid
        for (int i = 0; i < difficulty.getTries(); i++){
            boolean isValidInput = false;
            while (!isValidInput){
                System.out.print("input your guess: ");
                // in case input is not an int
                try {
                    guess = scanner.nextInt();
                    isValidInput = true;
                }
                catch(Exception e){
                    System.out.println("not a valid input (make sure it's an int)");
                }
            }
            // check if guess == to targetNumber
            checkPlayersGuess(guess);
        }
        // tries are up so you have lost
        lose();
    }

    private void win() throws Exception{
        // give congrats and then output updated scoreboard
        // give option to try again or end game
        System.out.println("\nCongrats, You win!!");
        System.out.println("      Scoreboard!");
        scoreboard.addNewEntry(player.getName(), player.getNumOfGuesses(), difficulty.getLevel());

        for (Entry e : scoreboard.getScoreBoard()){
            System.out.println(e);
        }
        tryAgain();
    }

    private void lose() throws Exception{
        // give condolences and then output the same scoreboard
        // give option to try again or end game
        System.out.println("\nYou ran out of tries, unluckly!, the was number: " + targetNumber);
        System.out.println("       Scoreboard!");

        for (Entry e : scoreboard.getScoreBoard()){
            System.out.println(e);
        }
        tryAgain();
    }

    private void tryAgain() throws Exception{
        // can't figure out why, but it kept skipping this code so needed to add another scanner.nextLine()
        scanner.nextLine();
        while (true){
            // repeats until valid input
            System.out.print("\nDo you want to play again? (y/n): ");
            String answer = scanner.nextLine();
            if (Objects.equals(answer, "y")){
                // plays game again
                run();
            }
            else if (Objects.equals(answer, "n")){
                // else end game
                System.exit(0);
            }
            else {
                System.out.println("bro do you know where the y and n keys are on the keyboard?");
            }
        }

    }


    public void run() throws Exception {
        // we need to start and end the game in this method
        // 1. create the player + choose difficulty
        System.out.print("What's your name?: ");
        player = new Player(scanner.nextLine());
        System.out.print("What difficulty will you choose? (1/2/3): ");

        difficulty = new Difficulty(scanner.nextInt());

        // 3. make a random number to guess
        targetNumber = rng.nextInt(difficulty.getRange());

        // 4. run methods to check player guess
        guessing();
    }



}
