package Controller;

import Model.HistoryItem;
import Model.HistoryTables;
import Model.Report;
import Model.ReportItem;
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

public class HistoryController {

    @FXML
    private TableView<HistoryItem> historyTable;

    private static TableView<HistoryItem> staticTable;
    private static int hType = -1;

    @FXML
    private Button LicenseHistoryButton;

    @FXML
    private Button addHistoryButton;

    @FXML
    private Button vehicleHistoryButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button penaltyHistoryButton;

    @FXML
    void vehicleHistoryFunc(ActionEvent event) {
        hType = 1;
        initializeTable();
    }

    @FXML
    void LicenseHistoryFunc(ActionEvent event) {
        hType = 2;
        initializeTable();
    }

    @FXML
    void penaltyHistoryFunc(ActionEvent event) {
        hType = 3;
        initializeTable();
    }

    @FXML
    void addHistoryFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewHistory.fxml"));
            stage.setTitle("Transport Management System - Insert New History");
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

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<HistoryItem, Integer> entryCol = new TableColumn<>("Entry NO");
        entryCol.setMinWidth(100);
        entryCol.setCellValueFactory(new PropertyValueFactory<>("entryNo"));

        TableColumn<HistoryItem, Integer> idCol = new TableColumn<>("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<HistoryItem, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(300);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<HistoryItem, Float> amountCol = new TableColumn<>("Amount");
        amountCol.setMinWidth(150);
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<HistoryItem, Integer> vRegCol = new TableColumn<>("Vehicle Reg No");
        vRegCol.setMinWidth(100);
        vRegCol.setCellValueFactory(new PropertyValueFactory<>("vehicleRegNo"));

        TableColumn<HistoryItem, Long> licenseCol = new TableColumn<>("License No");
        licenseCol.setMinWidth(150);
        licenseCol.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));

        TableColumn<HistoryItem, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<HistoryItem, String> statusCol = new TableColumn<>("Status");
        statusCol.setMinWidth(100);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<HistoryItem, Integer> paymentCol = new TableColumn<>("Payment No");
        paymentCol.setMinWidth(100);
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentNo"));

        ArrayList<HistoryItem> dataList = null;
        if(hType == 1){
            staticTable.getColumns().addAll(entryCol, idCol, nameCol, amountCol, vRegCol, dateCol, statusCol, paymentCol);
            dataList= HistoryTables.getVehicleServiceHistory();
        }
        else if(hType == 2){
            staticTable.getColumns().addAll(entryCol, idCol, nameCol, amountCol, licenseCol, dateCol, statusCol, paymentCol);
            dataList= HistoryTables.getLicenseServiceHistory();
        }
        else if(hType == 3){
            staticTable.getColumns().addAll(entryCol, idCol, nameCol, amountCol, vRegCol, licenseCol, dateCol, statusCol, paymentCol);
            dataList= HistoryTables.getPenaltyHistory();
        }

        if(dataList==null){
            System.out.println("History table initialize error");
            return;
        }

        ObservableList<HistoryItem> obDataList = FXCollections.observableArrayList();

        for (HistoryItem historyItem : dataList){
            obDataList.add(historyItem);
        }

        staticTable.setEditable(false);
        if(obDataList!=null)
            staticTable.setItems(obDataList);


    }




    public void initialize(){
        staticTable = historyTable;
        staticTable.getColumns().clear();
        hType = -1;
    }

}
