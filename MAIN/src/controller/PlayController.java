package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.board.Board;
import model.board.Cell;
import model.player.Player;

public class PlayController{

    public PlayController() {
    }

    @FXML
    private ImageView btnCCLCell01;

    @FXML
    private ImageView btnCCLCell02;

    @FXML
    private ImageView btnCCLCell03;

    @FXML
    private ImageView btnCCLCell04;

    @FXML
    private ImageView btnCCLCell05;

    @FXML
    private ImageView btnCCLCell07;

    @FXML
    private ImageView btnCCLCell08;

    @FXML
    private ImageView btnCCLCell09;

    @FXML
    private ImageView btnCCLCell10;

    @FXML
    private ImageView btnCCLCell11;

    @FXML
    private ImageView btnCLCell01;

    @FXML
    private ImageView btnCLCell02;

    @FXML
    private ImageView btnCLCell03;

    @FXML
    private ImageView btnCLCell04;

    @FXML
    private ImageView btnCLCell05;

    @FXML
    private ImageView btnCLCell07;

    @FXML
    private ImageView btnCLCell08;

    @FXML
    private ImageView btnCLCell09;

    @FXML
    private ImageView btnCLCell10;

    @FXML
    private ImageView btnCLCell11;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnHome;

    @FXML
    private Pane cell01;

    @FXML
    private Pane cell02;

    @FXML
    private Pane cell03;

    @FXML
    private Pane cell04;

    @FXML
    private Pane cell05;

    @FXML
    private Pane cell07;

    @FXML
    private Pane cell08;

    @FXML
    private Pane cell09;

    @FXML
    private Pane cell10;

    @FXML
    private Pane cell11;

    @FXML
    private Text numBigGem1;

    @FXML
    private Text numBigGem2;

    @FXML
    private Text scorePlayer1;

    @FXML
    private Text scorePlayer2;

    @FXML
    private ImageView turnPlayer1;

    @FXML
    private ImageView turnPlayer2;

    private List<Pane> listPaneOnPlayer1 = new ArrayList<Pane>();

    private List<Pane> listPaneOnPlayer2 = new ArrayList<Pane>();

    private Node chosen;

    



    @FXML
    public void initialize() {

        //set btnCL btnCCL invisible
        btnCLCell01.setVisible(false);
        btnCLCell02.setVisible(false);
        btnCLCell03.setVisible(false);
        btnCLCell04.setVisible(false);
        btnCLCell05.setVisible(false);
        btnCLCell07.setVisible(false);
        btnCLCell08.setVisible(false);
        btnCLCell09.setVisible(false);
        btnCLCell10.setVisible(false);
        btnCLCell11.setVisible(false);
        btnCCLCell01.setVisible(false);
        btnCCLCell02.setVisible(false);
        btnCCLCell03.setVisible(false);
        btnCCLCell04.setVisible(false);
        btnCCLCell05.setVisible(false);
        btnCCLCell07.setVisible(false);
        btnCCLCell08.setVisible(false);
        btnCCLCell09.setVisible(false);
        btnCCLCell10.setVisible(false);
        btnCCLCell11.setVisible(false);

        //set 2 frame invisible
        turnPlayer1.setVisible(false);
        turnPlayer2.setVisible(false);

        //add to list of pane
        listPaneOnPlayer1.add(cell01);
        listPaneOnPlayer1.add(cell02);
        listPaneOnPlayer1.add(cell03);
        listPaneOnPlayer1.add(cell04);
        listPaneOnPlayer1.add(cell05);
        listPaneOnPlayer2.add(cell07);
        listPaneOnPlayer2.add(cell08);
        listPaneOnPlayer2.add(cell09);
        listPaneOnPlayer2.add(cell10);
        listPaneOnPlayer2.add(cell11);

        // construct board
        Board board = new Board();

        //get real board
        Cell[] cells = board.getBoard();



        

       



        Player player = new Player("player1", "player2");
        int turn = player.getTurn();
        while (player.endGame() == false){
            if (turn == 1){
                turnPlayer1.setVisible(true);
                //set disable for cell on player 2
                for (Pane pane : listPaneOnPlayer2) {
                    pane.setDisable(true);
                }

                //get cells on player 1
                Cell[] cellsOnPlayer1 = board.getPlayer1Cells();

                //choose cell
                
                for (int i=0; i < cellsOnPlayer1.length; i++) {
                    final int index = i;
                    Pane pane = listPaneOnPlayer1.get(i);
                    pane.setOnMouseClicked(event -> {
                        //show direction
                        showDirection(pane);
                        System.out.println("Cell clicked");
                        //set cell chosen
                        Cell cellChosen = cellsOnPlayer1[index];
                        player.setCellChosen(cellChosen);
                        //set direction
                        List<Node> children = pane.getChildren();
                        for (Node child : children) {
                            if (child instanceof ImageView) {
                                ImageView imageView = (ImageView) child;
                                imageView.setOnMouseClicked(event1 -> {
                                    System.out.println("Direction clicked");
                                    //set direction
                                    chosen = child;
                                    //hide direction
                                    // hideDirection(pane);
                                });
                            }
                        }
                        if (chosen.getId().startsWith("btnCCL")) {
                            player.setDirection(0);
                        } else if (chosen.getId().startsWith("btnCL")) {
                            player.setDirection(1);
                        }
                        player.spreadGems(cellsOnPlayer1[index], player.getDirection());
                        player.switchTurn();
                        
                        //set disable for cell on player 1
                        for (Pane pane1 : listPaneOnPlayer1) {
                            pane1.setDisable(true);
                        }
                        //set enable for cell on player 2
                        for (Pane pane2 : listPaneOnPlayer2) {
                            pane2.setDisable(false);
                        }
                    });
                }

            }
            else{
                turnPlayer2.setVisible(true);
                //set disable for cell on player 1
                for (Pane pane : listPaneOnPlayer1) {
                    pane.setDisable(true);
                }

                //get cells on player 2
                Cell[] cellsOnPlayer2 = board.getPlayer2Cells();

                //choose cell
                
                for (int i=0; i < cellsOnPlayer2.length; i++) {
                    Pane pane = listPaneOnPlayer2.get(i);
                    pane.setOnMouseClicked(event -> {
                        //show direction
                        showDirection(pane);
                        System.out.println("");
                    });


        }
    }


    

        //set action for each cell
        for (Pane pane : listPaneOnPlayer1) {
            pane.setOnMouseClicked(event -> {
                showDirection(pane);
                System.out.println("Cell clicked");
            
            });
        }

        for (Pane pane : listPaneOnPlayer2) {
            pane.setOnMouseClicked(event -> {
                showDirection(pane);
                System.out.println("Cell clicked");
                //set cell chosen
                //set direction
            });
        }
    }
}
    

    public void showDirection(Pane pane) {
        // Retrieve the children of the Pane
        List<Node> children = pane.getChildren();

        // Loop through the children of the Pane
        for (Node child : children) {
            // Check if the child is an ImageView
            if (child instanceof ImageView) {
                ImageView imageView = (ImageView) child;
                // Set the visibility of the ImageView to true
                imageView.setVisible(true);
                //set action for child
                imageView.setOnMouseClicked(event -> {
                    System.out.println("Direction clicked");
                    pane.setVisible(false);
                });
                
            }
        }
    }

    public void hideDirection(Pane pane) {
        // Retrieve the children of the Pane
        List<Node> children = pane.getChildren();

        // Loop through the children of the Pane
        for (Node child : children) {
            // Check if the child is an ImageView
            if (child instanceof ImageView) {
                ImageView imageView = (ImageView) child;
                // Set the visibility of the ImageView to false
                imageView.setVisible(false);
            }
        }

        // Set the visibility of the Pane to false
        pane.setVisible(false);
    }


}

