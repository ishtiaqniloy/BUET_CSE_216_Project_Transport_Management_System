package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VehicleTable {
    public static ArrayList<Vehicle> getAllVehicles(){
        ArrayList <Vehicle> dataList = new ArrayList<Vehicle>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from VEHICLE ORDER BY REG_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Vehicle vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11),  rs.getString(12), rs.getInt(13));
                dataList.add(vehicle);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllVehicles CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Vehicle> searchByRegNo(String regNo){
        ArrayList <Vehicle> dataList = new ArrayList<Vehicle>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from VEHICLE WHERE TO_CHAR(REG_NO) LIKE '%" + regNo + "%' ORDER BY REG_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Vehicle vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11),  rs.getString(12), rs.getInt(13));
                dataList.add(vehicle);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByRegNo CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Vehicle> searchByType(String type){
        ArrayList <Vehicle> dataList = new ArrayList<Vehicle>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from VEHICLE WHERE TYPE LIKE '%" + type + "%' ORDER BY REG_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Vehicle vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11),  rs.getString(12), rs.getInt(13));
                dataList.add(vehicle);
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

    public static ArrayList<Vehicle> searchByModel(String model){
        ArrayList <Vehicle> dataList = new ArrayList<Vehicle>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from VEHICLE WHERE MODEL LIKE '%" + model + "%' ORDER BY REG_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Vehicle vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11),  rs.getString(12), rs.getInt(13));
                dataList.add(vehicle);
            }

            pst.close();
            con.close();
            System.out.println("Connection in searchByModel CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean insertVehicle(Vehicle vehicle){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try{
            String sql = "SELECT * FROM OWNER WHERE OWNER_NID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vehicle.getOwnerNID());
            ResultSet rs = pst.executeQuery();

            if(!rs.next()){
                throw new Exception();
            }

        }catch (Exception e){
            return false;
        }

        try {

            String sql = "INSERT INTO VEHICLE VALUES (? , ?, to_date(?,  'YYYY-MM-DD'), ?, ?, to_date(?,  'YYYY-MM-DD'),  to_date(?,  'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?)" ;

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vehicle.getRegNo());
            pst.setString(2, vehicle.getOwnerNID());
            pst.setString(3, vehicle.getRegDate());
            pst.setString(4, vehicle.getVehicleModel());
            pst.setString(5, vehicle.getType());
            pst.setString(6, vehicle.getTaxValidityDate());
            pst.setString(7, vehicle.getFitnessValidityDate());
            pst.setInt(8,vehicle.getEngineCC());
            pst.setInt(9,vehicle.getSeats());
            pst.setInt(10,vehicle.getWeight());
            pst.setInt(11,vehicle.getTireSize());
            pst.setString(12, vehicle.getTransmission());
            pst.setInt(13,vehicle.getDivID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertVehicle CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static Vehicle findVehicle(int regNo){
        Vehicle vehicle = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from VEHICLE WHERE REG_NO = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, regNo);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with regNo");
                vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4),
                        rs.getString(5), rs.getDate(6).toString(), rs.getDate(7).toString(), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11),  rs.getString(12), rs.getInt(13));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findVehicle CLOSED Successfully");

            return vehicle;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateVehicle(Vehicle vehicle){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try{
            String sql = "SELECT * FROM OWNER WHERE OWNER_NID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vehicle.getOwnerNID());
            ResultSet rs = pst.executeQuery();

            if(!rs.next()){
                throw new Exception();
            }

        }catch (Exception e){
            return false;
        }

        try {
            String sql = "UPDATE VEHICLE SET OWNER_NID = ?, REG_DATE = to_date(?,  'YYYY-MM-DD'), MODEL = ?, TYPE = ?, TAX_VALIDITY_DATE = to_date(?,  'YYYY-MM-DD'), " +
                    "FITNESS_VALIDITY_DATE = to_date(?,  'YYYY-MM-DD'), ENGINE_CC = ?, SEATS = ?, WEIGHT = ?, TIRE_SIZE = ?, TRANSMISSION = ?, DIV_ID = ? " +
                    "WHERE REG_NO = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, vehicle.getOwnerNID());
            pst.setString(2, vehicle.getRegDate());
            pst.setString(3, vehicle.getVehicleModel());
            pst.setString(4, vehicle.getType());
            pst.setString(5, vehicle.getTaxValidityDate());
            pst.setString(6, vehicle.getFitnessValidityDate());
            pst.setInt(7,vehicle.getEngineCC());
            pst.setInt(8,vehicle.getSeats());
            pst.setInt(9,vehicle.getWeight());
            pst.setInt(10,vehicle.getTireSize());
            pst.setString(11, vehicle.getTransmission());
            pst.setInt(12,vehicle.getDivID());
            pst.setInt(13, vehicle.getRegNo());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateVehicle CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static int getFreeVehicleNo(){
        int freeVehicleNo = -1;
        Connection con = new DBConnection().connect();
        if(con == null){
            return -1;
        }

        try {
            String sql = "SELECT MAX(REG_NO) FROM VEHICLE";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                freeVehicleNo = rs.getInt(1) + 1;
            }

            pst.close();
            con.close();
            System.out.println("Connection in getFreeVehicleNo CLOSED Successfully");

            return freeVehicleNo;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }


}
