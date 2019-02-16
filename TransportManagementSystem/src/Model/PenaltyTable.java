package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PenaltyTable {
    public static ArrayList <Penalty> getAllPenalties(){
        ArrayList <Penalty> dataList = new ArrayList<Penalty>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from Penalty ORDER BY PID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Penalty penalty = new Penalty(rs.getInt(1), rs.getString(2), rs.getString(3),   rs.getFloat(4));
                dataList.add(penalty);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllPenalties CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean insertPenalty(Penalty penalty){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO PENALTY VALUES (? , ?, ?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, penalty.getPID());
            pst.setString(2, penalty.getSection());
            pst.setString(3, penalty.getName());
            pst.setFloat(4,penalty.getFine());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertPenalty CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static Penalty findPenalty(int PID){
        Penalty p = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * FROM PENALTY WHERE PID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, PID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with PID");
                p = new Penalty(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findPenalty CLOSED Successfully");

            return p;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updatePenalty(Penalty penalty){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE PENALTY SET SECTION = ? , NAME = ? , FINE = ? WHERE PID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, penalty.getSection());
            pst.setString(2, penalty.getName());
            pst.setFloat(3, penalty.getFine());
            pst.setInt(4, penalty.getPID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updatePenalty CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }


}
