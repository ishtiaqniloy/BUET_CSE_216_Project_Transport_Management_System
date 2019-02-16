package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewPaymentController {

    @FXML
    private TextField paymentNoText;

    @FXML
    private Button closeButton;

    @FXML
    private TextField amountText;

    @FXML
    private Button findButton;

    @FXML
    private TextField statusText;

    @FXML
    private TextField nameText;

    @FXML
    private Button saveButton;

    @FXML
    private TextField historyNoText;

    @FXML
    void findFunc(ActionEvent event) {
        try{
            int historyNo = Integer.parseInt(historyNoText.getText().trim()) ;

            HistoryItem historyItem = HistoryTables.getHistoryItem(historyNo);
            if (historyItem == null || historyItem.getStatus().equals("Paid")){
                throw new Exception();
            }

            nameText.setText(historyItem.getName());
            amountText.setText(Float.toString(historyItem.getAmount()));
            statusText.setText(historyItem.getStatus());

            saveButton.setDisable(false);


        }catch (Exception e){
            //initialize();
            historyNoText.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Payment insert");
            alert.setContentText("Invalid History Entry No");
            alert.showAndWait();
        }
    }

    @FXML
    void saveFunc(ActionEvent event) {
        try{
            int historyNo = Integer.parseInt(historyNoText.getText().trim()) ;

            HistoryItem historyItem = HistoryTables.getHistoryItem(historyNo);
            if (historyItem == null || historyItem.getStatus().equals("Paid")){
                throw new Exception();
            }

            int paymentNo = Integer.parseInt(paymentNoText.getText());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            //System.out.println(dateFormat.format(cal.getTime()));
            String date = dateFormat.format(cal.getTime());

            String type = null;
            if (historyNo < 2000) type = "License Service";
            else if (historyNo < 3000)  type = "Vehicle Service";
            else type = "Penalty";

            Payment payment = new Payment(paymentNo, historyItem.getAmount(), date, historyNo, historyItem.getName(), type);

            boolean success = PaymentTable.insertPayment(payment);

            if(success){
                initialize();
                PaymentController.initializeTable();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("New Payment insert");
                alert.setContentText("SUCCESS");
                alert.showAndWait();

            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            //initialize();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("New Payment insert");
            alert.setContentText("Invalid Data");
            alert.showAndWait();
        }
    }

    @FXML
    void closeFunc(ActionEvent event) {
        Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        paymentNoText.clear();
        historyNoText.clear();
        nameText.clear();
        amountText.clear();
        statusText.clear();

        paymentNoText.setDisable(true);
        historyNoText.setDisable(false);
        nameText.setDisable(true);
        amountText.setDisable(true);
        statusText.setDisable(true);

        findButton.setDisable(false);
        saveButton.setDisable(true);

        int newPaymentNo = PaymentTable.getFreePaymentNo();
        paymentNoText.setText(Integer.toString(newPaymentNo));


    }

}
