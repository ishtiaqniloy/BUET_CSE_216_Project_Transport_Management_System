package Model;

import java.util.Date;

public class Employee {
    String employee_ID;
    String name;
    String address;
    String job_type;
    String birth_date;
    String hire_date;
    Float salary;
    String mobile_no;
    Integer div_ID;


    public Employee(String employee_ID, String name, String address, String job_type, String birth_date, String hire_date, Float salary, String mobile_no, Integer div_ID) {
        this.employee_ID = employee_ID;
        this.name = name;
        this.address = address;
        this.job_type = job_type;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.salary = salary;
        this.mobile_no = mobile_no;
        this.div_ID = div_ID;
    }

    public String getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Integer getDiv_ID() {
        return div_ID;
    }

    public void setDiv_ID(Integer div_ID) {
        this.div_ID = div_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!getEmployee_ID().equals(employee.getEmployee_ID())) return false;
        if (!getName().equals(employee.getName())) return false;
        if (!getAddress().equals(employee.getAddress())) return false;
        if (!getJob_type().equals(employee.getJob_type())) return false;
        if (!getBirth_date().equals(employee.getBirth_date())) return false;
        if (!getHire_date().equals(employee.getHire_date())) return false;
        if (!getSalary().equals(employee.getSalary())) return false;
        if (!getMobile_no().equals(employee.getMobile_no())) return false;
        return getDiv_ID().equals(employee.getDiv_ID());
    }

    @Override
    public int hashCode() {
        int result = getEmployee_ID().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getJob_type().hashCode();
        result = 31 * result + getBirth_date().hashCode();
        result = 31 * result + getHire_date().hashCode();
        result = 31 * result + getSalary().hashCode();
        result = 31 * result + getMobile_no().hashCode();
        result = 31 * result + getDiv_ID().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_ID='" + employee_ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", job_type='" + job_type + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", hire_date='" + hire_date + '\'' +
                ", salary=" + salary +
                ", mobile_no='" + mobile_no + '\'' +
                ", div_ID=" + div_ID +
                '}';
    }
}
