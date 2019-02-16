package Controller;

import TransportManagementSystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label message1;

    @FXML
    private Button logOutButton;

    @FXML
    private Button serviceButton;

    @FXML
    private Button penaltyButton;

    @FXML
    private Button employeesButton;

    @FXML
    private Button reportButton;

    @FXML
    private Button historyButton;

    @FXML
    private Button ownerButton;

    @FXML
    private Button paymentButton;

    @FXML
    private Button applicationButton;

    @FXML
    private Button licenseButton;

    @FXML
    private Button vehicleButton;

    @FXML
    private Button driverButton;

    @FXML
    private Button summaryButton;

    @FXML
    private Button aboutButton;

    @FXML
    private Button publicTransportButton;

    @FXML
    void serviceFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) serviceButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Service.fxml"));
            stage.setTitle("Transport Management System - Services");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void penaltyFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) penaltyButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Penalty.fxml"));
            stage.setTitle("Transport Management System - Penalties");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void historyFunction(ActionEvent event) {
        try {
            Stage stage = (Stage) historyButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/History.fxml"));
            stage.setTitle("Transport Management System - History");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void employeesFunc(ActionEvent event) {
        if(!Main.isAdmin){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Employees");
            alert.setContentText("ONLY ADMIN CAN USE THIS OPTION");
            alert.showAndWait();
            return;
        }
        try {
            Stage stage = (Stage) employeesButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Employee.fxml"));
            stage.setTitle("Transport Management System - Employees");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reportFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) reportButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Report.fxml"));
            stage.setTitle("Transport Management System - Report");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ownerFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) ownerButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Owner.fxml"));
            stage.setTitle("Transport Management System - Owner");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void paymentFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) paymentButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Payment.fxml"));
            stage.setTitle("Transport Management System - Payment");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void vehicleFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) vehicleButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Vehicle.fxml"));
            stage.setTitle("Transport Management System - Vehicle");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void publicTransportFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) publicTransportButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/PublicTransport.fxml"));
            stage.setTitle("Transport Management System - Public Transport");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void driverFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) driverButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Driver.fxml"));
            stage.setTitle("Transport Management System - Driver");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void licenseFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) licenseButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/License.fxml"));
            stage.setTitle("Transport Management System - License");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void applicationFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) applicationButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Application.fxml"));
            stage.setTitle("Transport Management System - Application");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void aboutFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) applicationButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/About.fxml"));
            stage.setTitle("Transport Management System - About us");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void summaryFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) applicationButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Summary.fxml"));
            stage.setTitle("Transport Management System - Summary");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void logOutFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) logOutButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            stage.setTitle("Transport Management System - Login");
            stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialize(){
        message1.setText("Welcome User : " + LoginController.uName);

    }
}
