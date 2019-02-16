package Model;

import TransportManagementSystem.Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection con;
    public DBConnection(){
        con=null;
    }

    public Connection connect(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL","TransportManagement","transport");
            System.out.println("Connection on = " + !con.isClosed());

            return con;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}
