package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateUserController {

    public AnchorPane createUser;

    public void bckbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) createUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CreateUserOnAction(ActionEvent actionEvent) {

    }
}
