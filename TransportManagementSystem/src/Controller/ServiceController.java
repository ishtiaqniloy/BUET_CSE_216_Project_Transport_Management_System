package Controller;

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

public class ServiceController {

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private TableView<Service> serviceTable;

    private static TableView<Service> staticTable;

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewService.fxml"));
            stage.setTitle("Transport Management System - Insert New Service");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateService.fxml"));
            stage.setTitle("Transport Management System - Update Service");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();
        TableColumn<Service, Integer> SIDColumn = new TableColumn<>("SID");
        SIDColumn.setMinWidth(100);
        SIDColumn.setCellValueFactory(new PropertyValueFactory<>("SID"));

        TableColumn<Service, String> nameCol = new TableColumn<>("Name of Service");
        nameCol.setMinWidth(656);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Service, Float> feeCol = new TableColumn<>("Fee (Taka)");
        feeCol.setMinWidth(250);
        feeCol.setCellValueFactory(new PropertyValueFactory<>("fee"));

        TableColumn<Service, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(340);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));


        staticTable.getColumns().addAll(SIDColumn, nameCol, feeCol, typeCol);

        ArrayList <Service> dataList= ServiceTable.getAllServices();
        if(dataList==null){
            System.out.println("Service Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Service service : dataList){
            obDataList.add(service);
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
        staticTable = serviceTable;
        staticTable.getColumns().clear();
        initializeTable();

    }


}
