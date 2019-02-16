package Controller;

import Model.Penalty;
import Model.PenaltyTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdatePenaltyController {


    @FXML
    private TextField sectionText;

    @FXML
    private TextField fineText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField pidText;

    @FXML
    private Button findButton;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    private boolean found = false;

    @FXML
    void findFunc(ActionEvent event) {
        try {
            int PID = Integer.parseInt( pidText.getText().trim());
            Penalty p = PenaltyTable.findPenalty(PID);
            if(p==null){
                throw new Exception();
            }

            pidText.setDisable(true);
            pidText.setEditable(false);

            findButton.setDisable(true);
            saveButton.setDisable(false);

            sectionText.setDisable(false);
            sectionText.setEditable(true);
            sectionText.setText(p.getSection());

            nameText.setDisable(false);
            nameText.setEditable(true);
            nameText.setText(p.getName());

            fineText.setDisable(false);
            fineText.setEditable(true);
            fineText.setText(Float.toString(p.getFine()));

            found = true;
        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Penalty");
            alert.setContentText("Invalid PID");
            alert.showAndWait();
            found = false;
        }

    }

    @FXML
    void saveFunc(ActionEvent event) {
        try {
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update Penalty");
                alert.setContentText("Not Found Updatable Penalty Yet");
                alert.showAndWait();
                return;
            }

            int PID = Integer.parseInt( pidText.getText().trim());
            String section = sectionText.getText().trim();
            String name = nameText.getText().trim();
            float fine = Float.parseFloat(fineText.getText().trim());

            if(PID <=0 || fine <=0 || name.length()<=0 || section.length()<=0){
                throw new Exception();
            }

            Penalty penalty = new Penalty(PID, section,  name, fine);
            boolean success = PenaltyTable.updatePenalty(penalty);

            if (success){
                initialize();
                PenaltyController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Penalty");
                alert.setContentText("Update Penalty SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Penalty");
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
        pidText.clear();
        pidText.setDisable(false);
        pidText.setEditable(true);
        findButton.setDisable(false);
        saveButton.setDisable(true);
        nameText.clear();
        nameText.setDisable(true);
        sectionText.clear();
        sectionText.setDisable(true);
        fineText.clear();
        fineText.setDisable(true);

        found = false;

    }



}
