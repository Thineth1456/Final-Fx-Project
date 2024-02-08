package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SuperAdminDashboard {

    public BorderPane SuperAdmindash;
    public ImageView backbtnOnAction;

    public void backbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) SuperAdmindash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createuserbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) SuperAdmindash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CreateUser.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void regiUserbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) SuperAdmindash.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterUser.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void viewReportsBtnOnAction(ActionEvent actionEvent) {

    }
}
