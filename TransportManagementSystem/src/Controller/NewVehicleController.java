package Controller;

import Model.Vehicle;
import Model.VehicleTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewVehicleController {
    @FXML
    private TextField tireSizeText;

    @FXML
    private TextField modelText;

    @FXML
    private TextField transmissionText;

    @FXML
    private TextField engineCCText;

    @FXML
    private TextField ownerNIDText;

    @FXML
    private TextField seatsText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField typeText;

    @FXML
    private TextField weightText;

    @FXML
    private TextField divisionText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField regNoText;

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            int regNo = Integer.parseInt(regNoText.getText().trim());
            String ownerNID = ownerNIDText.getText().trim();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String regDate = dateFormat.format(cal.getTime());
            cal.add(Calendar.DATE, 365);

            String model = modelText.getText().trim();
            String type = typeText.getText().trim();
            String taxValidityDate = dateFormat.format(cal.getTime());
            String fitnessValidityDate = dateFormat.format(cal.getTime());
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
            boolean success = VehicleTable.insertVehicle(vehicle);

            if (success){
                initialize();
                VehicleController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Vehicle");
                alert.setContentText("New Vehicle Insertion SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Vehicle");
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
        tireSizeText.clear();
        modelText.clear();
        transmissionText.clear();
        engineCCText.clear();
        ownerNIDText.clear();
        seatsText.clear();
        typeText.clear();
        weightText.clear();
        divisionText.clear();
        regNoText.clear();

        int regNo = VehicleTable.getFreeVehicleNo();
        regNoText.setText(Integer.toString(regNo));
        regNoText.setDisable(true);



    }

}
