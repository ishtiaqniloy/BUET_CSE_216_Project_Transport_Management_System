package Controller;

import Model.Report;
import Model.ReportItem;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ReportController {

    @FXML
    private TableView<ReportItem> reportTable;

    private static TableView<ReportItem> staticTable;


    @FXML
    private Button LicenseReportButton;

    @FXML
    private Button vehicleReportButton;

    @FXML
    private Button homeButton;

    @FXML
    void LicenseReportFunc(ActionEvent event) {
        initializeTable(1);
    }

    @FXML
    void vehicleReportFunc(ActionEvent event) {
        initializeTable(2);
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

    public static void initializeTable(int type) {
        staticTable.getColumns().clear();

        TableColumn<ReportItem, String> numberColumn = new TableColumn<>();
        TableColumn<ReportItem, String> NIDCol = new TableColumn<>();
        if(type == 1){
            //System.out.println("Setting Text for type = " + type);
            numberColumn.setText("License No");
            NIDCol.setText("Driver NID");
        }
        else {
            //System.out.println("Setting Text for type = " + type);
            numberColumn.setText("Registration No");
            NIDCol.setText("Owner NID");
        }

        numberColumn.setMinWidth(200);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("num"));


        NIDCol.setMinWidth(200);
        NIDCol.setCellValueFactory(new PropertyValueFactory<>("NID"));

        TableColumn<ReportItem, String> dateCol = new TableColumn<>("Validity Date");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<ReportItem, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setMinWidth(650);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<ReportItem, String> divCol = new TableColumn<>("Division");
        divCol.setMinWidth(150);
        divCol.setCellValueFactory(new PropertyValueFactory<>("div_ID"));


        staticTable.getColumns().addAll(numberColumn, NIDCol, dateCol, descriptionCol, divCol);

        ArrayList<ReportItem> dataList= Report.getReport(type);
        if(dataList==null){
            System.out.println("Report Table Initialize error");
            return;
        }

        ObservableList <ReportItem> obDataList = FXCollections.observableArrayList();

        for (ReportItem reportItem : dataList){
            obDataList.add(reportItem);
        }

        staticTable.setEditable(false);
        if(obDataList!=null)
            staticTable.setItems(obDataList);


    }

    public void initialize(){
        staticTable = reportTable;
        staticTable.getColumns().clear();
    }


}
