package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Report {
    public static ArrayList<ReportItem> getReport(int type){
        ArrayList <ReportItem> dataList = new ArrayList<ReportItem>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from TABLE(GenerateReport(?))" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, type);
            ResultSet rs = pst.executeQuery();

            while (rs.next() && type==2){
                ReportItem reportItem = new ReportItem( Integer.toString( rs.getInt(1)), rs.getString(2), rs.getDate(3).toString(), rs.getString(4), rs.getInt(5) );
                dataList.add(reportItem);
            }

            while (rs.next() && type==1){
                ReportItem reportItem = new ReportItem( rs.getString(1), rs.getString(2), rs.getDate(3).toString(), rs.getString(4), rs.getInt(5) );
                dataList.add(reportItem);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getReport CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
