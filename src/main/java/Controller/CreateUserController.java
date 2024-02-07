package Controller;

import Bo.custom.CreateUserBo;
import Bo.custom.impl.CreateUserBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.custom.Ipml.CreateUserDaoImpl;
import dto.CreateUserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class CreateUserController {

    public AnchorPane createUser;
    public JFXTextField contactnotxt;
    public JFXTextField usernametxt;
    public JFXTextField emailtxt;
    public JFXPasswordField passwordtxt;
    public JFXButton backbtnOnAction;
    public JFXTextField userIdtxt;

    private CreateUserBo createUserBo = new CreateUserBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        userIdtxt.setText(createUserBo.generateId());
        userIdtxt.setEditable(false);
    }
    public void bckbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) createUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CreateUserOnAction(ActionEvent actionEvent) throws SQLIntegrityConstraintViolationException, ClassNotFoundException, SQLException {
        CreateUserDto dto = new CreateUserDto(
                userIdtxt.getText(),
                usernametxt.getText(),
                contactnotxt.getText(),
                emailtxt.getText(),
                passwordtxt.getText()
        );

        boolean isSaved = createUserBo.saveCreateUser(dto);
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"User Saved!").show();

        }
        clearFields();


    }

    private void clearFields() throws SQLException, ClassNotFoundException {
        userIdtxt.clear();
        usernametxt.clear();
        contactnotxt.clear();
        emailtxt.clear();
        passwordtxt.clear();
        userIdtxt.setText(createUserBo.generateId());
    }
}
