package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DriverTable {
    public static ArrayList<Driver> getAllDrivers(){
        ArrayList <Driver> dataList = new ArrayList<Driver>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT DRIVER_NID, NVL(LICENSE_NO, -1) , NAME , FATHER_NAME , ADDRESS, BIRTH_DATE, BLOOD_GROUP, MOBILE_NO from DRIVER ORDER BY DRIVER_NID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Driver driver = new Driver(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getString(7), rs.getString(8));
                dataList.add(driver);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllDrivers CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Driver> getApplicants(){
        ArrayList <Driver> dataList = new ArrayList<Driver>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT DRIVER_NID, NVL(LICENSE_NO, -1) , NAME , FATHER_NAME , ADDRESS, BIRTH_DATE, BLOOD_GROUP, MOBILE_NO from DRIVER WHERE LICENSE_NO is NULL ORDER BY DRIVER_NID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Driver driver = new Driver(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getString(7), rs.getString(8));
                dataList.add(driver);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getApplicants CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Driver> searchByName(String name){
        ArrayList <Driver> dataList = new ArrayList<Driver>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT DRIVER_NID, NVL(LICENSE_NO, -1) , NAME , FATHER_NAME , ADDRESS, BIRTH_DATE, BLOOD_GROUP, MOBILE_NO from DRIVER WHERE NAME LIKE '%" +name+ "%'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Driver driver = new Driver(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getString(7), rs.getString(8));
                dataList.add(driver);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByName CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Driver> searchByNID(String  nid){
        ArrayList <Driver> dataList = new ArrayList<Driver>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT DRIVER_NID, NVL(LICENSE_NO, -1) , NAME , FATHER_NAME , ADDRESS, BIRTH_DATE, BLOOD_GROUP, MOBILE_NO from DRIVER WHERE TO_CHAR(DRIVER_NID) LIKE '%" +nid+ "%'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Driver driver = new Driver(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getString(7), rs.getString(8));
                dataList.add(driver);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByNID CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Driver findDriver(long NID){
        Driver driver = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from DRIVER WHERE DRIVER_NID = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, NID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with NID");
                driver = new Driver(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getString(7), rs.getString(8));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findDriver CLOSED Successfully");

            return driver;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateDriver(Driver driver){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE DRIVER SET LICENSE_NO = ? , NAME = ? , FATHER_NAME = ? , ADDRESS = ? , " +
                    "BIRTH_DATE = to_date(?,  'YYYY-MM-DD') , BLOOD_GROUP = ? , MOBILE_NO = ? WHERE DRIVER_NID = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1, driver.getLicenseNo());
            pst.setString(2, driver.getName());
            pst.setString(3, driver.getFathersName());
            pst.setString(4, driver.getAddress());
            pst.setString(5, driver.getBirthDate());
            pst.setString(6, driver.getBloodGroup());
            pst.setString(7, driver.getMobileNo());
            pst.setLong(8, driver.getDriverNID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateDriver CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }




}
