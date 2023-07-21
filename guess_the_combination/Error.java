package primer03Kalkulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Error extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        Label lblText = new Label();
        lblText.setText("You have entered too many options!\n");
        lblText.setTextFill(Color.RED);
        root.getChildren().addAll(lblText);
        Scene scene = new Scene(root, 300, 100);

        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("Error message");

        // Otvaramo zavesu.
        stage.show();
    }
}
