package model.gem;

import model.gem.board.Cell;

public abstract class Gem {

    private Cell cellType; // square or halfcircle

    public Gem(Cell cellType){
        this.cellType = cellType;
    }

    public Cell getcallType(){
        return cellType;
    }

    public abstract int getValue();

    
}
