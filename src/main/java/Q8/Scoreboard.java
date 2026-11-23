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
    public void addNewEntry(String name, int numOfGuesses, int level){
        // sorts the new entry so that it is always in correct order
        listOfEntries.add(new Entry(name, numOfGuesses, level));
        sortAsc();
    }

    private void sortAsc(){
        // sorts all the entries such that the one with LEAST numOfGuesses is at the top and HIGHEST level
        listOfEntries.sort(Comparator.comparingInt(Entry::numOfGuesses)
                .thenComparing(Entry::level, Comparator.reverseOrder()));
    }





}
