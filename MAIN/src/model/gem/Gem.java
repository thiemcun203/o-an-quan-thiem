package model.gem;

import model.board.Cell;

public abstract class Gem {

    private Cell cellType; // square or halfcircle

    public Gem(Cell cellType){
        this.cellType = cellType;
    }

    public Cell getcellType(){
        return cellType;
    }
    
    public abstract int getValue();

    
}
