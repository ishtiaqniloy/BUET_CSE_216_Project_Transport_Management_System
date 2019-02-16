package Controller;

import Model.Owner;
import Model.OwnerTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateOwnerController {


    @FXML
    private TextField nidText;

    @FXML
    private Button closeButton;

    @FXML
    private Button findButton;

    @FXML
    private TextField eTINText;

    @FXML
    private TextField addressText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField mobileNoText;

    private boolean found = false;
    private int numberOfVehicles = 0;

    @FXML
    void findFunc(ActionEvent event) {
        try {
            String NID = nidText.getText().trim();
            Owner owner = OwnerTable.findOwner(NID);
            if(owner==null){
                throw new Exception();
            }

            nidText.setDisable(true);
            nidText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            nameText.setDisable(false);
            nameText.setEditable(true);
            nameText.setText(owner.getName());

            addressText.setDisable(false);
            addressText.setEditable(true);
            addressText.setText(owner.getAddress());

            eTINText.setDisable(false);
            eTINText.setEditable(true);
            eTINText.setText(owner.getETIN());

            mobileNoText.setDisable(false);
            mobileNoText.setEditable(true);
            mobileNoText.setText(owner.getMobileNo());

            numberOfVehicles = owner.getNumberOfVehicles();
            found = true;
        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Owner");
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
                alert.setTitle("Update Owner");
                alert.setContentText("Not Found Updatable Owner Yet");
                alert.showAndWait();
                return;
            }

            String NID = nidText.getText().trim();
            String name = nameText.getText().trim();
            String address = addressText.getText().trim();
            String eTIN = eTINText.getText().trim();
            String mobileNo = mobileNoText.getText().trim();


            if(NID.length()==0||name.length()==0||address.length()==0||eTIN.length()==0||mobileNo.length()==0){
                throw new Exception();
            }

            Owner owner = new Owner(NID, name, address, eTIN, mobileNo, numberOfVehicles);
            boolean success = OwnerTable.updateOwner(owner);

            if (success){
                initialize();
                OwnerController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Owner");
                alert.setContentText("Update Owner SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Owner");
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

        nameText.clear();
        nameText.setDisable(true);
        addressText.clear();
        addressText.setDisable(true);
        eTINText.clear();
        eTINText.setDisable(true);
        mobileNoText.clear();
        mobileNoText.setDisable(true);

        numberOfVehicles = 0;
        found = false;

    }



}
