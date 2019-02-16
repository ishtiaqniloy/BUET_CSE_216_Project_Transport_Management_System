package Controller;

import Model.Owner;
import Model.OwnerTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewOwnerController {
    @FXML
    private TextField nidText;

    @FXML
    private Button closeButton;

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

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            String NID = nidText.getText().trim();
            String name = nameText.getText().trim();
            String address = addressText.getText().trim();
            String eTIN = eTINText.getText().trim();
            String mobileNo = mobileNoText.getText().trim();
            int numberOfVehicles = 0;


            if(NID.length()==0||name.length()==0||address.length()==0||eTIN.length()==0||mobileNo.length()==0){
                throw new Exception();
            }

            Owner owner = new Owner(NID, name, address, eTIN, mobileNo, numberOfVehicles);
            boolean success = OwnerTable.insertOwner(owner);

            if (success){
                initialize();
                OwnerController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Owner");
                alert.setContentText("New Owner Insertion SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Owner");
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
        nameText.clear();
        addressText.clear();
        eTINText.clear();
        mobileNoText.clear();
    }

}
