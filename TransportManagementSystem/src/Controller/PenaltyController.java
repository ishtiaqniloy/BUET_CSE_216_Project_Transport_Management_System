package Controller;

import Model.Penalty;
import Model.PenaltyTable;
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

public class PenaltyController {

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton;

    @FXML
    private TableView<Penalty> penaltyTable;

    private static TableView<Penalty> staticTable;

    @FXML
    void insertFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewPenalty.fxml"));
            stage.setTitle("Transport Management System - Insert New Penalty");
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
            Parent root = FXMLLoader.load(getClass().getResource("../View/UpdatePenalty.fxml"));
            stage.setTitle("Transport Management System - Update Penalty");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();
        TableColumn<Penalty, Integer> PIDColumn = new TableColumn<>("PID");
        PIDColumn.setMinWidth(100);
        PIDColumn.setCellValueFactory(new PropertyValueFactory<>("PID"));

        TableColumn<Penalty, String> sectionCol = new TableColumn<>("Section");
        sectionCol.setMinWidth(340);
        sectionCol.setCellValueFactory(new PropertyValueFactory<>("section"));

        TableColumn<Penalty, String> nameCol = new TableColumn<>("Name of Penalty");
        nameCol.setMinWidth(656);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Penalty, Float> fineCol = new TableColumn<>("Fine (Taka)");
        fineCol.setMinWidth(250);
        fineCol.setCellValueFactory(new PropertyValueFactory<>("fine"));


        staticTable.getColumns().addAll(PIDColumn, sectionCol, nameCol, fineCol);

        ArrayList <Penalty> dataList= PenaltyTable.getAllPenalties();
        if(dataList==null){
            System.out.println("Penalty Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Penalty penalty : dataList){
            obDataList.add(penalty);
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
        staticTable = penaltyTable;
        staticTable.getColumns().clear();
        initializeTable();

    }


}
