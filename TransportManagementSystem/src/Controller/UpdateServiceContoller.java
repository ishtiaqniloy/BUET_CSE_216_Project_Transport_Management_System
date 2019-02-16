package Controller;

import Model.Service;
import Model.ServiceTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateServiceContoller {

    private String type = null;

    @FXML
    private MenuItem licenseItem;

    @FXML
    private MenuButton typeMenu;

    @FXML
    private Button closeButton;

    @FXML
    private Button findButton;

    @FXML
    private TextField sidText;

    @FXML
    private TextField nameText;

    @FXML
    private MenuItem vehicleItem;

    @FXML
    private Button saveButton;

    @FXML
    private TextField feeText;

    private boolean found = false;

    @FXML
    void findFunc(ActionEvent event) {
        try{
            int SID = Integer.parseInt( sidText.getText().trim());
            Service s = ServiceTable.findService(SID);
            if(s==null){
                throw new Exception();
            }

            sidText.setDisable(true);
            sidText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            nameText.setDisable(false);
            nameText.setEditable(true);
            nameText.setText(s.getName());

            feeText.setDisable(false);
            feeText.setEditable(true);
            feeText.setText(Float.toString(s.getFee()));

            type = s.getType();
            typeMenu.setDisable(false);
            typeMenu.setText(type);

            found = true;
        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Service");
            alert.setContentText("Invalid SID");
            alert.showAndWait();
            found = false;
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update Service");
                alert.setContentText("Not Found Updatable Service Yet");
                alert.showAndWait();
                return;
            }

            int SID = Integer.parseInt( sidText.getText().trim());
            String name = nameText.getText().trim();
            float fee = Float.parseFloat(feeText.getText().trim());

            if(type == null || SID <=0 || fee <=0 || name.length()<=0){
                throw new Exception();
            }

            Service service = new Service(SID, name, fee, type);
            boolean success = ServiceTable.updateService(service);

            if (success){
                initialize();
                ServiceController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Service");
                alert.setContentText("Update Service SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Service");
            alert.setContentText("Invalid Data");
            alert.showAndWait();
        }



    }

    @FXML
    void closeFunc(ActionEvent event) {
        Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
        stage.close();
    }

    @FXML
    void selectLicenseFunc(ActionEvent event) {
        type = "License";
        typeMenu.setText(type);
    }

    @FXML
    void selectVehicleFunc(ActionEvent event) {
        type = "Vehicle";
        typeMenu.setText(type);
    }

    public void initialize(){
        sidText.clear();
        sidText.setDisable(false);
        sidText.setEditable(true);
        findButton.setDisable(false);
        saveButton.setDisable(true);
        nameText.clear();
        nameText.setDisable(true);
        feeText.clear();
        feeText.setDisable(true);
        type = null;
        typeMenu.setText("Type");
        typeMenu.setDisable(true);

        found = false;

    }



}
