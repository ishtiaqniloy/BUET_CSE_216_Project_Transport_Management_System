package Controller;

import Model.Application;
import Model.Application;
import Model.ApplicationTable;
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

public class ApplicationController {

    @FXML
    private TableView<Application> applicationsTable;
    
    private static TableView<Application> staticTable;

    private static ArrayList<Application> dataList = null;

    @FXML
    private Button checkApplicationsButton;

    @FXML
    private Button allApplicationsButton;

    @FXML
    private Button pendingApplicationsButton;

    @FXML
    private Button homeButton;

    @FXML
    void allApplicationsFunc(ActionEvent event) {
       dataList= Model.ApplicationTable.getAllApplications();

        initializeTable();
    }
    
    @FXML
    void pendingApplicationsFunc(ActionEvent event) {
        dataList= Model.ApplicationTable.getPendingApplications();

        initializeTable();
    }

    @FXML
    void checkApplicationsFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/CheckApplication.fxml"));
            stage.setTitle("Transport Management System - Check Applications");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<Application, Integer> applicationNumberColumn = new TableColumn<>("Application Number");
        applicationNumberColumn.setMinWidth(200);
        applicationNumberColumn.setCellValueFactory(new PropertyValueFactory<>("applicationNumber"));

        TableColumn<Application, Long> driverNIDColumn = new TableColumn<>("Driver NID");
        driverNIDColumn.setMinWidth(200);
        driverNIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverNID"));

        TableColumn<Application, String> examDateCol = new TableColumn<>("Exam Date");
        examDateCol.setMinWidth(200);
        examDateCol.setCellValueFactory(new PropertyValueFactory<>("examDate"));

        TableColumn<Application, String> resultCol = new TableColumn<>("Result");
        resultCol.setMinWidth(200);
        resultCol.setCellValueFactory(new PropertyValueFactory<>("result"));

        TableColumn<Application, Integer> divIDCol = new TableColumn<>("Division");
        divIDCol.setMinWidth(150);
        divIDCol.setCellValueFactory(new PropertyValueFactory<>("divID"));

        TableColumn<Application, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("licenseType"));

        staticTable.getColumns().addAll(applicationNumberColumn, driverNIDColumn, examDateCol, resultCol, divIDCol, typeCol);

        if(dataList==null){
            System.out.println("Driver Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Application application : dataList){
            obDataList.add(application);
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
        staticTable = applicationsTable;
        dataList = ApplicationTable.getAllApplications();

        initializeTable();



    }

}
