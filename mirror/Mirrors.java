package primer02Anagram;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Mirrors extends Application {
    private  int count=0;
    private boolean u1=false;
    private boolean u2=false;
    private boolean u3=false;
    private boolean u4=false;
    private boolean d1=false;
    private boolean d2=false;
    private boolean d3=false;
    private boolean d4=false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        Label lblText=new Label();
        Button retake=new Button("Retake a game!\n");

        Button up1=new Button();
        Button up2=new Button();
        Button up3=new Button();
        Button up4=new Button();

        Button left1=new Button();
        Button left2=new Button();
        Button left3=new Button();
        Button left4=new Button();

        Button right1=new Button();
        Button right2=new Button();
        Button right3=new Button();
        Button right4=new Button();


        Button button1=new Button();
        Button button2=new Button();
        Button button3=new Button();
        Button button4=new Button();
        Button button5=new Button();
        Button button6=new Button();
        Button button7=new Button();
        Button button8=new Button();
        Button button9=new Button();
        Button button10=new Button();
        Button button11=new Button();
        Button button12=new Button();
        Button button13=new Button();
        Button button14=new Button();
        Button button15=new Button();
        Button button16=new Button();

        Button down1=new Button();
        Button down2=new Button();
        Button down3=new Button();
        Button down4=new Button();



        up1.setPrefSize(100,100);
        up2.setPrefSize(100,100);
        up3.setPrefSize(100,100);
        up4.setPrefSize(100,100);

        up1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        up2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        up3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        up4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");

        left1.setPrefSize(100,100);
        left2.setPrefSize(100,100);
        left3.setPrefSize(100,100);
        left4.setPrefSize(100,100);

        left1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        left2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        left3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        left4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");

        right1.setPrefSize(100,100);
        right2.setPrefSize(100,100);
        right3.setPrefSize(100,100);
        right4.setPrefSize(100,100);

        right1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        right2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        right3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        right4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");

        /*
        GridPane up=new GridPane();

        up.add(up1, 0,0);
        up.add(up2, 1,0);
        up.add(up3, 2,0);
        up.add(up4, 3,0);
       */

        button1.setPrefSize(100,100);
        button2.setPrefSize(100,100);
        button3.setPrefSize(100,100);
        button4.setPrefSize(100,100);
        button5.setPrefSize(100,100);
        button6.setPrefSize(100,100);
        button7.setPrefSize(100,100);
        button8.setPrefSize(100,100);
        button9.setPrefSize(100,100);
        button10.setPrefSize(100,100);
        button11.setPrefSize(100,100);
        button12.setPrefSize(100,100);
        button13.setPrefSize(100,100);
        button14.setPrefSize(100,100);
        button15.setPrefSize(100,100);
        button16.setPrefSize(100,100);

        button1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button5.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button6.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button7.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button8.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button9.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button10.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button11.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button12.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button13.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button14.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button15.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
        button16.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");

        button1.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button2.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button3.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button4.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button5.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button6.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button7.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button8.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button9.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button10.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button11.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button12.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button13.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button14.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button15.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        button16.setFont(Font.font("Courier New", FontWeight.BOLD, 30));


        button1.setText("\\");
        button2.setText("/");

        button12.setText("/");
        button11.setText("/");
        button16.setText("/");
        button7.setText("/");
        button5.setText("/");

        GridPane gridPane=new GridPane();

        gridPane.add(up1,1,0);
        gridPane.add(up2, 2,0);
        gridPane.add(up3,3,0);
        gridPane.add(up4,4,0);

        gridPane.add(left1, 0,1);
        gridPane.add(right1, 5, 1);
        gridPane.add(button1,1,1);
        gridPane.add(button2, 2,1);
        gridPane.add(button3,3,1);
        gridPane.add(button4,4,1);

        gridPane.add(left2, 0,2);
        gridPane.add(right2, 5, 2);
        gridPane.add(button5,1,2);
        gridPane.add(button6, 2,2);
        gridPane.add(button7,3,2);
        gridPane.add(button8,4,2);

        gridPane.add(left3, 0,3);
        gridPane.add(right3, 5, 3);
        gridPane.add(button9,1,3);
        gridPane.add(button10, 2,3);
        gridPane.add(button11,3,3);
        gridPane.add(button12,4,3);

        gridPane.add(left4, 0,4);
        gridPane.add(right4, 5, 4);
        gridPane.add(button13,1,4);
        gridPane.add(button14, 2,4);
        gridPane.add(button15,3,4);
        gridPane.add(button16,4,4);




        down1.setPrefSize(100,100);
        down2.setPrefSize(100,100);
        down3.setPrefSize(100,100);
        down4.setPrefSize(100,100);

        down1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        down2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        down3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
        down4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");

        gridPane.add(down1, 1,5);
        gridPane.add(down2, 2,5);
        gridPane.add(down3, 3,5);
        gridPane.add(down4, 4
                ,5);

        retake.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(u1 && u2){
                    /*
                    //button1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                    up1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #FFFF00");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    button1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #FFFF00");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    button2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #FFFF00");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    up2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #FFFF00");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    */

                } else if(u3 && d1){

                } else if(u4 && d3){

                }

                u1=false;
                u2=false;
                u3=false;
                u4=false;
                d1=false;
                d2=false;
                d2=false;
                d2=false;
                up1.setDisable(false);
                up2.setDisable(false);
                up3.setDisable(false);
                up4.setDisable(false);
                down1.setDisable(false);
                down2.setDisable(false);
                down3.setDisable(false);
                down4.setDisable(false);
                lblText.setText("");
               /*
                up1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                up2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                up3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                up4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");

                button1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button5.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button6.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button7.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button8.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button9.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button10.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button11.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button12.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button13.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button14.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button15.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");
                button16.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #aabbaa");

                down1.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                down2.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                down3.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                down4.setStyle("-fx-border-color: #111111; -fx-border-width: 2px; -fx-background-color: #cccccc");
                */
                count=0;
            }
        });

        up1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                u1=true;
                up1.setDisable(true);
                count++;
                if(count==2 && u2==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        up2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
               u2=true;
               up2.setDisable(true);
               count++;
                if(count==2 && u1==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        up3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                u3=true;
                up3.setDisable(true);
                count++;
                if(count==2 && d1==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        up4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                u4=true;
                up4.setDisable(true);
                count++;
                if(count==2 && d3==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        down1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                d1=true;
                down1.setDisable(true);
                count++;
                if(count==2 && u3==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        down2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                d2=true;
                down2.setDisable(true);
                count++;
                if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        down3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                d3=true;
                down3.setDisable(true);
                count++;
                if(count==2 && u4==true){
                    lblText.setText("Well done! Your guess is correct!\n");
                } else if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });
        down4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                d4=true;
                down4.setDisable(true);
                count++;
                if(count==2){
                    lblText.setText("Sorry, but you have missed this time!!\n");
                }
            }
        });

        /*
        GridPane down=new GridPane();

        down.add(up1, 0,5);
        down.add(up2, 1,5);
        down.add(up3, 2,5);
        down.add(up4, 3,5);
        */

        lblText.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        retake.setAlignment(Pos.CENTER);

        root.getChildren().addAll(gridPane, lblText, retake);

        root.setAlignment(Pos.CENTER);



        Scene scene = new Scene(root, 1000, 1000);
        
        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Mirror game!");

        // Otvaramo zavesu.
        stage.show();
    }
}
