package Q8;

public class Player {

    //
    private String name;
    private int numOfGeusses;

    public Player(String name, int numOfGeusses){
        this.name = name;
        this.numOfGeusses = numOfGeusses;
    }

    public String getName(){
        return name;
    }
    public void incrementGeusses(){
        numOfGeusses ++;
    }
    public int getNumOfGeusses(){
        return numOfGeusses;
    }


}
