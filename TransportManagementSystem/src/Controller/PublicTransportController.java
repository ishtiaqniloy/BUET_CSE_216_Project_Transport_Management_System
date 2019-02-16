package Controller;

import Model.PublicTransport;
import Model.PublicTransport;
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

public class PublicTransportController {

    @FXML
    private Button insertButton;

    @FXML
    private TableView<PublicTransport> publicTransportTable;
    private static TableView<PublicTransport> staticTable;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewPublicTransport.fxml"));
            stage.setTitle("Transport Management System - Insert Public Transport");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdatePublicTransport.fxml"));
            stage.setTitle("Transport Management System - Update Public Transport");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<PublicTransport, Integer> regNoColumn = new TableColumn<>("Vehicle Reg No");
        regNoColumn.setMinWidth(95);
        regNoColumn.setCellValueFactory(new PropertyValueFactory<>("regNo"));

        TableColumn<PublicTransport, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PublicTransport, String> routeCol = new TableColumn<>("Route");
        routeCol.setMinWidth(1000);
        routeCol.setCellValueFactory(new PropertyValueFactory<>("route"));

        TableColumn<PublicTransport, Float> fareColumn = new TableColumn<>("Fare (TK)");
        fareColumn.setMinWidth(95);
        fareColumn.setCellValueFactory(new PropertyValueFactory<>("fare"));


        staticTable.getColumns().addAll(regNoColumn, nameCol, routeCol, fareColumn);

        ArrayList<PublicTransport> dataList= Model.PublicTransportTable.getAllPublicTransports();
        if(dataList==null){
            System.out.println("PublicTransport Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (PublicTransport publicTransport : dataList){
            obDataList.add(publicTransport);
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
        staticTable = publicTransportTable;
        staticTable.getColumns().clear();
        initializeTable();

    }

}
