package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeTable {

    public static ArrayList<Employee> getAllEmployees(){
        ArrayList <Employee> dataList = new ArrayList<Employee>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from EMPLOYEE ORDER BY EMPLOYEE_ID" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Employee employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getFloat(7), rs.getString(8), rs.getInt(9));
                dataList.add(employee);
                //System.out.println(employee);
            }

            pst.close();
            con.close();
            System.out.println("Connection in getAllEmployees CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Employee> findEmployeeByName(String name){
        ArrayList <Employee> dataList = new ArrayList<Employee>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from EMPLOYEE WHERE NAME LIKE '%"+name+"%'" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Employee employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getFloat(7), rs.getString(8), rs.getInt(9));
                dataList.add(employee);
                //System.out.println(employee);
            }

            pst.close();
            con.close();
            System.out.println("Connection in findEmployeeByName CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Employee> findEmployeeByID(String ID){
        ArrayList <Employee> dataList = new ArrayList<Employee>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * from EMPLOYEE WHERE EMPLOYEE_ID LIKE '%"+ID+"%'" ;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Employee employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getFloat(7), rs.getString(8), rs.getInt(9));
                dataList.add(employee);
                //System.out.println(employee);
            }

            pst.close();
            con.close();
            System.out.println("Connection in findEmployeeByID CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Employee> filterEmployeeBySalary(float low, float high){
        ArrayList <Employee> dataList = new ArrayList<Employee>();

        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "Select * from EMPLOYEE where SALARY BETWEEN ? and ?" ;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setFloat(1, low);
            pst.setFloat(2, high);

            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Employee employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getFloat(7), rs.getString(8), rs.getInt(9));
                dataList.add(employee);
                //System.out.println(employee);
            }

            pst.close();
            con.close();
            System.out.println("Connection in filterEmployeeBySalary CLOSED Successfully");

            return dataList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertEmployee(Employee employee){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }
        try{

            String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, to_date(?,  'YYYY-MM-DD'),  to_date(?,  'YYYY-MM-DD'), ?, ?, ?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, employee.getEmployee_ID());
            pst.setString(2, employee.getName());
            pst.setString(3, employee.getAddress());
            pst.setString(4, employee.getJob_type());
            pst.setString(5, employee.getBirth_date());
            pst.setString(6, employee.getHire_date());
            pst.setFloat(7, employee.getSalary());
            pst.setString(8, employee.getMobile_no());
            pst.setInt(9, employee.getDiv_ID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in insertEmployee CLOSED Successfully");

            return true;

        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }

    }

    public static Employee findEmployee(String EID){
        Employee employee = null;
        Connection con = new DBConnection().connect();
        if(con == null){
            return null;
        }

        try {
            String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, EID);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Found with EID");
                employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getFloat(7), rs.getString(8), rs.getInt(9));
                //System.out.println(employee);
            }

            pst.close();
            con.close();
            System.out.println("Connection in findEmployee CLOSED Successfully");

            return employee;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

    }

    public static boolean updateEmployee(Employee employee){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }
        try{
            String sql = "UPDATE EMPLOYEE SET NAME = ?, ADDRESS = ?, JOB_TYPE = ?, BIRTH_DATE = to_date(?,  'YYYY-MM-DD'), HIRE_DATE = to_date(?,  'YYYY-MM-DD'), SALARY = ?, MOBILE_NO = ?, DIV_ID = ?  WHERE EMPLOYEE_ID = ?" ;

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, employee.getName());
            pst.setString(2, employee.getAddress());
            pst.setString(3, employee.getJob_type());
            pst.setString(4, employee.getBirth_date());
            pst.setString(5, employee.getHire_date());
            pst.setFloat(6, employee.getSalary());
            pst.setString(7, employee.getMobile_no());
            pst.setInt(8, employee.getDiv_ID());
            pst.setString(9, employee.getEmployee_ID());

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in updateEmployee CLOSED Successfully");

            return true;

        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }



    }

    public static boolean deleteEmployee(String EID){
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try{
            String sql = "Delete EMPLOYEE WHERE EMPLOYEE_ID = ?" ;

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, EID);

            pst.execute();
            pst.close();
            con.close();
            System.out.println("Connection in deleteEmployee CLOSED Successfully");

            return true;

        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }


    }

    public static boolean increaseSalary(float p1, float p2) {
        Connection con = new DBConnection().connect();
        if(con == null){
            return false;
        }

        try{
            String sql = "DECLARE\n" +
                    "BEGIN\n" +
                    "\t\tINCREASE_SALARY(?, ?);\n" +
                    "END;";

            //System.out.println(sql);

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setFloat(1, p1);
            pst.setFloat(2, p2);

            pst.executeQuery();
            pst.close();
            con.close();
            System.out.println("Connection in increaseSalary CLOSED Successfully");

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
