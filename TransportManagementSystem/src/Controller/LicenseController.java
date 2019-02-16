package Controller;

import Model.License;
import Model.License;
import Model.LicenseTable;
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

public class LicenseController {

    @FXML
    private TableView<License> licenseTable;
    private static TableView<License> staticTable;
    private static ArrayList<License> dataList = null;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button viewReportButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button allButton;

    @FXML
    private Button searchByTypeButton;

    @FXML
    private Button suspendedButton;

    @FXML
    private Button searchByLicenseNoButton;

    @FXML
    void allFunc(ActionEvent event) {
        try {
            dataList= LicenseTable.getAllLicenses();
            initializeTable();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void suspendedFunc(ActionEvent event) {
        try {
            dataList= LicenseTable.getSuspendedLicenses();
            if(dataList.size()==0){
                searchField.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Suspended License");
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
    void searchByTypeFunc(ActionEvent event) {
        try {
            String type = searchField.getText().trim();
            searchField.clear();

            dataList= LicenseTable.searchByType(type);

            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search License");
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
    void searchByLicenseNoFunc(ActionEvent event) {
        try {
            String licenseNo = searchField.getText().trim();
            searchField.clear();

            dataList= LicenseTable.searchByLicenseNo(licenseNo);

            if(dataList.size()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search License");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateLicense.fxml"));
            stage.setTitle("Transport Management System - Update License");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<License, Long> licenseNoColumn = new TableColumn<>("License No");
        licenseNoColumn.setMinWidth(200);
        licenseNoColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));

        TableColumn<License, Long> driverNIDColumn = new TableColumn<>("Driver NID");
        driverNIDColumn.setMinWidth(200);
        driverNIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverNID"));

        TableColumn<License, String> issueDateCol = new TableColumn<>("Issue Date");
        issueDateCol.setMinWidth(200);
        issueDateCol.setCellValueFactory(new PropertyValueFactory<>("issueDate"));

        TableColumn<License, String> validityDateCol = new TableColumn<>("Validity Date");
        validityDateCol.setMinWidth(200);
        validityDateCol.setCellValueFactory(new PropertyValueFactory<>("validityDate"));

        TableColumn<License, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<License, Integer> divIDCol = new TableColumn<>("Division");
        divIDCol.setMinWidth(150);
        divIDCol.setCellValueFactory(new PropertyValueFactory<>("divID"));

        TableColumn<License, String> statusCol = new TableColumn<>("Status");
        statusCol.setMinWidth(180);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));


        staticTable.getColumns().addAll(licenseNoColumn, driverNIDColumn, issueDateCol, validityDateCol, typeCol, divIDCol, statusCol);

        if(dataList==null){
            System.out.println("License Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (License license : dataList){
            obDataList.add(license);
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

    @FXML
    void viewReportFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) viewReportButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/LicenseReport.fxml"));
            stage.setTitle("Transport Management System - License Report");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void initialize(){
        staticTable = licenseTable;
        staticTable.getColumns().clear();

        dataList= LicenseTable.getAllLicenses();
        initializeTable();

    }

}
