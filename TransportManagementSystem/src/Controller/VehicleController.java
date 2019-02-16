package Controller;

import Model.DriverTable;
import Model.Vehicle;
import Model.Vehicle;
import Model.VehicleTable;
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

public class VehicleController {

    @FXML
    private TableView<Vehicle> vehicleTable;

    private static TableView<Vehicle> staticTable;

    private static ArrayList<Vehicle> dataList= null;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button searchByRegNoButton;

    @FXML
    private Button searchByModelButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button allButton;

    @FXML
    private Button searchByTypeButton;

    @FXML
    void allFunc(ActionEvent event) {
        try {
            dataList= Model.VehicleTable.getAllVehicles();
            initializeTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchByRegNoFunc(ActionEvent event) {
        try {
            String regNo = searchField.getText().trim();
            searchField.clear();

            dataList = VehicleTable.searchByRegNo(regNo);

            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Vehicle");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchByTypeFunc(ActionEvent event) {
        try {
            String type = searchField.getText().trim();
            searchField.clear();

            dataList = VehicleTable.searchByType(type);

            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Vehicle");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchByModelFunc(ActionEvent event) {
        try {
            String model = searchField.getText().trim();
            searchField.clear();

            dataList = VehicleTable.searchByModel(model);
            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Vehicle");
                alert.setContentText("No Data Found");
                alert.showAndWait();
                return;
            }

            initializeTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewVehicle.fxml"));
            stage.setTitle("Transport Management System - Insert New Vehicle");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateVehicle.fxml"));
            stage.setTitle("Transport Management System - Update Vehicle");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<Vehicle, Integer> regNoColumn = new TableColumn<>("Reg No");
        regNoColumn.setMinWidth(80);
        regNoColumn.setCellValueFactory(new PropertyValueFactory<>("regNo"));

        TableColumn<Vehicle, String> ownerNIDCol = new TableColumn<>("Owner NID");
        ownerNIDCol.setMinWidth(100);
        ownerNIDCol.setCellValueFactory(new PropertyValueFactory<>("ownerNID"));

        TableColumn<Vehicle, String> regDateCol = new TableColumn<>("Registration Date");
        regDateCol.setMinWidth(150);
        regDateCol.setCellValueFactory(new PropertyValueFactory<>("regDate"));

        TableColumn<Vehicle, String> vehicleModelCol = new TableColumn<>("Model");
        vehicleModelCol.setMinWidth(80);
        vehicleModelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));

        TableColumn<Vehicle, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(80);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Vehicle, String> taxValidityDateCol = new TableColumn<>("Tax Validity Date");
        taxValidityDateCol.setMinWidth(150);
        taxValidityDateCol.setCellValueFactory(new PropertyValueFactory<>("taxValidityDate"));

        TableColumn<Vehicle, String> fitnessValidityDateCol = new TableColumn<>("Fitness Validity Date");
        fitnessValidityDateCol.setMinWidth(150);
        fitnessValidityDateCol.setCellValueFactory(new PropertyValueFactory<>("fitnessValidityDate"));

        TableColumn<Vehicle, Integer> engineCCColumn = new TableColumn<>("Engine CC");
        engineCCColumn.setMinWidth(80);
        engineCCColumn.setCellValueFactory(new PropertyValueFactory<>("engineCC"));

        TableColumn<Vehicle, Integer> seatsColumn = new TableColumn<>("Seats");
        seatsColumn.setMinWidth(80);
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));

        TableColumn<Vehicle, Integer> weightColumn = new TableColumn<>("Weight (Kg)");
        weightColumn.setMinWidth(80);
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Vehicle, Integer> tireSizeColumn = new TableColumn<>("Tire Size (mm)");
        tireSizeColumn.setMinWidth(80);
        tireSizeColumn.setCellValueFactory(new PropertyValueFactory<>("tireSize"));

        TableColumn<Vehicle, String> transmissionCol = new TableColumn<>("Transmission");
        transmissionCol.setMinWidth(100);
        transmissionCol.setCellValueFactory(new PropertyValueFactory<>("transmission"));

        TableColumn<Vehicle, Integer> divIDColumn = new TableColumn<>("Division");
        divIDColumn.setMinWidth(80);
        divIDColumn.setCellValueFactory(new PropertyValueFactory<>("divID"));


        staticTable.getColumns().addAll(regNoColumn, ownerNIDCol, regDateCol, vehicleModelCol, typeCol, taxValidityDateCol, fitnessValidityDateCol,
                engineCCColumn, seatsColumn, weightColumn, tireSizeColumn, transmissionCol, divIDColumn);

        if(dataList==null){
            System.out.println("Vehicle Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Vehicle vehicle : dataList){
            obDataList.add(vehicle);
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
        staticTable = vehicleTable;
        staticTable.getColumns().clear();

        dataList= Model.VehicleTable.getAllVehicles();
        initializeTable();

    }

}
