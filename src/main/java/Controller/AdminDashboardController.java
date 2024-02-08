package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {
    public BorderPane Admindash;

    public void viewReportsBtnOnAction(ActionEvent actionEvent) {

    }

    public void createuserbtnOnAction(ActionEvent actionEvent) {

        Stage stage = (Stage) Admindash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CreateUser.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void backbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) Admindash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
