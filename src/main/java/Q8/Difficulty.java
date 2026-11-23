package Q8;

public class Difficulty {

    /*
    difficulty is set by the range of numbers to guess and
    the number of trys they get before its game over
     */

    private int level;

    public Difficulty(int level){
        // do some validation such that level is only 1-3
        this.level =  Math.clamp(level, 1, 3);;
    }

    // returns two ints, first is the max number we can generate, second is the number of guesses we get
    public int getRange() throws Exception{
        return switch (level) {
            case 1 -> 20;
            case 2 -> 50;
            case 3 -> 100;
            default -> throw new Exception("Not a valid difficulty");
        };
    }
    public int getTries() throws Exception{
        return switch (level) {
            case 1 -> 7;
            case 2 -> 6;
            case 3 -> 5;
            default -> throw new Exception("Not a valid difficulty");
        };
    }
    public void setLevel(int level){
        // do some validation such that level is only 1-3
        this.level =  Math.clamp(level, 1, 3);
    }
    public int getLevel(){ return level; }

}
