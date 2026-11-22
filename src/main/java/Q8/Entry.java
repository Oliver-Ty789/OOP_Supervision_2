package Q8;

public record Entry(String name, int numOfGuesses) {

    /*
    a single record for one play session,
    numOfGuesses is then sorted in Scoreboard
     */

    // some validation to make sure every entry has a valid numOfGuesses
    public Entry {
        if (numOfGuesses < 0){
            numOfGuesses = 0;
        }
    }
}
