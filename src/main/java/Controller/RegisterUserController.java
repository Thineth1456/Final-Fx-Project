package Controller;

import Bo.custom.CreateUserBo;
import Bo.custom.RegisterUserBo;
import Bo.custom.impl.CreateUserBoImpl;
import Bo.custom.impl.RegisterUserBoImpl;
import dao.custom.Ipml.CreateUserDaoImpl;
import dto.CreateUserDto;
import dto.RegisterUserDto;
import dto.tm.CreateUserTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegisterUserController {



    @FXML
    private AnchorPane regiPane;


    @FXML
    private TableView<CreateUserTm> regiTable;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colname;

    @FXML
    private TableColumn colContactNo;

    @FXML
    private TableColumn colbtnR;

    @FXML
    private TableColumn colbtnD;

    private int path;





    @FXML
    private JFXButton backbtnOnAction;

    private CreateUserBo createUserBo = new CreateUserBoImpl();
    private RegisterUserBo registerUserBo = new RegisterUserBoImpl();
    public void initialize(){

       colId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
       colbtnR.setCellValueFactory(new PropertyValueFactory<>("btnR"));
        colbtnD.setCellValueFactory(new PropertyValueFactory<>("btnD"));
        loadCustomerTable();

    }

    private void loadCustomerTable() {

        ObservableList<CreateUserTm> tmlist = FXCollections.observableArrayList();


        try {
            List<CreateUserDto> dtoList = createUserBo.allUser();
            for (CreateUserDto dto : dtoList) {
                Button btnR = new Button("Register");
                Button btnD = new Button("Delete");
                CreateUserTm createUserTm = new CreateUserTm(
                        dto.getUserId(),
                        dto.getName(),
                        dto.getContactNo(),
                        btnR,
                        btnD
                );

                btnD.setOnAction(actionEvent -> {
                    path=1;
                    deleteUser(createUserTm.getUserId(),path);
                });

                btnR.setOnAction(actionEvent -> {
                    try {
                        registerUser(createUserTm.getUserId(),dtoList);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                });

                tmlist.add(createUserTm);
            }
            System.out.println(tmlist);
            CreateUserDto createUserDto = new CreateUserDaoImpl().getLastUser();
            System.out.println(createUserDto);
            regiTable.setItems(tmlist);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void registerUser(String userId, List<CreateUserDto> dtoList) throws ClassNotFoundException, SQLException {

        for (CreateUserDto dto:dtoList) {
            if (userId.equals(dto.getUserId())){
                RegisterUserDto registerUserDto = new RegisterUserDto(
                        dto.getUserId(),
                        dto.getName(),
                        dto.getContactNo(),
                        dto.getEmail(),
                        dto.getPassword());
                boolean isRegistered = registerUserBo.registerUser(registerUserDto);
                if (isRegistered){
                    new Alert(Alert.AlertType.INFORMATION,"User Register Success!").show();
                    deleteUser(userId, path);
                    loadCustomerTable();

                }else{
                    new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
                }


            }

        }

    }

    private void deleteUser(String userId, int path) {
        try {
            boolean isDeleted = createUserBo.deleteUser(userId);
            if (isDeleted){
                if (path==1) {
                    new Alert(Alert.AlertType.INFORMATION, "User Deleted!").show();
                }
                loadCustomerTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void bckbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) regiPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SuperAdminDashboard.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
