package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    public AnchorPane maindashpane;

    public void userBtnOnAction(ActionEvent actionEvent) {

    }

    public void adminBtnOnAction(ActionEvent actionEvent) {

    }

    public void SuperAdminButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) maindashpane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminLogin.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
