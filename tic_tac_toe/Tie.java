package primer01helloJavaFX;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tie extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        Label lblText = new Label();
        lblText.setText("Tie game!\n");
        lblText.setTextFill(Color.RED);
        Button btRetake= new Button("Retake a game!");

        root.getChildren().addAll(lblText, btRetake);
        Scene scene = new Scene(root, 300, 100);

        btRetake.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                XO new_game=new XO();
                try {
                    new_game.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Error message");

        // Otvaramo zavesu.
        stage.show();
    }
}
