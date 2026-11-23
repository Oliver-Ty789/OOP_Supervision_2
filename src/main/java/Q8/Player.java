package Q8;

public class Player {

    // name will never change so is immutable
    private final String name;
    private int numOfGuesses = 0;


    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void incrementGuesses(){
        numOfGuesses ++;
    }
    public int getNumOfGuesses(){return numOfGuesses; }


}
