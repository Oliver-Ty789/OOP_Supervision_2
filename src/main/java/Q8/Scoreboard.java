package Q8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;

public class Scoreboard {

    // attributes
    // holds all the entries that is sorted
    private ArrayList<Entry> listOfEntries;

    // constructor
    public Scoreboard(){
        listOfEntries = new ArrayList<>();
    }

    // get and "set" methods
    public ArrayList<Entry> getScoreBoard(){
        return listOfEntries;
    }
    public void addNewEntry(String name, int numOfGuesses){
        listOfEntries.add(new Entry(name, numOfGuesses));
    }

    private void sortAsc(){
        // sorts all the entries such that the one with LEAST numOfGuesses is at the top
        listOfEntries.sort(Comparator.comparingInt(Entry::numOfGuesses));
    }





}
