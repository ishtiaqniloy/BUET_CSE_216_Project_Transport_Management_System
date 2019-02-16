package Controller;

import Model.Employee;
import Model.EmployeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DeleteEmployeeController {

    @FXML
    private Button deleteButton;

    @FXML
    private TextField jobTypeText;

    @FXML
    private TextField divIDText;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private DatePicker hireDatePicker;

    @FXML
    private TextField eidText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField salaryText;

    @FXML
    private Button findButton;

    @FXML
    private TextField addressText;

    @FXML
    private TextField mobileText;

    @FXML
    private TextField nameText;


    private boolean found = false;

    @FXML
    void deleteFunc(ActionEvent event) {
        try{
            String EID = eidText.getText().trim();

            if(EID.length() == 0){
                throw new Exception();
            }

            boolean success = EmployeeTable.deleteEmployee(EID);

            if(success){
                initialize();
                EmployeeController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Employee");
                alert.setContentText("Delete Employee SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Employee");
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
    void findFunc(ActionEvent event) {
        try {
            String EID =  eidText.getText().trim();

            Employee employee = EmployeeTable.findEmployee(EID);

            if(employee==null){
                throw new Exception();
            }

            eidText.setDisable(true);
            eidText.setEditable(false);

            findButton.setDisable(true);
            deleteButton.setDisable(false);

            nameText.setDisable(false);
            nameText.setText(employee.getName());

            addressText.setDisable(false);
            addressText.setText(employee.getAddress());

            jobTypeText.setDisable(false);
            jobTypeText.setText(employee.getJob_type());

            salaryText.setDisable(false);
            salaryText.setText(employee.getSalary().toString());

            mobileText.setDisable(false);
            mobileText.setText(employee.getMobile_no());

            divIDText.setDisable(false);
            divIDText.setText(employee.getDiv_ID().toString());

            birthDatePicker.setDisable(false);
            LocalDate bld = LocalDate.parse(employee.getBirth_date());
            birthDatePicker.setValue(bld);

            hireDatePicker.setDisable(false);
            LocalDate hld = LocalDate.parse(employee.getHire_date());
            hireDatePicker.setValue(hld);

            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Employee");
            alert.setContentText("Invalid Employee ID");
            alert.showAndWait();
            found = false;
        }
    }

    public void initialize(){
        eidText.clear();
        eidText.setDisable(false);
        eidText.setEditable(true);

        findButton.setDisable(false);
        deleteButton.setDisable(true);

        nameText.clear();
        nameText.setDisable(true);
        nameText.setEditable(false);

        addressText.clear();
        addressText.setDisable(true);
        addressText.setEditable(false);

        jobTypeText.clear();
        jobTypeText.setDisable(true);
        jobTypeText.setEditable(false);

        salaryText.clear();
        salaryText.setDisable(true);
        salaryText.setEditable(false);

        mobileText.clear();
        mobileText.setDisable(true);
        mobileText.setEditable(false);

        divIDText.clear();
        divIDText.setDisable(true);
        divIDText.setEditable(false);

        birthDatePicker.setValue(null);
        birthDatePicker.setDisable(true);
        birthDatePicker.setEditable(false);

        hireDatePicker.setValue(null);
        hireDatePicker.setDisable(true);
        hireDatePicker.setEditable(false);

        found = false;

    }

}
