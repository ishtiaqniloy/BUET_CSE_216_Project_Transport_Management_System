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


public class NewEmployeeController {

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
    private TextField addressText;

    @FXML
    private TextField mobileText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    @FXML
    void saveFunc(ActionEvent event) {
        //String birthDateString = birthDatePicker.getValue().toString();
        //System.out.println(birthDateString);    //2018-01-01
        try{
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
            boolean success = EmployeeTable.insertEmployee(employee);

            if(success){
                initialize();
                EmployeeController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Employee");
                alert.setContentText("New Employee Insertion SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Employee");
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
        eidText.clear();
        nameText.clear();
        addressText.clear();
        jobTypeText.clear();
        birthDatePicker.setValue(null);
        hireDatePicker.setValue(null);
        salaryText.clear();
        mobileText.clear();
        divIDText.clear();

    }

}
