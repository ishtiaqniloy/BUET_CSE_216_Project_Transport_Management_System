package Controller;

import Model.EmployeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IncreaseSalaryController {
    @FXML
    private Button closeButton;

    @FXML
    private TextField percentage1Text;

    @FXML
    private TextField percentage2Text;

    @FXML
    private Button increaseButton;

    @FXML
    void increaseFunc(ActionEvent event) {
        try{

            float p1 = (float) ((Float) Float.parseFloat(percentage1Text.getText().trim()) / 100.0);
            float p2 =  (float) ((Float) Float.parseFloat(percentage2Text.getText().trim()) / 100.0);

            boolean success = EmployeeTable.increaseSalary(p1, p2);

            if(success){
                initialize();
                EmployeeController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Increase Employee Salary");
                alert.setContentText("SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Increase Employee Salary");
            alert.setContentText("Increment Error");
            alert.showAndWait();
        }
    }

    @FXML
    void closeFunc(ActionEvent event) {
        Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        percentage1Text.clear();
        percentage2Text.clear();
    }

}
