package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ApplicationTable {
    public static ArrayList<Application> getAllApplications(){
        ArrayList <Application> dataList = new ArrayList<Application>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT APPLICATION_NUMBER, DRIVER_NID, EXAM_DATE, NVL(RESULT, 'Pending'), DIV_ID, LICENSE_TYPE from APPLICATION ORDER BY APPLICATION_NUMBER" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Application application = new Application(rs.getInt(1), rs.getLong(2), rs.getDate(3).toString(),
                        rs.getString(4), rs.getInt(5), rs.getString(6));
                dataList.add(application);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllApplications CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Application> getPendingApplications(){
        ArrayList <Application> dataList = new ArrayList<Application>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT APPLICATION_NUMBER, DRIVER_NID, EXAM_DATE, NVL(RESULT, 'Pending'), DIV_ID, LICENSE_TYPE from APPLICATION  WHERE RESULT IS NULL ORDER BY APPLICATION_NUMBER" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Application application = new Application(rs.getInt(1), rs.getLong(2), rs.getDate(3).toString(),
                        rs.getString(4), rs.getInt(5), rs.getString(6));
                dataList.add(application);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getWaitingApplications CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Application> getCheckableApplications(){
        ArrayList <Application> dataList = new ArrayList<Application>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT APPLICATION_NUMBER, DRIVER_NID, EXAM_DATE, NVL(RESULT, 'Pending'), DIV_ID, LICENSE_TYPE from APPLICATION  WHERE RESULT IS NULL AND EXAM_DATE < SYSDATE ORDER BY APPLICATION_NUMBER" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Application application = new Application(rs.getInt(1), rs.getLong(2), rs.getDate(3).toString(),
                        rs.getString(4), rs.getInt(5), rs.getString(6));
                dataList.add(application);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getCheckableApplications CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean passApplication(Application application){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE APPLICATION SET RESULT = 'Pass' WHERE APPLICATION_NUMBER = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, application.getApplicationNumber());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in passApplication CLOSED Successfully");


            long licenseNo = LicenseTable.getFreeLicenseNo();
            if(licenseNo == -1){
                throw new Exception();
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String issueDate = dateFormat.format(cal.getTime());
            cal.add(Calendar.DATE, 365);
            String validityDate = dateFormat.format(cal.getTime());

            License license = new License(licenseNo, application.getDriverNID(), issueDate, validityDate, application.getLicenseType(), application.getDivID(), "ACTIVE");
            boolean success = LicenseTable.insertLicense(license);

            if(!success){
                throw new Exception();
            }

            Driver driver = DriverTable.findDriver(application.getDriverNID());
            driver.setLicenseNo(licenseNo);
            success = DriverTable.updateDriver(driver);

            if(!success){
                throw new Exception();
            }

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean failApplication(Application application){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE APPLICATION SET RESULT = 'FAILED' WHERE APPLICATION_NUMBER = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, application.getApplicationNumber());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in failApplication CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

}
