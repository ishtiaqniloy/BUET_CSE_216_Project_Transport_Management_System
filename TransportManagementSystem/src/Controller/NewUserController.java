package Controller;

import Model.DBUser;
import TransportManagementSystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NewUserController {

    @FXML
    private PasswordField newPasswordText;

    @FXML
    private TextField newUsernameText;

    @FXML
    private PasswordField adminPasswordText;

    @FXML
    private Button backButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField adminUsernameText;

    @FXML
    void createNewUserFunc(ActionEvent event) {
        try {
            String adminUsername = adminUsernameText.getText().trim();
            String adminPassword = adminPasswordText.getText().trim();

            if(!adminUsername.equals("admin") || !adminPassword.equals("admin")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Create New User");
                alert.setContentText("Invalid Admin Credentials");
                alert.showAndWait();
                adminUsernameText.clear();
                adminPasswordText.clear();
                return;
            }

            String newUsername = newUsernameText.getText().trim();
            String newPassword = newPasswordText.getText().trim();

            if(newUsername.length()==0 || newPassword.length()==0){
                throw new Exception();
            }

            boolean created = DBUser.createNewUser(newUsername, newPassword);

            if(created ){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create New User");
                alert.setContentText("SUCCESS");
                alert.showAndWait();
                newPasswordText.clear();
                newUsernameText.clear();
            }
            else {
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Create New User");
            alert.setContentText("Invalid New Username or Password");
            alert.showAndWait();
            newPasswordText.clear();
            newUsernameText.clear();
        }


    }

    @FXML
    void backFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) backButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            stage.setTitle("Transport Management System - Login");
            stage.setScene(new Scene(root, Main.LoginWidth, Main.LoginHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
