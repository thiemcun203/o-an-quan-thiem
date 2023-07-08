package model.gem;

import model.board.Cell;

public class SmallGem extends Gem{

    private final int value = 1;

    public SmallGem(Cell cellType){
        super(cellType);
    }
    
    public int getValue(){
        return value;
    }
    
}
