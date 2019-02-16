package Model;

import java.util.Objects;

public class YearlySummaryItem {
    int year;
    int vehicleNo;
    int licenseNo;
    int penaltyNo;
    int vehicleServiceNo;
    int licenseServiceNo;

    public YearlySummaryItem(int year, int vehicleNo, int licenseNo, int penaltyNo, int vehicleServiceNo, int licenseServiceNo) {
        this.year = year;
        this.vehicleNo = vehicleNo;
        this.licenseNo = licenseNo;
        this.penaltyNo = penaltyNo;
        this.vehicleServiceNo = vehicleServiceNo;
        this.licenseServiceNo = licenseServiceNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getPenaltyNo() {
        return penaltyNo;
    }

    public void setPenaltyNo(int penaltyNo) {
        this.penaltyNo = penaltyNo;
    }

    public int getVehicleServiceNo() {
        return vehicleServiceNo;
    }

    public void setVehicleServiceNo(int vehicleServiceNo) {
        this.vehicleServiceNo = vehicleServiceNo;
    }

    public int getLicenseServiceNo() {
        return licenseServiceNo;
    }

    public void setLicenseServiceNo(int licenseServiceNo) {
        this.licenseServiceNo = licenseServiceNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearlySummaryItem that = (YearlySummaryItem) o;
        return getYear() == that.getYear() &&
                getVehicleNo() == that.getVehicleNo() &&
                getLicenseNo() == that.getLicenseNo() &&
                getPenaltyNo() == that.getPenaltyNo() &&
                getVehicleServiceNo() == that.getVehicleServiceNo() &&
                getLicenseServiceNo() == that.getLicenseServiceNo();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getYear(), getVehicleNo(), getLicenseNo(), getPenaltyNo(), getVehicleServiceNo(), getLicenseServiceNo());
    }

    @Override
    public String toString() {
        return "YearlySummaryItem{" +
                "year=" + year +
                ", vehicleNo=" + vehicleNo +
                ", licenseNo=" + licenseNo +
                ", penaltyNo=" + penaltyNo +
                ", vehicleServiceNo=" + vehicleServiceNo +
                ", licenseServiceNo=" + licenseServiceNo +
                '}';
    }
}
