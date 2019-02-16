package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServiceTable {
    public static ArrayList <Service> getAllServices(){
        ArrayList <Service> dataList = new ArrayList<Service>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from SERVICE ORDER BY SID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Service service = new Service(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
                dataList.add(service);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllServices CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean insertService(Service service){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO SERVICE VALUES (? , ?, ?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, service.getSID());
            pst.setString(2, service.getName());
            pst.setFloat(3,service.getFee());
            pst.setString(4, service.getType());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertService CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static Service findService(int SID){
        Service s = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * FROM SERVICE WHERE SID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, SID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with SID");
                s = new Service(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
            }

            pst.close();
            con.close();
            System.out.println("Connection in findService CLOSED Successfully");

            return s;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateService(Service service){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "UPDATE SERVICE SET NAME = ? , FEE = ? , TYPE = ? WHERE SID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, service.getName());
            pst.setFloat(2,service.getFee());
            pst.setString(3, service.getType());
            pst.setInt(4, service.getSID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateService CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }


}
