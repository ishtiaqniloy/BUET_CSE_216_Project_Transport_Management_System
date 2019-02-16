package Controller;

import Model.DBUser;
import TransportManagementSystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    static String uName;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField usernameText;

    @FXML
    private Button loginButton;

    @FXML
    private Button newUserButton;

    @FXML
    private Label messageText;

    @FXML
    private Button exitButton;

    @FXML
    void loginFunc(ActionEvent event) {
        String username = usernameText.getText().trim();
        String password = passwordText.getText().trim();

        try {
            if(DBUser.validateLogin(username, password)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setContentText("LOGIN SUCCESSFUL");
                alert.showAndWait();

                uName = username;
                System.out.println(username);

                if(uName.equals("admin"))
                    Main.isAdmin = true;

                Stage stage = (Stage) newUserButton.getParent().getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("../View/Home.fxml"));

                stage.setTitle("Transport Management System - Home");
                stage.setMaximized(true);

//                String image = this.getClass().getResource("9.jpg").toExternalForm();
//                root.setStyle(" -fx-background-image: url('" + image + "');  "
//                        + "-fx-background-position: center center; "
//                        + "-fx-background-repeat: stretch;");

                stage.setScene(new Scene(root, Main.HomeWidth, Main.HomeHeight));
                stage.show();

            }
            else {
                usernameText.clear();
                passwordText.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setContentText("Invalid Username or Password");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void newUserFunc(ActionEvent event) {

        try {
            Stage stage = (Stage) newUserButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewUser.fxml"));
            stage.setTitle("Create New Users of Database");
            stage.setScene(new Scene(root, Main.LoginWidth, Main.LoginHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitFunc(ActionEvent event) {
        System.exit(0);
    }

    public void initialize(){
        uName = null;
        Main.isAdmin = false;
    }

}
