package Controller;

import Model.Penalty;
import Model.PenaltyTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewPenaltyController {
    @FXML
    private TextField sectionText;

    @FXML
    private TextField fineText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField pidText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField nameText;

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            int PID = Integer.parseInt( pidText.getText().trim());
            String section = sectionText.getText().trim();
            String name = nameText.getText().trim();
            float fine = Float.parseFloat(fineText.getText().trim());

            if(PID <=0 || fine <=0 || name.length()<=0 || section.length() <= 0){
                throw new Exception();
            }

            Penalty penalty = new Penalty(PID, section,  name, fine);
            boolean success = PenaltyTable.insertPenalty(penalty);

            if (success){
                initialize();
                PenaltyController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Penalty");
                alert.setContentText("New Penalty Insertion SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Penalty");
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
        nameText.clear();
        fineText.clear();
        sectionText.clear();
    }

}
