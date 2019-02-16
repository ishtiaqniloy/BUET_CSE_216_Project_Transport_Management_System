//package Model;
//
//import TransportManagementSystem.Main;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class ConnectDBThread extends Thread {
//    public ConnectDBThread(){
//        start();
//    }
//
//    public void run(){
//                System.out.println("Starting Oracle Connection");
//        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Main.con= DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:ORCL","TransportManagement","transport");
//            System.out.println("Connection on = " + !Main.con.isClosed());
////            Statement stmt=Main.con.createStatement();
////
////            ResultSet rs = stmt.executeQuery("select * from Employee ORDER BY Employee_ID");
////
////            while (rs.next())
////                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//}
