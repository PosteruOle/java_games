package primer02Anagram;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import primer03Kalkulator.Error;

public class PetarsGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root =new VBox(20);
        Label lblText=new Label("Welcome to mirror game! We are still figuring things out! The game is about to start soon!\n");
        lblText.setAlignment(Pos.CENTER);
        Button btStartGame=new Button("Start the game!");
        btStartGame.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblText, btStartGame);
        root.setAlignment(Pos.CENTER);

        //btStartGame.setOnMouseClicked();
        btStartGame.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                 Mirrors game=new Mirrors();
                try {
                    game.start(stage);
                } catch (Exception e) {
                    System.out.println("Unsuccessfull game call!\n");
                    System.exit(1);
                }
            }
        });

        Scene scene = new Scene(root, 600, 600);
        // Napravljena scenu postavljamo na pozornicu.
        stage.setScene(scene);
        scene.setFill(Color.RED);
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Pecika");

        // Otvaramo zavesu.
        stage.show();
    }
}
