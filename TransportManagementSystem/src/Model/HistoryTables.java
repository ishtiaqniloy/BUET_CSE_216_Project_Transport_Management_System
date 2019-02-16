package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HistoryTables {
    private static final int VSH = 1;
    private static final int LSH = 2;
    private static final int PH = 3;
    public static ArrayList<HistoryItem> getVehicleServiceHistory(){
        ArrayList <HistoryItem> dataList = new ArrayList<HistoryItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT V.ENTRY_NO, V.SERVICE_ID, S.NAME, S.FEE, V.VEHICLE_REG_NO, V.SERVICE_DATE, V.STATUS, NVL(PM.PAYMENT_NO, -1) from VEHICLESERVICEHISTORY V LEFT OUTER JOIN SERVICE S ON (V.SERVICE_ID = S.SID) LEFT OUTER JOIN PAYMENT PM ON (V.ENTRY_NO = PM.HISTORY_NO) ORDER BY V.ENTRY_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                HistoryItem historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), -1, rs.getDate(6).toString(), rs.getString(7), rs.getInt(8));
                dataList.add(historyItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getVehicleServiceHistory CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<HistoryItem> getLicenseServiceHistory(){
        ArrayList <HistoryItem> dataList = new ArrayList<HistoryItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT L.ENTRY_NO, L.SERVICE_ID, S.NAME, S.FEE, L.LICENSE_NO, L.SERVICE_DATE, L.STATUS, NVL(PM.PAYMENT_NO, -1) from LICENSESERVICEHISTORY L LEFT OUTER JOIN SERVICE S ON ( L.SERVICE_ID = S.SID) LEFT OUTER JOIN PAYMENT PM ON (L.ENTRY_NO = PM.HISTORY_NO) ORDER BY L.ENTRY_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                HistoryItem historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4),-1, rs.getLong(5), rs.getDate(6).toString(), rs.getString(7), rs.getInt(8));
                dataList.add(historyItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getLicenseServiceHistory CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<HistoryItem> getPenaltyHistory(){
        ArrayList <HistoryItem> dataList = new ArrayList<HistoryItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT PH.ENTRY_NO, PH.PENALTY_ID, P.NAME, P.FINE, PH.V_REG_NO, PH.LICENSE_NO, PH.PENALTY_DATE, PH.STATUS, NVL(PM.PAYMENT_NO, -1) from PENALTYHISTORY PH LEFT OUTER JOIN PENALTY P ON ( PH.PENALTY_ID = P.PID) LEFT OUTER JOIN PAYMENT PM ON (PH.ENTRY_NO = PM.HISTORY_NO) ORDER BY PH.ENTRY_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                HistoryItem historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getLong(6), rs.getDate(7).toString(), rs.getString(8), rs.getInt(9));
                //System.out.println(historyItem);
                dataList.add(historyItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getPenaltyHistory CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int getMaxEntryNo(int type){
        int maxEntryNo = -1;
        Connection con = new DBConnection().connect();
        if(con == null){
            return -1;
        }

        try {
            String sql = "SELECT MAX(ENTRY_NO) FROM  ";

            if(type == VSH)   sql = sql + "VEHICLESERVICEHISTORY" ;
            else if (type == LSH) sql = sql + "LICENSESERVICEHISTORY" ;
            else sql = sql + "PENALTYHISTORY" ;

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                maxEntryNo = rs.getInt(1);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getMaxEntryNo CLOSED Successfully");

            return maxEntryNo;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static int getFreeEntryNo(int type){
        int freeEntryNo = -1;
        Connection con = new DBConnection().connect();
        if(con == null){
            return -1;
        }

        try {
            String sql = "SELECT ENTRY_NO FROM  ";

            if(type == VSH){
                sql = sql + "VEHICLESERVICEHISTORY" ;
                freeEntryNo = 2001;
            }
            else if (type == LSH){
                sql = sql + "LICENSESERVICEHISTORY" ;
                freeEntryNo = 1001;
            }
            else{
                sql = sql + "PENALTYHISTORY" ;
                freeEntryNo = 3001;
            }

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                if(freeEntryNo != rs.getInt(1)) return freeEntryNo;
                freeEntryNo++;
            }

            pst.close();
            con.close();
            System.out.println("Connection in getFreeEntryNo CLOSED Successfully");

            return freeEntryNo;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static boolean insertHistoryEntry (int type, HistoryItem historyItem){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO ";
            PreparedStatement pst = null;
            if(type == VSH){
                sql = sql + "VEHICLESERVICEHISTORY VALUES (?, ?, ?,  to_date(?,  'YYYY-MM-DD'), ?)";

                pst = con.prepareStatement(sql);
                pst.setInt(1, historyItem.getEntryNo());
                pst.setInt(2, historyItem.getID());
                pst.setInt(3, historyItem.getVehicleRegNo());
                pst.setString(4, historyItem.getDate());
                pst.setString(5, historyItem.getStatus());

            }
            else if (type == LSH){
                sql = sql + "LICENSESERVICEHISTORY VALUES (?, ?, ?,  to_date(?,  'YYYY-MM-DD'), ?)";

                pst = con.prepareStatement(sql);
                pst.setInt(1, historyItem.getEntryNo());
                pst.setInt(2, historyItem.getID());
                pst.setLong(3, historyItem.getLicenseNo());
                pst.setString(4, historyItem.getDate());
                pst.setString(5, historyItem.getStatus());
            }
            else{
                sql = sql + "PENALTYHISTORY VALUES (?, ?, ?, ?,  to_date(?,  'YYYY-MM-DD'), ?)";

                pst = con.prepareStatement(sql);
                pst.setInt(1, historyItem.getEntryNo());
                pst.setInt(2, historyItem.getID());
                pst.setInt(3, historyItem.getVehicleRegNo());
                pst.setLong(4, historyItem.getLicenseNo());
                pst.setString(5, historyItem.getDate());
                pst.setString(6, historyItem.getStatus());
            }



            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertHistoryEntry CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }

    }

    public static HistoryItem getHistoryItem(int entryNo){
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            HistoryItem historyItem = null;

            if(entryNo < 2000){
                String sql = "SELECT L.ENTRY_NO, L.SERVICE_ID, S.NAME, S.FEE, L.LICENSE_NO, L.SERVICE_DATE, L.STATUS, NVL(PM.PAYMENT_NO, -1) from LICENSESERVICEHISTORY L LEFT OUTER JOIN SERVICE S ON ( L.SERVICE_ID = S.SID) LEFT OUTER JOIN PAYMENT PM ON (L.ENTRY_NO = PM.HISTORY_NO) WHERE L.ENTRY_NO = ?" ;
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, entryNo);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4),-1, rs.getLong(5), rs.getDate(6).toString(), rs.getString(7), rs.getInt(8));
                }
                pst.close();
            }

            else if(entryNo < 3000){
                String sql = "SELECT V.ENTRY_NO, V.SERVICE_ID, S.NAME, S.FEE, V.VEHICLE_REG_NO, V.SERVICE_DATE, V.STATUS, NVL(PM.PAYMENT_NO, -1) from VEHICLESERVICEHISTORY V LEFT OUTER JOIN SERVICE S ON (V.SERVICE_ID = S.SID) LEFT OUTER JOIN PAYMENT PM ON (V.ENTRY_NO = PM.HISTORY_NO) WHERE V.ENTRY_NO = ?" ;
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, entryNo);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), -1, rs.getDate(6).toString(), rs.getString(7), rs.getInt(8));
                }
                pst.close();
            }
            else{
                String sql = "SELECT PH.ENTRY_NO, PH.PENALTY_ID, P.NAME, P.FINE, PH.V_REG_NO, PH.LICENSE_NO, PH.PENALTY_DATE, PH.STATUS, NVL(PM.PAYMENT_NO, -1) from PENALTYHISTORY PH LEFT OUTER JOIN PENALTY P ON ( PH.PENALTY_ID = P.PID) LEFT OUTER JOIN PAYMENT PM ON (PH.ENTRY_NO = PM.HISTORY_NO) WHERE PH.ENTRY_NO = ?" ;
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, entryNo);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    historyItem = new HistoryItem(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getLong(6), rs.getDate(7).toString(), rs.getString(8), rs.getInt(9));
                }
                pst.close();
            }

            con.close();
            System.out.println("Connection in getHistoryItem CLOSED Successfully");

            return historyItem;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }



}
