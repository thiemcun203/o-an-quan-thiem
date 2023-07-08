package model.player;

import java.util.Random;

import model.board.Cell;

public class Player { //set action with board
    private static int score1 = 0;
    private static int score2 = 0;
    private String player1;
    private String player2;
    private int turn;
    private String currentPlayer;
    private Cell cellChosen;
    private int direction;
    
    public Player(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public Cell getCellChosen(){
        return cellChosen;
    }

    public void setCellChosen(Cell cellChosen){
        this.cellChosen = cellChosen;
    }

    public int getTurn(){
        Random random = new Random();

        // Generate a random number between 1 and 2 (inclusive)
        int randomNumber = random.nextInt(2) + 1;
        return randomNumber;
    }
    
    public void setTurn(int turn){
        this.turn = turn;
    }

    
    public void switchTurn(){
        if (getTurn() == 1){
            setTurn(2);
        }
        else{
            setTurn(1);
        }
    }

    public int earnScore(Cell earnedCell){
        int sum = 0;
        for (int i = 0; i < earnedCell.getGemList().size(); i++){
            sum += earnedCell.getGemList().get(i).getValue();
        return sum ;
    }

    public void computeScore(String player){
        if (player == player1){
            score1 = score1 + earnScore();
        }
        else if (player == player2){
            score2 = score2 + earnScore();
        }

    }

    public void spreadGems(Cell cellChosen){

    }

    

    




    


}
