import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Kevin
 * @version 1.0
 */
public class Test extends Application {
    /**
     * main
     * @param args commandline args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Hello World Program (Lambda)");


        Button btn = new Button();
        btn.setText("Print Hello World!");
        btn.setOnAction(event -> System.out.println("Hello World!"));
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 300);
        mainStage.setScene(scene);
        mainStage.show();
    }
}