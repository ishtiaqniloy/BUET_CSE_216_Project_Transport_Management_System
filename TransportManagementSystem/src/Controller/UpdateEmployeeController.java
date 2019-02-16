package Controller;

import Model.Employee;
import Model.EmployeeTable;
import Model.Penalty;
import Model.PenaltyTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class UpdateEmployeeController {

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

    @FXML
    private Button saveButton;

    private boolean found = false;

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            if(!found){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Update Employee");
                alert.setContentText("Not Found Updatable Employee Yet");
                alert.showAndWait();
                return;
            }

            String EID = eidText.getText().trim();
            String name = nameText.getText().trim();
            String address = addressText.getText().trim();
            String jobType = jobTypeText.getText().trim();
            String birthDateString = birthDatePicker.getValue().toString();
            String hireDateString = hireDatePicker.getValue().toString();
            float salary = Float.parseFloat(salaryText.getText().trim());
            String mobileNo = mobileText.getText().trim();
            int divID = Integer.parseInt(divIDText.getText().trim());

            //System.out.println(birthDateString);

            if(EID.length() == 0 ||name.length() == 0 ||address.length() == 0 ||jobType.length() == 0 ||birthDateString.length() == 0 ||hireDateString.length() == 0 ||mobileNo.length() == 0 || salary <=0 || divID <=0){
                throw new Exception();
            }

            Employee employee = new Employee(EID, name, address, jobType, birthDateString, hireDateString, salary, mobileNo, divID) ;
            boolean success = EmployeeTable.updateEmployee(employee);

            if(success){
                initialize();
                EmployeeController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Employee");
                alert.setContentText("Update Employee SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Employee");
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
            saveButton.setDisable(false);

            nameText.setDisable(false);
            nameText.setEditable(true);
            nameText.setText(employee.getName());

            addressText.setDisable(false);
            addressText.setEditable(true);
            addressText.setText(employee.getAddress());

            jobTypeText.setDisable(false);
            jobTypeText.setEditable(true);
            jobTypeText.setText(employee.getJob_type());

            salaryText.setDisable(false);
            salaryText.setEditable(true);
            salaryText.setText(employee.getSalary().toString());

            mobileText.setDisable(false);
            mobileText.setEditable(true);
            mobileText.setText(employee.getMobile_no());

            divIDText.setDisable(false);
            divIDText.setEditable(true);
            divIDText.setText(employee.getDiv_ID().toString());

            birthDatePicker.setDisable(false);
            birthDatePicker.setEditable(true);
            LocalDate bld = LocalDate.parse(employee.getBirth_date());
            birthDatePicker.setValue(bld);

            hireDatePicker.setDisable(false);
            hireDatePicker.setEditable(true);
            LocalDate hld = LocalDate.parse(employee.getHire_date());
            hireDatePicker.setValue(hld);

            found = true;

        }catch (Exception e){
            initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Employee");
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
        saveButton.setDisable(true);

        nameText.clear();
        nameText.setDisable(true);

        addressText.clear();
        addressText.setDisable(true);

        jobTypeText.clear();
        jobTypeText.setDisable(true);

        salaryText.clear();
        salaryText.setDisable(true);

        mobileText.clear();
        mobileText.setDisable(true);

        divIDText.clear();
        divIDText.setDisable(true);

        birthDatePicker.setValue(null);
        birthDatePicker.setDisable(true);

        hireDatePicker.setValue(null);
        hireDatePicker.setDisable(true);

        found = false;

    }

}
