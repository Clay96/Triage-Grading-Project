import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxml = getClass().getClassLoader().getResource("TriageHelp.fxml");
        Parent parent = FXMLLoader.load(fxml);
        Scene scene = new Scene(parent);

        primaryStage.setTitle("Working With Triage");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((e) -> System.exit(0));
        primaryStage.show();
    }
}
