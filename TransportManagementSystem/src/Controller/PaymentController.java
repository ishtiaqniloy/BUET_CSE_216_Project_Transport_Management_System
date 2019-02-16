package Controller;

import Model.Payment;
import Model.PaymentTable;
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

public class PaymentController {

    @FXML
    private Button addPaymentButton;

    @FXML
    private TableView<Payment> paymentTable;

    private static TableView<Payment> staticTable;

    @FXML
    private Button homeButton;

    @FXML
    void addPaymentFunc(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/NewPayment.fxml"));
            stage.setTitle("Transport Management System - Insert New Payment");
            //stage.setMaximized(false);
            stage.setScene(new Scene(root,  Main.LoginWidth, Main.LoginHeight));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeTable() {
        staticTable.getColumns().clear();
        TableColumn<Payment, Integer> paymentNoColumn = new TableColumn<>("Payment No");
        paymentNoColumn.setMinWidth(150);
        paymentNoColumn.setCellValueFactory(new PropertyValueFactory<>("paymentNo"));

        TableColumn<Payment, Float> amountCol = new TableColumn<>("Amount (Taka)");
        amountCol.setMinWidth(150);
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Payment, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        TableColumn<Payment, Integer> historyNoColumn = new TableColumn<>("History No");
        historyNoColumn.setMinWidth(150);
        historyNoColumn.setCellValueFactory(new PropertyValueFactory<>("historyNo"));

        TableColumn<Payment, String> nameCol = new TableColumn<>("Description of Payment");
        nameCol.setMinWidth(550);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Payment, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(150);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));


        staticTable.getColumns().addAll(paymentNoColumn, amountCol, dateCol, historyNoColumn, nameCol, typeCol);

        ArrayList<Payment> dataList= PaymentTable.getAllPayments();
        if(dataList==null){
            System.out.println("Payment Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (Payment payment : dataList){
            obDataList.add(payment);
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
        staticTable = paymentTable;
        staticTable.getColumns().clear();
        initializeTable();

    }

}
