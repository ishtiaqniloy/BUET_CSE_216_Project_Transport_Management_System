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

public class UpdatePublicTransportController {

    @FXML
    private Button closeButton;

    @FXML
    private Button findButton;

    @FXML
    private TextField routeText;

    @FXML
    private TextField fareText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    private static boolean found = false;

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

            routeText.setDisable(false);
            routeText.setEditable(true);
            routeText.setText(publicTransport.getRoute());

            fareText.setDisable(false);
            fareText.setEditable(true);
            fareText.setText(Float.toString( publicTransport.getFare()));

           
            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update PublicTransport");
            alert.setContentText("Invalid Name");
            alert.showAndWait();
            found = false;
        }
    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update PublicTransport");
                alert.setContentText("Not Found Updatable PublicTransport Yet");
                alert.showAndWait();
                return;
            }

            String name = nameText.getText().trim();
            String route = routeText.getText().trim();
            float fare = Float.parseFloat(fareText.getText().trim());

            if(name.length() <= 0 || route.length() <= 0 || fare <=0){
                throw new Exception();
            }

            PublicTransport publicTransport = new PublicTransport(-1, name, route, fare);
            boolean success = PublicTransportTable.updatePublicTransport(publicTransport);

            if (success){
                initialize();
                PublicTransportController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update PublicTransport");
                alert.setContentText("PublicTransport Update SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update PublicTransport");
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
        nameText.clear();
        nameText.setDisable(false);
        nameText.setEditable(true);

        findButton.setDisable(false);
        saveButton.setDisable(true);

        routeText.clear();
        routeText.setDisable(true);
        fareText.clear();
        fareText.setDisable(true);

        found = false;

    }

}
