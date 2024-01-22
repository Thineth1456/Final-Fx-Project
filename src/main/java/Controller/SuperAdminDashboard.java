package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SuperAdminDashboard {

    public AnchorPane SuAdminDash;

    public void bckbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) SuAdminDash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminLogin.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createuserbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) SuAdminDash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CreateUser.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void regiUserbtnOnAction(ActionEvent actionEvent) {

    }

    public void viewReportsBtnOnAction(ActionEvent actionEvent) {

    }
}
