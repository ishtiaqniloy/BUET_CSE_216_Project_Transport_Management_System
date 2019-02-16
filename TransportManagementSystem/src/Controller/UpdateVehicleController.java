package Controller;

import Model.Vehicle;
import Model.VehicleTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateVehicleController {

    @FXML
    private TextField tireSizeText;

    @FXML
    private TextField ownerNIDText;

    @FXML
    private TextField seatsText;

    @FXML
    private TextField weightText;

    @FXML
    private Button findButton;

    @FXML
    private TextField divisionText;

    @FXML
    private TextField regNoText;

    @FXML
    private TextField modelText;

    @FXML
    private TextField transmissionText;

    @FXML
    private TextField engineCCText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField typeText;

    @FXML
    private Button saveButton;

    private boolean found = false;

    private String regDate = null;
    private String taxValidityDate = null;
    private String fitnessValidityDate = null;

    @FXML
    void findFunc(ActionEvent event) {
        try {
            int regNO = Integer.parseInt( regNoText.getText().trim());
            Vehicle vehicle = VehicleTable.findVehicle(regNO);
            if(vehicle==null){
                throw new Exception();
            }

            regNoText.setDisable(true);
            regNoText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            ownerNIDText.setDisable(false);
            ownerNIDText.setEditable(true);
            ownerNIDText.setText(vehicle.getOwnerNID());

            modelText.setDisable(false);
            modelText.setEditable(true);
            modelText.setText(vehicle.getVehicleModel());

            typeText.setDisable(false);
            typeText.setEditable(true);
            typeText.setText(vehicle.getType());

            engineCCText.setDisable(false);
            engineCCText.setEditable(true);
            engineCCText.setText(Integer.toString(vehicle.getEngineCC()));

            seatsText.setDisable(false);
            seatsText.setEditable(true);
            seatsText.setText(Integer.toString(vehicle.getSeats()));

            tireSizeText.setDisable(false);
            tireSizeText.setEditable(true);
            tireSizeText.setText(Integer.toString(vehicle.getTireSize()));

            weightText.setDisable(false);
            weightText.setEditable(true);
            weightText.setText(Integer.toString(vehicle.getWeight()));

            transmissionText.setDisable(false);
            transmissionText.setEditable(true);
            transmissionText.setText(vehicle.getTransmission());

            divisionText.setDisable(false);
            divisionText.setEditable(true);
            divisionText.setText(Integer.toString(vehicle.getDivID()));

            regDate = vehicle.getRegDate();
            taxValidityDate = vehicle.getTaxValidityDate();
            fitnessValidityDate = vehicle.getFitnessValidityDate();
            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Vehicle");
            alert.setContentText("Invalid Reg no");
            alert.showAndWait();
            found = false;
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update Vehicle");
                alert.setContentText("Not Found Updatable Vehicle Yet");
                alert.showAndWait();
                return;
            }

            int regNo = Integer.parseInt(regNoText.getText().trim());
            String ownerNID = ownerNIDText.getText().trim();
            String model = modelText.getText().trim();
            String type = typeText.getText().trim();
            int engineCC = Integer.parseInt( engineCCText.getText().trim());
            int seats = Integer.parseInt(seatsText.getText().trim());
            int weight = Integer.parseInt(weightText.getText().trim());
            int tireSize = Integer.parseInt( tireSizeText.getText().trim());
            String transmission = transmissionText.getText().trim();
            int divID = Integer.parseInt(divisionText.getText().trim());

            if(regNo<=0||ownerNID.length()==0||regDate.length()==0||model.length()==0||type.length()==0||taxValidityDate.length()==0
                    ||fitnessValidityDate.length()==0||engineCC<=0||seats<=0||weight<=0||tireSize<=0||transmission.length()==0||divID<=0){
                throw new Exception();
            }

            Vehicle vehicle = new Vehicle(regNo, ownerNID, regDate, model, type, taxValidityDate, fitnessValidityDate, engineCC,
                    seats, weight, tireSize, transmission, divID);
            boolean success = VehicleTable.updateVehicle(vehicle);

            if (success){
                initialize();
                VehicleController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Vehicle");
                alert.setContentText("Vehicle Update SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Vehicle");
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
        regNoText.setEditable(true);

        findButton.setDisable(false);
        saveButton.setDisable(true);

        ownerNIDText.clear();
        ownerNIDText.setDisable(true);
        modelText.clear();
        modelText.setDisable(true);
        typeText.clear();
        typeText.setDisable(true);
        engineCCText.clear();
        engineCCText.setDisable(true);
        seatsText.clear();
        seatsText.setDisable(true);
        tireSizeText.clear();
        tireSizeText.setDisable(true);
        weightText.clear();
        weightText.setDisable(true);
        transmissionText.clear();
        transmissionText.setDisable(true);
        divisionText.clear();
        divisionText.setDisable(true);

        regDate = null;
        taxValidityDate = null;
        fitnessValidityDate = null;
        found = false;

    }


}
