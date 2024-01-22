package Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SuperAdminLogin {
    public JFXTextField txtusername;
    public JFXTextField txtpassword;



    public void bckbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) txtusername.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void submitBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) txtusername.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
