package model.board;

import model.gem.*;


public class Board {
    private final int numSquares = 10;
    private final int numHalfCircles = 2;
    private final int numBigGems = 2;
    private final int numSmallGems = 50;
    private Cell[] cells; // list of all cells

    public int getNumSquares() {
        return numSquares;
    }

    public int getNumHalfCircles() {
        return numHalfCircles;
    }

    public int getNumSmallGems() {
        return numSmallGems;
    }

    public int getNumBigGems() {
        return numBigGems;
    }

    public Board() {
        initializeCells();
        addGemsToCells();
    }

    private void initializeCells() {
        cells = new Cell[numSquares + numHalfCircles];
        cells[0] = new HalfCircle(0, numBigGems / 2);
        cells[(numSquares + numHalfCircles) / 2] = new HalfCircle((numSquares + numHalfCircles) / 2, numBigGems / 2);
    }

    private void addGemsToCells() {
        cells[0].addGem(new BigGem(cells[0]));

        for (int i = 1; i <= numSquares / 2; i++) {
            cells[i] = new Square(i, numSmallGems / numSquares);
            for (int j = 0; j < cells[i].getNumberOfGems(); j++) {
                cells[i].addGem(new SmallGem(cells[i]));
            }
        }

        cells[(numSquares + numHalfCircles) / 2].addGem(new BigGem(cells[(numSquares + numHalfCircles) / 2]));

        for (int i = numSquares / 2 + 2; i <= numSquares + numHalfCircles - 1; i++) {
            cells[i] = new Square(i, numSmallGems / numSquares);
            for (int j = 0; j < cells[i].getNumberOfGems(); j++) {
                cells[i].addGem(new SmallGem(cells[i]));
            }
        }
    }

    public Cell[] getBoard() {
        return cells;
    }

    public Cell getNextCellCounterClockwise(Cell cell) {
        int position = cell.getPosition();
        int lastPosition = numSquares + numHalfCircles - 1;
        return cells[position == 0 ? lastPosition : position - 1];
    }

    public Cell getNextCellClockwise(Cell cell) {
        int position = cell.getPosition();
        int lastPosition = numSquares + numHalfCircles - 1;
        return cells[position == lastPosition ? 0 : position + 1];
    }
}
