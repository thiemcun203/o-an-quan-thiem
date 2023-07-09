package model.board;

import java.util.ArrayList;
import model.gem.Gem;

public abstract class Cell {
    private int position;
    private int numberOfGems;
    private ArrayList<Gem> gemList = new ArrayList<Gem>();

    public Cell(int position, int numberOfGems) {
        this.position = position;
        this.numberOfGems = numberOfGems;
    }

    public Cell(int position) {
        this.position = position;
    }

    public ArrayList<Gem> getGemList() {
        return gemList;
    }

    public int getPosition() {
        return position;
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

}