package Controller;

import Model.*;
import TransportManagementSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SummaryController {

    @FXML
    private TableView<DivisionSummaryItem> divisionSummaryTable;
    private static TableView<DivisionSummaryItem> staticDivisionSummaryTable;

    @FXML
    private TableView<YearlySummaryItem> yearlySummaryTable;
    private static TableView<YearlySummaryItem> staticYearlySummaryTable;

    @FXML
    private Button homeButton;

    private static ArrayList <DivisionChartItem> divisionChartList = null;
    private static ArrayList <YearlySummaryItem> yearlySummaryList = null;

    @FXML
    private Button yearlyLicenseChartButton;

    @FXML
    private Button divisionPenaltyChartButton;

    @FXML
    private Button yearlyVehicleChartButton;

    @FXML
    private Button yearlyPenaltyChartButton;

    @FXML
    private Button divisionLicenseChartButton;

    @FXML
    private Button divisionVehicleChartButton;

    private void divisionCharts(int i, int j){      ///i=1 division, i=2 yearly
        try {                                       ///j=1 penalty, j=2 license service, j=3 vehicle service

            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            XYChart.Series series = new XYChart.Series();

            if(i==1){
                xAxis.setLabel("Division");
            }
            else{
                xAxis.setLabel("Year");
                xAxis.setAutoRanging(false);
                xAxis.setLowerBound(yearlySummaryList.get(0).getYear());
                xAxis.setUpperBound(yearlySummaryList.get(0).getYear()+yearlySummaryList.size());

            }

            if(j==1){
                yAxis.setLabel("Number of Penalties");
            }
            else if(j==2){
                yAxis.setLabel("Number of License Services");
            }

            else{
                yAxis.setLabel("Number of Vehicle Services");
            }

            final LineChart<Number,Number> divisionChart = new LineChart<Number,Number>(xAxis,yAxis);

            if(i==1){
                if(j==1){
                    series.setName("Penalty VS Division");
                    divisionChart.setTitle("Divisional Penalty Summary");
                }
                else if(j==2){
                    series.setName("License Service VS Division");
                    divisionChart.setTitle("Divisional License Service Summary");
                }
                else{
                    series.setName("Vehicle Service VS Division");
                    divisionChart.setTitle("Divisional Vehicle Service Summary");
                }
            }
            else{
                if(j==1){
                    series.setName("Penalty VS Year");
                    divisionChart.setTitle("Yearly Penalty Summary");
                }
                else if(j==2){
                    series.setName("License Service VS Year");
                    divisionChart.setTitle("Yearly License Service Summary");
                }
                else{
                    series.setName("Vehicle Service VS Year");
                    divisionChart.setTitle("Yearly Vehicle Service Summary");
                }


            }

            if(divisionChartList==null){
                System.out.println("Chart Error");
                return;
            }
            if(i==1){
                for (DivisionChartItem divisionChartItem : divisionChartList){
                    if(j==1)
                        series.getData().add(new XYChart.Data(divisionChartItem.getDivID(), divisionChartItem.getPenaltyNo()) );
                    else if(j==2)
                        series.getData().add(new XYChart.Data(divisionChartItem.getDivID(), divisionChartItem.getLicenseServiceNo()) );
                    else
                        series.getData().add(new XYChart.Data(divisionChartItem.getDivID(), divisionChartItem.getVehicleServiceNo()) );
                }

            }
            else{
                for (YearlySummaryItem yearlySummaryItem : yearlySummaryList){
                    if(j==1)
                        series.getData().add(new XYChart.Data(yearlySummaryItem.getYear(), yearlySummaryItem.getPenaltyNo()) );
                    else if(j==2)
                        series.getData().add(new XYChart.Data(yearlySummaryItem.getYear(), yearlySummaryItem.getLicenseServiceNo()) );
                    else
                        series.getData().add(new XYChart.Data(yearlySummaryItem.getYear(), yearlySummaryItem.getVehicleServiceNo()) );
                }

            }

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../View/dummy.fxml"));
            stage.setTitle("Transport Management System - Chart");
            //stage.setMaximized(false);

            stage.setScene(new Scene(divisionChart,1000,600));
            divisionChart.getData().addAll(series);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void divisionPenaltyChartFunc(ActionEvent event) {
        divisionCharts(1,1);
    }

    @FXML
    void divisionLicenseChartFunc(ActionEvent event) {
        divisionCharts(1,2);
    }

    @FXML
    void divisionVehicleChartFunc(ActionEvent event) {
        divisionCharts(1,3);
    }

    @FXML
    void yearlyVehicleChartFunc(ActionEvent event) {
        divisionCharts(2,3);
    }

    @FXML
    void yearlyLicenseChartFunc(ActionEvent event) {
        divisionCharts(2,2);
    }

    @FXML
    void yearlyPenaltyChartFunc(ActionEvent event) {
        divisionCharts(2,1);
    }

    public static void initializeDivisionSummaryTable() {
        staticDivisionSummaryTable.getColumns().clear();

        TableColumn<DivisionSummaryItem, Integer> divIDCol = new TableColumn<>("Division ID");
        divIDCol.setMinWidth(88);
        divIDCol.setCellValueFactory(new PropertyValueFactory<>("divID"));


        TableColumn<DivisionSummaryItem, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<DivisionSummaryItem, Integer> vehicleNoCol = new TableColumn<>("Number of Vehicles");
        vehicleNoCol.setMinWidth(165);
        vehicleNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));


        TableColumn<DivisionSummaryItem, Integer> licenseNoCol = new TableColumn<>("Number of Licenses");
        licenseNoCol.setMinWidth(165);
        licenseNoCol.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));


        TableColumn<DivisionSummaryItem, Integer> employeeNoCol = new TableColumn<>("Number of Employees");
        employeeNoCol.setMinWidth(165);
        employeeNoCol.setCellValueFactory(new PropertyValueFactory<>("employeeNo"));



        staticDivisionSummaryTable.getColumns().addAll(divIDCol, nameCol, vehicleNoCol, licenseNoCol, employeeNoCol);

        ArrayList <DivisionSummaryItem> dataList = SummaryTable.getDivisionSummary();
        if(dataList==null){
            System.out.println("Vehicle Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (DivisionSummaryItem divisionSummaryItem : dataList){
            obDataList.add(divisionSummaryItem);
        }

        staticDivisionSummaryTable.setEditable(false);
        if(obDataList!=null)
            staticDivisionSummaryTable.setItems(obDataList);


    }


    public static void initializeYearlySummaryTable() {
        staticYearlySummaryTable.getColumns().clear();

        TableColumn<YearlySummaryItem, Integer> yearCol = new TableColumn<>("Year");
        yearCol.setMinWidth(83);
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<YearlySummaryItem, Integer> vehicleNoCol = new TableColumn<>("Registered Vehicles");
        vehicleNoCol.setMinWidth(120);
        vehicleNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));

        TableColumn<YearlySummaryItem, Integer> licenseNoCol = new TableColumn<>("Issued Licenses");
        licenseNoCol.setMinWidth(120);
        licenseNoCol.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));

        TableColumn<YearlySummaryItem, Integer> penaltyNoCol = new TableColumn<>("Penalties");
        penaltyNoCol.setMinWidth(120);
        penaltyNoCol.setCellValueFactory(new PropertyValueFactory<>("penaltyNo"));

        TableColumn<YearlySummaryItem, Integer> vehicleServiceNoCol = new TableColumn<>("Vehicle Services");
        vehicleServiceNoCol.setMinWidth(120);
        vehicleServiceNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleServiceNo"));

        TableColumn<YearlySummaryItem, Integer> licenseServiceNoCol = new TableColumn<>("License Services");
        licenseServiceNoCol.setMinWidth(120);
        licenseServiceNoCol.setCellValueFactory(new PropertyValueFactory<>("licenseServiceNo"));



        staticYearlySummaryTable.getColumns().addAll(yearCol, vehicleNoCol, licenseNoCol, penaltyNoCol, vehicleServiceNoCol, licenseServiceNoCol);


        if(yearlySummaryList==null){
            System.out.println("Vehicle Initialize error");
            return;
        }

        ObservableList obDataList = FXCollections.observableArrayList();

        for (YearlySummaryItem yearlySummaryItem : yearlySummaryList){
            obDataList.add(yearlySummaryItem);
        }

        staticYearlySummaryTable.setEditable(false);
        if(obDataList!=null)
            staticYearlySummaryTable.setItems(obDataList);


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
        ///initialize tables
        staticDivisionSummaryTable = divisionSummaryTable;
        staticYearlySummaryTable = yearlySummaryTable;

        initializeDivisionSummaryTable();

        yearlySummaryList = SummaryTable.getYearlySummary();
        initializeYearlySummaryTable();

        divisionChartList = SummaryTable.getDivisionChartItems();

    }


}
