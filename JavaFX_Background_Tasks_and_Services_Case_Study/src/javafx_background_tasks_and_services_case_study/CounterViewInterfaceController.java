package javafx_background_tasks_and_services_case_study;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class CounterViewInterfaceController implements Initializable {

    @FXML
    private Label counterDisplay;
    @FXML
    private TextField counterValue;
    @FXML
    private Button startCountingButton;
    @FXML
    private ProgressBar prograssBar;

    Service<Long> counterService = new Counter();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //        subcribe the task
        counterService.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.counterDisplay.setText(String.valueOf(newValue));
        });
        
//      update progress bar
        this.prograssBar.progressProperty().bind(counterService.progressProperty());

    }

    @FXML
    private void startCountingButtonHandler(ActionEvent event) {
        this.count();
    }

    private void count() {
        String counterValue = this.counterValue.getText().trim();
        Long value = Long.parseLong(counterValue);

        ((Counter)this.counterService).setTarget(value);

        this.counterService.restart();

    }

}
