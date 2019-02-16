package Model;

import java.util.Objects;

public class DivisionChartItem {
    int divID;
    int penaltyNo;
    int licenseServiceNo;
    int vehicleServiceNo;

    public DivisionChartItem(int divID, int penaltyNo, int licenseServiceNo, int vehicleServiceNo) {
        this.divID = divID;
        this.penaltyNo = penaltyNo;
        this.licenseServiceNo = licenseServiceNo;
        this.vehicleServiceNo = vehicleServiceNo;
    }

    public int getDivID() {
        return divID;
    }

    public void setDivID(int divID) {
        this.divID = divID;
    }

    public int getPenaltyNo() {
        return penaltyNo;
    }

    public void setPenaltyNo(int penaltyNo) {
        this.penaltyNo = penaltyNo;
    }

    public int getLicenseServiceNo() {
        return licenseServiceNo;
    }

    public void setLicenseServiceNo(int licenseServiceNo) {
        this.licenseServiceNo = licenseServiceNo;
    }

    public int getVehicleServiceNo() {
        return vehicleServiceNo;
    }

    public void setVehicleServiceNo(int vehicleServiceNo) {
        this.vehicleServiceNo = vehicleServiceNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionChartItem that = (DivisionChartItem) o;
        return getDivID() == that.getDivID() &&
                getPenaltyNo() == that.getPenaltyNo() &&
                getLicenseServiceNo() == that.getLicenseServiceNo() &&
                getVehicleServiceNo() == that.getVehicleServiceNo();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDivID(), getPenaltyNo(), getLicenseServiceNo(), getVehicleServiceNo());
    }

    @Override
    public String toString() {
        return "DivisionChartItem{" +
                "divID=" + divID +
                ", penaltyNo=" + penaltyNo +
                ", licenseServiceNo=" + licenseServiceNo +
                ", vehicleServiceNo=" + vehicleServiceNo +
                '}';
    }
}
