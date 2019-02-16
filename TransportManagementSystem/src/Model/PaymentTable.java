package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentTable {
    public static ArrayList<Payment> getAllPayments(){
        ArrayList <Payment> dataList = new ArrayList<Payment>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from TABLE (GeneratePaymentTable)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Payment payment = new Payment(rs.getInt(1), rs.getFloat(2), rs.getDate(3).toString(), rs.getInt(4), rs.getString(5), rs.getString(6));
                dataList.add(payment);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllPayments CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean insertPayment(Payment payment){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }
        try {
            String sql = "INSERT INTO PAYMENT VALUES (? , ?,  to_date(?,  'YYYY-MM-DD'), ?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, payment.getPaymentNo());
            pst.setFloat(2, payment.getAmount());
            pst.setString(3, payment.getPaymentDate());
            pst.setInt(4, payment.getHistoryNo());
            pst.setString(5, payment.getType());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertPayment CLOSED Successfully");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int getFreePaymentNo(){
        int freePaymentNo = 1;
        Connection con = new DBConnection().connect();
        if(con == null){
            return -1;
        }

        try {
            String sql = "SELECT PAYMENT_NO FROM PAYMENT";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                if(freePaymentNo != rs.getInt(1)) return freePaymentNo;
                freePaymentNo++;
            }

            pst.close();
            con.close();
            System.out.println("Connection in getFreePaymentNo CLOSED Successfully");

            return freePaymentNo;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }


}
