package primer03Kalkulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Win extends Application {
    public int[] solution=new int[4];

    public Win(int[] solution){
        this.solution=solution;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        Label lblText = new Label();
        lblText.setText("Congratulations! You entered the correct solution!\n");
        lblText.setTextFill(Color.RED);
        Label lblText1 = new Label();
        lblText1.setText("Congratulations! You entered the correct solution!\n");
        root.getChildren().addAll(lblText);
        Scene scene = new Scene(root, 300, 100);

        // Napravljenu scenu postavljamo na pozornicu.
        stage.setScene(scene);
        
        scene.setFill(Color.RED);
        
        // Dajemo nasoj predstavi ime.
        stage.setTitle("End of game!");

        // Otvaramo zavesu.
        stage.show();
    }
}
