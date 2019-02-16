package Model;

import java.util.Objects;

public class Application {
    int applicationNumber;
    long driverNID;
    String examDate;
    String result;
    int divID;
    String licenseType;

    public Application(int applicationNumber, long driverNID, String examDate, String result, int divID, String licenseType) {
        this.applicationNumber = applicationNumber;
        this.driverNID = driverNID;
        this.examDate = examDate;
        this.result = result;
        this.divID = divID;
        this.licenseType = licenseType;
    }

    public int getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(int applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public long getDriverNID() {
        return driverNID;
    }

    public void setDriverNID(long driverNID) {
        this.driverNID = driverNID;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getDivID() {
        return divID;
    }

    public void setDivID(int divID) {
        this.divID = divID;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return getApplicationNumber() == that.getApplicationNumber() &&
                getDriverNID() == that.getDriverNID() &&
                getDivID() == that.getDivID() &&
                Objects.equals(getExamDate(), that.getExamDate()) &&
                Objects.equals(getResult(), that.getResult()) &&
                Objects.equals(getLicenseType(), that.getLicenseType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getApplicationNumber(), getDriverNID(), getExamDate(), getResult(), getDivID(), getLicenseType());
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationNumber=" + applicationNumber +
                ", driverNID=" + driverNID +
                ", examDate='" + examDate + '\'' +
                ", result='" + result + '\'' +
                ", divID=" + divID +
                ", licenseType='" + licenseType + '\'' +
                '}';
    }
}
