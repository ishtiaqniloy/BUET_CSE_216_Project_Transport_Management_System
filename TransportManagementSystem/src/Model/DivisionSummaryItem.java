package Model;

import java.util.Objects;

public class DivisionSummaryItem {
    int divID;
    String name;
    int vehicleNo;
    int licenseNo;
    int employeeNo;

    public DivisionSummaryItem(int divID, String name, int vehicleNo, int licenseNo, int employeeNo) {
        this.divID = divID;
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.licenseNo = licenseNo;
        this.employeeNo = employeeNo;
    }

    public int getDivID() {
        return divID;
    }

    public void setDivID(int divID) {
        this.divID = divID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(int licenseNo) {
        this.licenseNo = licenseNo;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionSummaryItem that = (DivisionSummaryItem) o;
        return getDivID() == that.getDivID() &&
                getVehicleNo() == that.getVehicleNo() &&
                getLicenseNo() == that.getLicenseNo() &&
                getEmployeeNo() == that.getEmployeeNo() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDivID(), getName(), getVehicleNo(), getLicenseNo(), getEmployeeNo());
    }

    @Override
    public String toString() {
        return "DivisionSummaryItem{" +
                "divID=" + divID +
                ", name='" + name + '\'' +
                ", vehicleNo=" + vehicleNo +
                ", licenseNo=" + licenseNo +
                ", employeeNo=" + employeeNo +
                '}';
    }
}
