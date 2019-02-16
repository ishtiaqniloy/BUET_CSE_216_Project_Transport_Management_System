package Controller;

import Model.Application;
import Model.ApplicationTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class CheckApplicationController {

    @FXML
    private TextField applicationNoText;
    private static TextField staticApplicationNoText;

    @FXML
    private TextField divIDText;
    private static TextField staticDivIDText;

    @FXML
    private Button failButton;

    @FXML
    private Button closeButton;

    private static Button staticCloseButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField typeText;
    private static TextField staticTypeText;

    @FXML
    private DatePicker examDatePicker;
    private static DatePicker staticExamDatePicker;

    @FXML
    private Button passButton;

    @FXML
    private TextField NIDText;
    private static TextField staticNIDText;

    private static int idx = -1;

    private static ArrayList<Application> dataList = null;

    @FXML
    void nextFunc(ActionEvent event) {
        idx++;
        setNextApplication();
    }

    @FXML
    void passFunc(ActionEvent event) {
        try{
            Application application = dataList.get(idx);
            boolean success = ApplicationTable.passApplication(application);

            if(success){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Pass Application");
                alert.setContentText("Passed successfully");
                alert.showAndWait();

                idx++;
                setNextApplication();
            }
            else {
                throw new Exception();
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pass Application");
            alert.setContentText("Failed to Pass");
            alert.showAndWait();

            Stage stage = (Stage) staticCloseButton.getParent().getScene().getWindow();
            stage.close();

        }
    }



    @FXML
    void failFunc(ActionEvent event) {
        try{
            Application application = dataList.get(idx);
            boolean success = ApplicationTable.failApplication(application);

            if(success){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail Application");
                alert.setContentText("Failed successfully");
                alert.showAndWait();

                idx++;
                setNextApplication();

            }
            else {
                throw new Exception();
            }


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fail Application");
            alert.setContentText("Failed to Fail");
            alert.showAndWait();

            Stage stage = (Stage) staticCloseButton.getParent().getScene().getWindow();
            stage.close();

        }
    }

    @FXML
    void closeFunc(ActionEvent event) {
        Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
        stage.close();
    }

    private static void setNextApplication(){
        try {
            if(dataList==null){
                //Stage stage = (Stage) staticCloseButton.getParent().getScene().getWindow();
                //stage.close();
                return;
            }

            if(idx>=dataList.size()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Check Application");
                alert.setContentText("No More Applications");
                alert.showAndWait();

                Stage stage = (Stage) staticCloseButton.getParent().getScene().getWindow();
                stage.close();
                return;
            }

            Application application = dataList.get(idx);

            staticApplicationNoText.setText(Integer.toString(application.getApplicationNumber()));
            staticNIDText.setText(Long.toString(application.getDriverNID()));
            LocalDate ld = LocalDate.parse(application.getExamDate());
            staticExamDatePicker.setValue(ld);
            staticDivIDText.setText(Integer.toString(application.getDivID()));
            staticTypeText.setText(application.getLicenseType());


        }catch (Exception e) {
            //e.printStackTrace();
            return;
        }

    }

    public void initialize(){
        idx = 0;
        dataList= ApplicationTable.getCheckableApplications();

        applicationNoText.clear();
        applicationNoText.setDisable(true);
        staticApplicationNoText = applicationNoText;

        NIDText.clear();
        NIDText.setDisable(true);
        staticNIDText = NIDText;

        examDatePicker.setValue(null);
        examDatePicker.setDisable(true);
        staticExamDatePicker = examDatePicker;

        divIDText.clear();
        divIDText.setDisable(true);
        staticDivIDText = divIDText;

        typeText.clear();
        typeText.setDisable(true);
        staticTypeText = typeText;

        nextButton.setDisable(false);
        passButton.setDisable(false);
        failButton.setDisable(false);
        closeButton.setDisable(false);

        staticCloseButton = closeButton;

        if (dataList == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check Application");
            alert.setContentText("No More Applications");
            alert.showAndWait();

//            Stage stage = (Stage) closeButton.getParent().getScene().getWindow();
//            stage.close();
//            return;
        }

        setNextApplication();


    }

}
