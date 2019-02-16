package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OwnerTable {

    public static ArrayList<Owner> getAllOwners(){
        ArrayList <Owner> dataList = new ArrayList<Owner>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from OWNER ORDER BY OWNER_NID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Owner owner = new Owner(rs.getString(1), rs.getString(2), rs.getString(3),   rs.getString(4), rs.getString(5), rs.getInt(6));
                dataList.add(owner);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllOwners CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean insertOwner(Owner owner){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO OWNER VALUES (? , ?, ?, ?, ?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, owner.getOwnerNID());
            pst.setString(2, owner.getName());
            pst.setString(3, owner.getAddress());
            pst.setString(4, owner.getETIN());
            pst.setString(5, owner.getMobileNo());
            pst.setInt(6, owner.getNumberOfVehicles());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertOwner CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static Owner findOwner(String NID){
        Owner owner = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * FROM OWNER WHERE OWNER_NID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, NID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with NID");
                owner = new Owner(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findOwner CLOSED Successfully");

            return owner;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateOwner(Owner owner){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE OWNER SET NAME = ?, ADDRESS = ?, ETIN = ?, MOBILE_NO = ?, NUMBER_OF_VEHICLES = ? WHERE OWNER_NID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, owner.getName());
            pst.setString(2, owner.getAddress());
            pst.setString(3, owner.getETIN());
            pst.setString(4, owner.getMobileNo());
            pst.setInt(5, owner.getNumberOfVehicles());
            pst.setString(6, owner.getOwnerNID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateOwner CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }




}
