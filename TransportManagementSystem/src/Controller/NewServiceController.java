package Controller;

import Model.Service;
import Model.ServiceTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewServiceController {
    @FXML
    private MenuItem licenseItem;

    @FXML
    private MenuButton typeMenu;

    @FXML
    private Button closeButton;

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

    private String type = null;

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            int SID = Integer.parseInt( sidText.getText().trim());
            String name = nameText.getText().trim();
            float fee = Float.parseFloat(feeText.getText().trim());

            if(type == null || SID <=0 || fee <=0 || name.length()<=0){
                throw new Exception();
            }

            Service service = new Service(SID, name, fee, type);

            boolean success = ServiceTable.insertService(service);

            if (success){
                initialize();
                ServiceController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Service");
                alert.setContentText("New Service Insertion SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Service");
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
        type = null;
        typeMenu.setText("Type");
        sidText.clear();
        nameText.clear();
        feeText.clear();

    }

}
