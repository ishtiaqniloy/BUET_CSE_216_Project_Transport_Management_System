package Controller;

import Model.Employee;
import Model.EmployeeTable;
import Model.Service;
import Model.ServiceTable;
import TransportManagementSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeController {

    @FXML
    private Button deleteButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button increaseSalaryButton;

    @FXML
    private Button homeButton;

    @FXML
    private TableView<Employee> employeeTable;

    private static TableView<Employee> staticTable;

    private static ArrayList<Employee> dataList = null;


    @FXML
    private Button allEmployeesButton;

    @FXML
    private Button searchByIDButton;

    @FXML
    private Button searchByNameButton;

    @FXML
    private Button filterButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextField toText;

    @FXML
    private TextField fromText;

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewEmployee.fxml"));
            stage.setTitle("Transport Management System - Insert New Employee");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateEmployee.fxml"));
            stage.setTitle("Transport Management System - Update Employee");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void increaseSalaryFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/IncreaseSalary.fxml"));
            stage.setTitle("Transport Management System - Increase Salary");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deleteFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/DeleteEmployee.fxml"));
            stage.setTitle("Transport Management System - Update Employee");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) homeButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/Home.fxml"));
            stage.setTitle("Transport Management System - Home");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void allEmployeesFunc(ActionEvent event) {
        try{
            dataList= EmployeeTable.getAllEmployees();
            initializeTable();

        }catch (Exception e){
           e.printStackTrace();
        }

    }

    @FXML
    void searchByIDFunc(ActionEvent event) {
        try{
            String id = searchField.getText().trim();
            searchField.clear();
            dataList = EmployeeTable.findEmployeeByID(id);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Employee");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();

        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @FXML
    void searchByNameFunc(ActionEvent event) {
        try{
            String name = searchField.getText().trim();
            searchField.clear();
            dataList = EmployeeTable.findEmployeeByName(name);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Employee");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void filterFunc(ActionEvent event) {
        try{
            float low = Float.parseFloat(fromText.getText().trim());
            fromText.clear();
            float high = Float.parseFloat(toText.getText().trim());
            toText.clear();
            dataList = EmployeeTable.filterEmployeeBySalary(low, high);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Filter Employee");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();


        }catch (Exception e){
            e.printStackTrace();

        }

    }


    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<Employee, String> EIDColumn = new TableColumn<>("EID");
        EIDColumn.setMinWidth(80);
        EIDColumn.setCellValueFactory(new PropertyValueFactory<>("employee_ID"));

        TableColumn<Employee, String> nameCol = new TableColumn<>("Name of Employee");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(300);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Employee, String> jobCol = new TableColumn<>("Job Type");
        jobCol.setMinWidth(200);
        jobCol.setCellValueFactory(new PropertyValueFactory<>("job_type"));

        TableColumn<Employee, String> birthCol = new TableColumn<>("Birth Date");
        birthCol.setMinWidth(90);
        birthCol.setCellValueFactory(new PropertyValueFactory<>("birth_date"));

        TableColumn<Employee, String> hireCol = new TableColumn<>("Hire Date");
        hireCol.setMinWidth(90);
        hireCol.setCellValueFactory(new PropertyValueFactory<>("hire_date"));

        TableColumn<Employee, Float> salaryCol = new TableColumn<>("Salary");
        salaryCol.setMinWidth(80);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, String> mobileCol = new TableColumn<>("Mobile");
        mobileCol.setMinWidth(150);
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile_no"));

        TableColumn<Employee, Integer> divCol = new TableColumn<>("Division");
        divCol.setMinWidth(80);
        divCol.setCellValueFactory(new PropertyValueFactory<>("div_ID"));


        staticTable.getColumns().addAll(EIDColumn, nameCol, addressCol, jobCol, birthCol, hireCol, salaryCol, mobileCol, divCol);

        if(dataList==null){
            System.out.println("Employee Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Employee employee : dataList){
            obDataList.add(employee);
        }

        staticTable.setEditable(false);
        if(obDataList!=null)
            staticTable.setItems(obDataList);


    }

    public void initialize(){
        staticTable = employeeTable;
        dataList= EmployeeTable.getAllEmployees();
        initializeTable();

    }



}
