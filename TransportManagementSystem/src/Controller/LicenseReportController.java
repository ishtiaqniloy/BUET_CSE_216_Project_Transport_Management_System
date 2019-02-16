package Controller;

import Model.License;
import Model.LicenseReportItem;
import Model.LicenseTable;
import TransportManagementSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LicenseReportController {

    @FXML
    private Button changeStatusButton;

    @FXML
    private TableView<LicenseReportItem> licenseReportTable;

    private static TableView<LicenseReportItem> staticTable;

    @FXML
    private Button backButton;

    @FXML
    void backFunc(ActionEvent event) {
        try {
            Stage stage = (Stage) backButton.getParent().getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../View/License.fxml"));
            stage.setTitle("Transport Management System - License");
            stage.setScene(new Scene(root,  Main.HomeWidth, Main.HomeHeight));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeStatusFunc(ActionEvent event) {
        try {
            boolean success = LicenseTable.changeStatus();
            if(success){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Change Status of License");
                alert.setContentText("SUCCESS");
                alert.showAndWait();
            }
            else{
                throw new Exception();
            }


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Change Status of License");
            alert.setContentText("FAILURE");
            alert.showAndWait();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<LicenseReportItem, Long> licenseNoColumn = new TableColumn<>("License No");
        licenseNoColumn.setMinWidth(500);
        licenseNoColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));

        TableColumn<LicenseReportItem, Integer> penaltyNoCol = new TableColumn<>("Number of Penalties");
        penaltyNoCol.setMinWidth(700);
        penaltyNoCol.setCellValueFactory(new PropertyValueFactory<>("penaltyNo"));


        staticTable.getColumns().addAll(licenseNoColumn, penaltyNoCol);

        ArrayList<LicenseReportItem> dataList= Model.LicenseTable.getLicenseReport();
        if(dataList==null){
            System.out.println("License Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (LicenseReportItem licenseReportItem : dataList){
            obDataList.add(licenseReportItem);
        }

        staticTable.setEditable(false);
        if(obDataList!=null)
            staticTable.setItems(obDataList);


    }


    public void initialize(){
        staticTable = licenseReportTable;
        staticTable.getColumns().clear();
        initializeTable();

    }



}
