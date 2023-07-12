package model.board;

import java.util.ArrayList;
import model.gem.Gem;

public abstract class Cell {
    private int location;
    private int numberOfGems;
    private ArrayList<Gem> gemList = new ArrayList<Gem>();

    public Cell(int location, int numberOfGems) {
        this.location = location;
        this.numberOfGems = numberOfGems;
    }

    public Cell(int location) {
        this.location = location;
    }

    public ArrayList<Gem> getGemList() {
        return gemList;
    }

    public int getLocation() {
        return location;
    }

    public int getNumberOfGems() {
        return numberOfGems;
    }

    public void addGem(Gem gem) {
        this.gemList.add(gem);
    }

    public boolean isEmpty() {
        return this.getGemList().size() == 0;
    }

    public void setEmpty(){
        this.gemList.clear();
    }

    // public Gem moveGem() {
    //     if (gemList.isEmpty()) {
    //         // Handle the case when there are no gems in the cell
    //         // You can either return a default Gem object or throw an exception
    //         return null; // Or return a default Gem object
    //     } else {
    //         return gemList.remove(0); // Return the moved gem
    //     }
    // }
}