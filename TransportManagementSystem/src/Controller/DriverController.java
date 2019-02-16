package Controller;

import Model.Driver;
import Model.Driver;
import Model.DriverTable;
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

public class DriverController {

    @FXML
    private TableView<Driver> driverTable;
    private static TableView<Driver> staticTable;

    private static ArrayList<Driver> dataList = null;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button newApplicantsButton;

    @FXML
    private Button allButton;

     @FXML
    private Button searchByNameButton;

    @FXML
    private Button searchByNIDButton;


    @FXML
    void allFunc(ActionEvent event) {
        try{
            dataList= Model.DriverTable.getAllDrivers();
            initializeTable();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void newApplicantsFunc(ActionEvent event) {
        try{
            dataList= Model.DriverTable.getApplicants();
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Applicants");
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
            dataList = DriverTable.searchByName(name);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Driver");
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
    void searchByNIDFunc(ActionEvent event) {
        try{
            String  nid = searchField.getText().trim();
            searchField.clear();

            dataList = DriverTable.searchByNID(nid);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Driver");
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
    void updateFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateDriver.fxml"));
            stage.setTitle("Transport Management System - Update Driver");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<Driver, Long> driverNIDColumn = new TableColumn<>("Driver NID");
        driverNIDColumn.setMinWidth(100);
        driverNIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverNID"));

        TableColumn<Driver, Long> licenseNoColumn = new TableColumn<>("License No");
        licenseNoColumn.setMinWidth(100);
        licenseNoColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));

        TableColumn<Driver, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Driver, String> fathersNameCol = new TableColumn<>("Father's Name");
        fathersNameCol.setMinWidth(200);
        fathersNameCol.setCellValueFactory(new PropertyValueFactory<>("fathersName"));

        TableColumn<Driver, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(400);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Driver, String> birthDateCol = new TableColumn<>("Birth Date");
        birthDateCol.setMinWidth(120);
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

        TableColumn<Driver, String> bloodGroupCol = new TableColumn<>("Blood Group");
        bloodGroupCol.setMinWidth(100);
        bloodGroupCol.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));

        TableColumn<Driver, String> mobileNoCol = new TableColumn<>("Mobile No");
        mobileNoCol.setMinWidth(120);
        mobileNoCol.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));


        staticTable.getColumns().addAll(driverNIDColumn, licenseNoColumn, nameCol, fathersNameCol, addressCol, birthDateCol, bloodGroupCol, mobileNoCol);

        if(dataList==null){
            System.out.println("Driver Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Driver driver : dataList){
            obDataList.add(driver);
        }

        staticTable.setEditable(false);
        if(obDataList!=null)
            staticTable.setItems(obDataList);


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

    public void initialize(){
        staticTable = driverTable;
        staticTable.getColumns().clear();

        dataList= Model.DriverTable.getAllDrivers();
        initializeTable();

    }

}
