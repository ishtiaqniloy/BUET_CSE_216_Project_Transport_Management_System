package Controller;

import Model.PublicTransport;
import Model.PublicTransportTable;
import Model.Vehicle;
import Model.VehicleTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPublicTransportController {

    @FXML
    private Button closeButton;

    @FXML
    private Button findButton;

    @FXML
    private TextField regNoText;

    @FXML
    private TextField routeText;

    @FXML
    private TextField fareText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    @FXML
    private Button verifyButton;

    private static boolean found = false;
    private static boolean verified = false;

    @FXML
    void verifyFunc(ActionEvent event) {
        try{
            int regNo = Integer.parseInt(regNoText.getText().trim());

            verified = PublicTransportTable.verifyPublicTransport(regNo);

            if(!verified){
                throw new Exception();
            }

            verifyButton.setDisable(true);
            findButton.setDisable(false);
            saveButton.setDisable(false);

            regNoText.setDisable(true);

            nameText.setDisable(false);
            nameText.setEditable(true);
            routeText.setDisable(false);
            routeText.setEditable(true);
            fareText.setDisable(false);
            fareText.setEditable(true);

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Public Transport");
            alert.setContentText("Invalid Reg No");
            alert.showAndWait();
            verified = false;
        }
    }


    @FXML
    void findFunc(ActionEvent event) {
        try {
            String name =  nameText.getText().trim();
            PublicTransport publicTransport = PublicTransportTable.findPublicTransport(name);
            if(publicTransport==null){
                throw new Exception();
            }

            nameText.setDisable(true);
            nameText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            routeText.setDisable(true);
            routeText.setText(publicTransport.getRoute());

            fareText.setDisable(true);
            fareText.setText(Float.toString( publicTransport.getFare()));

            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Public Transport");
            alert.setContentText("Invalid Name");
            alert.showAndWait();
            found = false;
        }
    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!verified){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Insert PublicTransport");
                alert.setContentText("Not Found Reg_No Yet");
                alert.showAndWait();
                return;
            }

            int regNo = Integer.parseInt(regNoText.getText().trim());
            String name = nameText.getText().trim();
            String route = routeText.getText().trim();
            float fare = Float.parseFloat(fareText.getText().trim());

            if(regNo <=0 || name.length() <= 0 || route.length() <= 0 || fare <=0){
                throw new Exception();
            }

            PublicTransport publicTransport = new PublicTransport(regNo, name, route, fare);
            boolean success = PublicTransportTable.insertPublicTransport(publicTransport);

            if (success){
                initialize();
                PublicTransportController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Insert PublicTransport");
                alert.setContentText("PublicTransport Insertion SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insert PublicTransport");
            alert.setContentText("Invalid Data");
            alert.showAndWait();
        }
    }

    @FXML
    void closeFunc(ActionEvent event) {
        Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        regNoText.clear();
        regNoText.setDisable(false);

        verifyButton.setDisable(false);
        findButton.setDisable(true);
        saveButton.setDisable(true);

        nameText.clear();
        nameText.setDisable(true);
        routeText.clear();
        routeText.setDisable(true);
        fareText.clear();
        fareText.setDisable(true);

        verified = false;
        found = false;

    }

}
