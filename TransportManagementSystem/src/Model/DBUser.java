package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser {

    public static boolean validateLogin( String username, String password){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "SELECT * from DBUSER WHERE USERNAME = ? AND PASSWORD = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            boolean validation = rs.next();
            pst.close();
            con.close();
            System.out.println("Connection in validateLogin CLOSED Successfully");

            return validation;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public static boolean createNewUser(String newUsername, String newPassword){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try {
            String sql = "INSERT INTO DBUSER VALUES (? , ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, newUsername);
            pst.setString(2, newPassword);

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in createNewUser CLOSED Successfully");

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }


    }


}
