package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PublicTransportTable {
    public static ArrayList<PublicTransport> getAllPublicTransports(){
        ArrayList <PublicTransport> dataList = new ArrayList<PublicTransport>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from PUBLICTRANSPORT ORDER BY NAME, VEHICLE_REG_NO" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                PublicTransport publicTransport = new PublicTransport(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                dataList.add(publicTransport);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllPublicTransports CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public static PublicTransport findPublicTransport(String name){
        PublicTransport publicTransport = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT NAME, ROUTE, FARE_PER_KM from PUBLICTRANSPORT GROUP BY NAME, ROUTE, FARE_PER_KM having NAME = ? " ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with Name");
                publicTransport = new PublicTransport(-1, rs.getString(1), rs.getString(2), rs.getFloat(3));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findPublicTransport CLOSED Successfully");

            return publicTransport;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updatePublicTransport(PublicTransport publicTransport){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE PUBLICTRANSPORT SET ROUTE = ?, FARE_PER_KM = ? WHERE NAME = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, publicTransport.getRoute());
            pst.setFloat(2, publicTransport.getFare());
            pst.setString(3, publicTransport.getName());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updatePublicTransport CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyPublicTransport(int regNo){
        try{
            Vehicle vehicle = VehicleTable.findVehicle(regNo);
            if(vehicle == null || !vehicle.getType().equals("Bus")){
                throw new Exception();
            }

            Connection con = new DBConnection().connect();
            if(con == null){
                throw new Exception();
            }

            String sql = "SELECT * from PUBLICTRANSPORT WHERE VEHICLE_REG_NO = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, regNo);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                throw new Exception();
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllPublicTransports CLOSED Successfully");

            return true;

        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean insertPublicTransport(PublicTransport publicTransport){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {

            String sql = "INSERT INTO PUBLICTRANSPORT VALUES (? , ?, ?, ?)" ;

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, publicTransport.getRegNo());
            pst.setString(2, publicTransport.getName());
            pst.setString(3, publicTransport.getRoute());
            pst.setFloat(4, publicTransport.getFare());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertPublicTransport CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }


}
