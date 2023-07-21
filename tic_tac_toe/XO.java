package primer01helloJavaFX;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import primer03Kalkulator.Error;


public class XO extends Application {
    int player=1;
    int moves=0;
    int[][] board=new int[3][3];
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("  ");
        Button button2 = new Button("  ");
        Button button3 = new Button("  ");
        Button button4 = new Button("  ");
        Button button5 = new Button("  ");
        Button button6 = new Button("  ");
        Button button7 = new Button("  ");
        Button button8 = new Button("  ");
        Button button9 = new Button("  ");
        button1.setPrefSize(200,200);
        button2.setPrefSize(200,200);
        button3.setPrefSize(200,200);
        button4.setPrefSize(200,200);
        button5.setPrefSize(200,200);
        button6.setPrefSize(200,200);
        button7.setPrefSize(200,200);
        button8.setPrefSize(200,200);
        button9.setPrefSize(200,200);
        //button1.setPrefSize(40,40);
        button1.setTextFill(Color.BLUE);
        /*
        button1.setStyle("-fx-background-color: #aabbaa");
        button2.setStyle("-fx-background-color: #aaffaa");
        button3.setStyle("-fx-background-color: #abff12");
        button4.setStyle("-fx-background-color: #ddaf33");
        button5.setStyle("-fx-background-color: #eeffee");
        button6.setStyle("-fx-background-color: #abcdef");
        button7.setStyle("-fx-background-color: #111111");
        button8.setStyle("-fx-background-color: #05cc55");
        button9.setStyle("-fx-background-color: #00ffff");
        */
        button1.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button2.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button3.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button4.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button5.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button6.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button7.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button8.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        button9.setFont(Font.font("Courier New", FontWeight.BOLD, 50));


        button1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button5.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button6.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button7.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button8.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button9.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");

        //button1.getText();



        GridPane gridPane = new GridPane();
        gridPane.resize(600,600);

        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);
        gridPane.add(button7, 0, 2, 1, 1);
        gridPane.add(button8, 1, 2, 1, 1);
        gridPane.add(button9, 2, 2, 1, 1);


        button1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button1.setText("X");
                    board[0][0]=1;
                    player=0;
                } else {
                    button1.setText("O");
                    board[0][0]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                      WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                      WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button1.setDisable(true);
            }
        });
        button2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button2.setText("X");
                    board[0][1]=1;
                    player=0;
                } else {
                    button2.setText("O");
                    board[0][1]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button2.setDisable(true);
            }
        });
        button3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button3.setText("X");
                    board[0][2]=1;
                    player=0;
                } else {
                    button3.setText("O");
                    board[0][2]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button3.setDisable(true);
            }

        });
        button4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button4.setText("X");
                    board[1][0]=1;
                    player=0;
                } else {
                    button4.setText("O");
                    board[1][0]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button4.setDisable(true);
            }

        });
        button5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button5.setText("X");
                    board[1][1]=1;
                    player=0;
                } else {
                    button5.setText("O");
                    board[1][1]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button5.setDisable(true);
            }

        });
        button6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button6.setText("X");
                    board[1][2]=1;
                    player=0;
                } else {
                    button6.setText("O");
                    board[1][2]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button6.setDisable(true);
            }

        });
        button7.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button7.setText("X");
                    board[2][0]=1;
                    player=0;
                } else {
                    button7.setText("O");
                    board[2][0]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button7.setDisable(true);
            }

        });
        button8.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button8.setText("X");
                    board[2][1]=1;
                    player=0;
                } else {
                    button8.setText("O");
                    board[2][1]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button8.setDisable(true);
            }

        });
        button9.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(player==1) {
                    button9.setText("X");
                    board[2][2]=1;
                    player=0;
                } else {
                    button9.setText("O");
                    board[2][2]=2;
                    player=1;
                }
                moves++;
                int winner=getWinner();
                if(winner!=0){
                    if(winner==1){
                        WinX win=new WinX();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        WinO win=new WinO();
                        try {
                            win.start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(moves==9){
                    Tie tie = new Tie();
                    try {
                        tie.start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                button9.setDisable(true);
            }

        });

        Scene scene = new Scene(gridPane, 600, 600);

        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Pecika");

        // Otvaramo zavesu.
        stage.show();

    }

    private int getWinner() {
        int result=0;
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                result=board[i][0];
                break;
            }
        }
        if(result!=0)
            return result;
        for(int i=0;i<3;i++){
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                result=board[0][i];
                break;
            }
        }
        if(result!=0)
            return result;

        if(board[0][0]!=0 && board[0][0]==board[1][1] && board[1][1]==board[2][2])
            result=board[0][0];

        if(result!=0)
            return result;

        if(board[0][2]!=0 && board[0][2]==board[1][1] && board[1][1]==board[2][0])
            result=board[0][2];

        return result;
    }
}
