package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReceiptPageController {
    @FXML
    private Button returnButton;


    @FXML
    public void returnButton(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();


        Stage prevStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        prevStage.close();

    }
}
