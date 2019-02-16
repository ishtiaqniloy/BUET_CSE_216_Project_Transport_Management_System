package Controller;

import Model.Owner;
import Model.OwnerTable;
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

public class OwnerController {

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private TableView<Owner> ownerTable;

    private static TableView<Owner> staticTable;

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewOwner.fxml"));
            stage.setTitle("Transport Management System - Insert New Owner");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdateOwner.fxml"));
            stage.setTitle("Transport Management System - Update Owner");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();

        TableColumn<Owner, String> NIDColumn = new TableColumn<>("NID");
        NIDColumn.setMinWidth(150);
        NIDColumn.setCellValueFactory(new PropertyValueFactory<>("ownerNID"));

        TableColumn<Owner, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Owner, String> addressCol = new TableColumn<>("Name");
        addressCol.setMinWidth(300);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Owner, String> eTINCol = new TableColumn<>("e-TIN");
        eTINCol.setMinWidth(150);
        eTINCol.setCellValueFactory(new PropertyValueFactory<>("eTIN"));

        TableColumn<Owner, String> mobileNoCol = new TableColumn<>("Mobile No");
        mobileNoCol.setMinWidth(150);
        mobileNoCol.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));

        TableColumn<Owner, String> numberOfVehiclesCol = new TableColumn<>("Number of Vehicles");
        numberOfVehiclesCol.setMinWidth(150);
        numberOfVehiclesCol.setCellValueFactory(new PropertyValueFactory<>("numberOfVehicles"));

        staticTable.getColumns().addAll(NIDColumn, nameCol, addressCol, eTINCol, mobileNoCol, numberOfVehiclesCol);

        ArrayList <Owner> dataList= Model.OwnerTable.getAllOwners();
        if(dataList==null){
            System.out.println("Owner Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Owner owner : dataList){
            obDataList.add(owner);
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
        staticTable = ownerTable;
        staticTable.getColumns().clear();
        initializeTable();

    }


}
