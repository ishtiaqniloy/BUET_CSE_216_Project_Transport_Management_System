package Controller;

import Model.Driver;
import Model.DriverTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class UpdateDriverController {

    @FXML
    private TextField fathersNameText;

    @FXML
    private TextField nidText;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private Button closeButton;

    @FXML
    private Button findButton;

    @FXML
    private TextField addressText;

    @FXML
    private TextField bloodGroupText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField mobileNoText;

    @FXML
    private TextField licenseNoText;


    private boolean found = false;

    @FXML
    void findFunc(ActionEvent event) {
        try {
            long driverNID = Long.parseLong( nidText.getText().trim());
            Driver driver = DriverTable.findDriver(driverNID);
            if(driver==null){
                throw new Exception();
            }

            nidText.setDisable(true);
            nidText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            licenseNoText.setDisable(true);
            licenseNoText.setEditable(false);
            licenseNoText.setText(Long.toString(driver.getLicenseNo()));

            nameText.setDisable(false);
            nameText.setEditable(true);
            nameText.setText(driver.getName());

            fathersNameText.setDisable(false);
            fathersNameText.setEditable(true);
            fathersNameText.setText(driver.getFathersName());

            addressText.setDisable(false);
            addressText.setEditable(true);
            addressText.setText(driver.getAddress());

            birthDatePicker.setDisable(false);
            birthDatePicker.setEditable(true);
            LocalDate bld = LocalDate.parse(driver.getBirthDate());
            birthDatePicker.setValue(bld);

            bloodGroupText.setDisable(false);
            bloodGroupText.setEditable(true);
            bloodGroupText.setText(driver.getBloodGroup());

            mobileNoText.setDisable(false);
            mobileNoText.setEditable(true);
            mobileNoText.setText(driver.getMobileNo());

            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Driver");
            alert.setContentText("Invalid NID");
            alert.showAndWait();
            found = false;
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update Driver");
                alert.setContentText("Not Found Updatable Driver Yet");
                alert.showAndWait();
                return;
            }

            long driverNID = Long.parseLong( nidText.getText().trim());
            long licenseNo = Long.parseLong( licenseNoText.getText().trim());
            String name = nameText.getText().trim();
            String fathersName = fathersNameText.getText().trim();
            String address = addressText.getText().trim();
            String birthDateString = birthDatePicker.getValue().toString();
            String bloodGroup = bloodGroupText.getText().trim();
            String mobileNo = mobileNoText.getText().trim();


            if(driverNID<=0||licenseNo<=0||name.length()==0||fathersName.length()==0||address.length()==0||birthDateString.length()==0||
                bloodGroup.length()==0||mobileNo.length()==0){
                throw new Exception();
            }

            Driver driver = new Driver(driverNID, licenseNo, name, fathersName, address, birthDateString, bloodGroup, mobileNo);
            boolean success = DriverTable.updateDriver(driver);

            if (success){
                initialize();
                DriverController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Driver");
                alert.setContentText("Driver Update SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Driver");
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
        nidText.clear();
        nidText.setDisable(false);
        nidText.setEditable(true);

        findButton.setDisable(false);
        saveButton.setDisable(true);

        licenseNoText.clear();
        licenseNoText.setDisable(true);
        nameText.clear();
        nameText.setDisable(true);
        fathersNameText.clear();
        fathersNameText.setDisable(true);
        addressText.clear();
        addressText.setDisable(true);
        birthDatePicker.setValue(null);
        birthDatePicker.setDisable(true);
        bloodGroupText.clear();
        bloodGroupText.setDisable(true);
        mobileNoText.clear();
        mobileNoText.setDisable(true);

        found = false;

    }


}
