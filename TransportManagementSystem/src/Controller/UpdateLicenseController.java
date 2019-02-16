package Controller;

import Model.License;
import Model.LicenseTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class UpdateLicenseController {

    @FXML
    private TextField divIDText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField typeText;

    @FXML
    private TextField statusText;

    @FXML
    private Button findButton;

    @FXML
    private TextField driverNIDText;

    @FXML
    private DatePicker issueDatePicker;

    @FXML
    private Button saveButton;

    @FXML
    private DatePicker validityDatePicker;

    @FXML
    private TextField licenseNoText;

    private static boolean found = false;

    @FXML
    void findFunc(ActionEvent event) {
        try {
            long licenseNo = Long.parseLong( licenseNoText.getText().trim());
            License license = LicenseTable.findLicense(licenseNo);
            if(license==null){
                throw new Exception();
            }

            licenseNoText.setDisable(true);
            licenseNoText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            driverNIDText.setDisable(true);
            driverNIDText.setEditable(false);
            driverNIDText.setText(Long.toString(license.getDriverNID()));

            issueDatePicker.setDisable(true);
            issueDatePicker.setEditable(false);
            LocalDate ild = LocalDate.parse(license.getIssueDate());
            issueDatePicker.setValue(ild);

            validityDatePicker.setDisable(true);
            validityDatePicker.setEditable(false);
            LocalDate vld = LocalDate.parse(license.getValidityDate());
            validityDatePicker.setValue(vld);

            typeText.setDisable(false);
            typeText.setEditable(true);
            typeText.setText(license.getType());

            divIDText.setDisable(false);
            divIDText.setEditable(true);
            divIDText.setText(Integer.toString(license.getDivID()));

            statusText.setDisable(false);
            statusText.setEditable(true);
            statusText.setText(license.getStatus());

            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update License");
            alert.setContentText("Invalid License No");
            alert.showAndWait();
            found = false;
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update License");
                alert.setContentText("Not Found Updatable License Yet");
                alert.showAndWait();
                return;
            }

            long licenseNo = Long.parseLong( licenseNoText.getText().trim());
            long driverNID = Long.parseLong( driverNIDText.getText().trim());
            String issueDate = issueDatePicker.getValue().toString();
            String validityDate = validityDatePicker.getValue().toString();
            String type = typeText.getText().trim();
            int divID = Integer.parseInt(divIDText.getText().trim());
            String status = statusText.getText().trim();


            if(driverNID<=0||licenseNo<=0||issueDate.length()==0||validityDate.length()==0||type.length()==0||divID<=0||status.length()==0){
                throw new Exception();
            }

            License license = new License(licenseNo,driverNID, issueDate, validityDate, type, divID, status);
            boolean success = LicenseTable.updateLicense(license);

            if (success){
                initialize();
                LicenseController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update License");
                alert.setContentText("License Update SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update License");
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
        licenseNoText.clear();
        licenseNoText.setDisable(false);
        licenseNoText.setEditable(true);

        findButton.setDisable(false);
        saveButton.setDisable(true);

        driverNIDText.clear();
        driverNIDText.setDisable(true);
        issueDatePicker.setValue(null);
        issueDatePicker.setDisable(true);
        validityDatePicker.setValue(null);
        validityDatePicker.setDisable(true);
        typeText.clear();
        typeText.setDisable(true);
        divIDText.clear();
        divIDText.setDisable(true);
        statusText.clear();
        statusText.setDisable(true);


        found = false;

    }


}
