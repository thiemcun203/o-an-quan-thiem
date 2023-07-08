package gem;

import gem.board.Cell;

public class BigGem extends Gem{
    
        private final int value = 5;
    
        public BigGem(Cell cellType){
            super(cellType);
        }
    
        public int getValue(){
            return value;
        }
    
}
