package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SummaryTable {
    public static ArrayList<DivisionSummaryItem> getDivisionSummary(){
        ArrayList <DivisionSummaryItem> dataList = new ArrayList<DivisionSummaryItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT D.DIV_ID, D.NAME, (SELECT COUNT(V.REG_NO) from VEHICLE V WHERE D.DIV_ID = V.DIV_ID), (SELECT count(L.License_No) from LICENSE L where D.DIV_ID = L.DIV_ID), (SELECT count(E.EMPLOYEE_ID) from EMPLOYEE E where D.DIV_ID = E.DIV_ID) from DIVISION D ORDER BY D.DIV_ID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
               DivisionSummaryItem divisionSummaryItem = new DivisionSummaryItem(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                dataList.add(divisionSummaryItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getDivisionSummary CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<YearlySummaryItem> getYearlySummary(){
        ArrayList <YearlySummaryItem> dataList = new ArrayList<YearlySummaryItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from TABLE (GenerateYearlySummary)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                YearlySummaryItem yearlySummaryItem = new YearlySummaryItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),  rs.getInt(6));
                dataList.add(yearlySummaryItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getYearlySummary CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<DivisionChartItem> getDivisionChartItems(){
        ArrayList <DivisionChartItem> dataList = new ArrayList<DivisionChartItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT D.DIV_ID, \n" +
                    "(SELECT COUNT( P.ENTRY_NO) FROM PENALTYHISTORY P join VEHICLE V on (P.V_REG_NO = V.REG_NO) WHERE V.DIV_ID = D.DIV_ID ),\n" +
                    "(SELECT COUNT( LH.ENTRY_NO) FROM LICENSESERVICEHISTORY LH join LICENSE L on (LH.LICENSE_NO = L.LICENSE_NO) WHERE L.DIV_ID = D.DIV_ID ),\n" +
                    "(SELECT COUNT( VH.ENTRY_NO) FROM VEHICLESERVICEHISTORY VH join VEHICLE V on (VH.VEHICLE_REG_NO = V.REG_NO) WHERE V.DIV_ID = D.DIV_ID )\n" +
                    "from DIVISION D ORDER BY D.DIV_ID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                DivisionChartItem divisionChartItem = new DivisionChartItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                dataList.add(divisionChartItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getDivisionPenaltySummary CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }




}
