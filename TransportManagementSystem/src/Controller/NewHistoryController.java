package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewHistoryController {
    private static final int VSH = 1;
    private static final int LSH = 2;
    private static final int PH = 3;

    @FXML
    private Button findButton;

    @FXML
    private TextField nameText;

    @FXML
    private MenuItem penaltyHistoryItem;

    @FXML
    private MenuButton typeMenu;

    @FXML
    private TextField entryNoText;

    @FXML
    private MenuItem licenseHistoryItem;

    @FXML
    private Button closeButton;

    @FXML
    private TextField amountText;

    @FXML
    private TextField vehicleRegNoText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField idText;

    @FXML
    private MenuItem vehicleHistoryItem;

    @FXML
    private TextField licenseNoText;

    private int type;

    @FXML
    void selectVehicleHistoryFunc(ActionEvent event) {
        typeMenu.setText("Vehicle Service");
        type = VSH;
        int newEntryNo = HistoryTables.getFreeEntryNo(type);
        entryNoText.setText(Integer.toString(newEntryNo));
        idText.setDisable(false);
        findButton.setDisable(false);

    }

    @FXML
    void selectLicenseHistoryFunc(ActionEvent event) {
        typeMenu.setText("License Service");
        type = LSH;
        int newEntryNo = HistoryTables.getFreeEntryNo(type);
        entryNoText.setText(Integer.toString(newEntryNo));
        idText.setDisable(false);
        findButton.setDisable(false);
    }


    @FXML
    void selectPenaltyHistoryFunc(ActionEvent event) {
        typeMenu.setText("Penalty");
        type = PH;
        int newEntryNo = HistoryTables.getFreeEntryNo(type);
        entryNoText.setText(Integer.toString(newEntryNo));
        idText.setDisable(false);
        findButton.setDisable(false);

    }

    @FXML
    void findFunc(ActionEvent event) {
        try{
            int id = Integer.parseInt(idText.getText().trim()) ;

            if (type == VSH || type == LSH){
                Service service = ServiceTable.findService(id);

                if (service == null || ( type == VSH && !service.getType().equals("Vehicle")) || ( type == LSH && !service.getType().equals("License")) ){
                    throw new Exception();
                }

                nameText.setText(service.getName());
                amountText.setText(Float.toString(service.getFee()));
            }

            else{
                Penalty penalty = PenaltyTable.findPenalty(id);
                if(penalty == null){
                    throw new Exception();
                }
                nameText.setText(penalty.getName());
                amountText.setText(Float.toString(penalty.getFine()));

                vehicleRegNoText.setDisable(false);
                licenseNoText.setDisable(false);
            }

            if(type == VSH){
                vehicleRegNoText.setDisable(false);
            }
            else if(type == LSH){
                licenseNoText.setDisable(false);
            }

            saveButton.setDisable(false);


        }catch (Exception e){
            //initialize();
            idText.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New History Entry");
            alert.setContentText("Invalid Data");
            alert.showAndWait();
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            int entryNo = Integer.parseInt(entryNoText.getText().trim());
            int id = Integer.parseInt(idText.getText().trim());
            int vRegNo = -1, licenseNo = -1;

            if(type != LSH) vRegNo = Integer.parseInt(vehicleRegNoText.getText().trim());
            if(type != VSH) licenseNo = Integer.parseInt(licenseNoText.getText().trim());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            //System.out.println(dateFormat.format(cal.getTime()));
            String date = dateFormat.format(cal.getTime());

            HistoryItem historyItem = new HistoryItem(entryNo, id, null, -1, vRegNo, licenseNo, date, "Due", -1);
            boolean success = HistoryTables.insertHistoryEntry(type, historyItem);

            if(success){
                initialize();
                HistoryController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New History Entry");
                alert.setContentText("SUCCESS");
            }

            else{
                throw new Exception();
            }



        }catch (Exception e){
            //initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New History Entry");
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
        type = -1;

        typeMenu.setText("Type");
        entryNoText.clear();
        idText.clear();
        nameText.clear();
        amountText.clear();
        vehicleRegNoText.clear();
        licenseNoText.clear();

        entryNoText.setDisable(true);
        idText.setDisable(true);
        nameText.setDisable(true);
        amountText.setDisable(true);
        vehicleRegNoText.setDisable(true);
        licenseNoText.setDisable(true);

        findButton.setDisable(true);
        saveButton.setDisable(true);



    }



}
