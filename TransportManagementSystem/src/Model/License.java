package Model;

import java.util.Objects;

public class License {
    long licenseNo;
    long driverNID;
    String issueDate;
    String  validityDate;
    String type;
    int divID;
    String status;

    public License(long licenseNo, long driverNID, String issueDate, String validityDate, String type, int divID, String status) {
        this.licenseNo = licenseNo;
        this.driverNID = driverNID;
        this.issueDate = issueDate;
        this.validityDate = validityDate;
        this.type = type;
        this.divID = divID;
        this.status = status;
    }

    public long getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(long licenseNo) {
        this.licenseNo = licenseNo;
    }

    public long getDriverNID() {
        return driverNID;
    }

    public void setDriverNID(long driverNID) {
        this.driverNID = driverNID;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDivID() {
        return divID;
    }

    public void setDivID(int divID) {
        this.divID = divID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return getLicenseNo() == license.getLicenseNo() &&
                getDriverNID() == license.getDriverNID() &&
                getDivID() == license.getDivID() &&
                Objects.equals(getIssueDate(), license.getIssueDate()) &&
                Objects.equals(getValidityDate(), license.getValidityDate()) &&
                Objects.equals(getType(), license.getType()) &&
                Objects.equals(getStatus(), license.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLicenseNo(), getDriverNID(), getIssueDate(), getValidityDate(), getType(), getDivID(), getStatus());
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseNo=" + licenseNo +
                ", driverNID=" + driverNID +
                ", issueDate='" + issueDate + '\'' +
                ", validityDate='" + validityDate + '\'' +
                ", type='" + type + '\'' +
                ", divID=" + divID +
                ", status='" + status + '\'' +
                '}';
    }
}
