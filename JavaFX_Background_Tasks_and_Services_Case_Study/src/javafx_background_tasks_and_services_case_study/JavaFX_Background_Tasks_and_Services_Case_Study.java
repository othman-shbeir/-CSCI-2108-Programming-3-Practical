package javafx_background_tasks_and_services_case_study;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class JavaFX_Background_Tasks_and_Services_Case_Study extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CounterViewInterface.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("JavaFX Background Work: Task vs Service");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
