package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LicenseTable {
    public static ArrayList<License> getAllLicenses(){
        ArrayList <License> dataList = new ArrayList<License>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from LICENSE ORDER BY LICENSE_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                License license = new License(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getDate(4).toString(),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
                dataList.add(license);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllLicenses CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<License> getSuspendedLicenses(){
        ArrayList <License> dataList = new ArrayList<License>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from LICENSE where STATUS <> 'ACTIVE' ORDER BY LICENSE_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                License license = new License(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getDate(4).toString(),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
                dataList.add(license);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllLicenses CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<License> searchByLicenseNo(String licenseNo){
        ArrayList <License> dataList = new ArrayList<License>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from LICENSE where TO_CHAR(LICENSE_NO) LIKE '%"+ licenseNo +"%' ORDER BY LICENSE_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                License license = new License(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getDate(4).toString(),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
                dataList.add(license);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByLicenseNo CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<License> searchByType(String type){
        ArrayList <License> dataList = new ArrayList<License>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from LICENSE where TYPE LIKE '%"+ type +"%' ORDER BY LICENSE_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                License license = new License(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getDate(4).toString(),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
                dataList.add(license);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByType CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static License findLicense(long licenseNo){
        License license = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from LICENSE WHERE LICENSE_NO = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, licenseNo);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with NID");
                license = new License(rs.getLong(1), rs.getLong(2), rs.getDate(3).toString(), rs.getDate(4).toString(),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findLicense CLOSED Successfully");

            return license;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateLicense(License license){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE LICENSE SET DRIVER_NID = ? , ISSUE_DATE = to_date(?,  'YYYY-MM-DD') , VALIDITY_DATE = to_date(?,  'YYYY-MM-DD') , " +
                    "TYPE = ? , DIV_ID = ?, STATUS = ? WHERE LICENSE_NO = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, license.getDriverNID());
            pst.setString(2, license.getIssueDate());
            pst.setString(3, license.getValidityDate());
            pst.setString(4, license.getType());
            pst.setInt(5, license.getDivID());
            pst.setString(6, license.getStatus());
            pst.setLong(7, license.getLicenseNo());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateLicense CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean insertLicense(License license){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO LICENSE VALUES (? , ?, to_date(?,  'YYYY-MM-DD'), to_date(?,  'YYYY-MM-DD'), ?, ?, ?)" ;

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, license.getLicenseNo());
            pst.setLong(2, license.getDriverNID());
            pst.setString(3, license.getIssueDate());
            pst.setString(4, license.getValidityDate());
            pst.setString(5, license.getType());
            pst.setInt(6, license.getDivID());
            pst.setString(7, license.getStatus());


            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertLicense CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean changeStatus(){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try{
            String sql = "DECLARE\n" +
                    "BEGIN\n" +
                    "\t\tLICENSE_STATUS_CHANGE_WORK;\n" +
                    "END;";

            PreparedStatement pst = con.prepareStatement(sql);


            pst.executeQuery();
            pst.close();
            con.close();
            System.out.println("Connection in changeStatus CLOSED Successfully");

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<LicenseReportItem> getLicenseReport(){
        ArrayList <LicenseReportItem> dataList = new ArrayList<LicenseReportItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from TABLE (GENERATE_PENALTY_INFO) ORDER BY OBJECT_PENALTY_NO DESC" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                LicenseReportItem licenseReportItem = new LicenseReportItem(rs.getLong(1), rs.getInt(2));
                dataList.add(licenseReportItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllLicenses CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static long getFreeLicenseNo(){
        long freeLicenseNo = -1;
        Connection con = new DBConnection().connect();
        if(con == null){
            return -1;
        }

        try {
            String sql = "SELECT MAX(LICENSE_NO) FROM LICENSE";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                freeLicenseNo = rs.getLong(1) + 1;
            }

            pst.close();
            con.close();
            System.out.println("Connection in getFreeLicenseNo CLOSED Successfully");

            return freeLicenseNo;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }


}

