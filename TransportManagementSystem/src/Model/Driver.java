package Model;

import java.util.Objects;

public class Driver {
    long driverNID;
    long licenseNo;
    String name;
    String fathersName;
    String address;
    String birthDate;
    String bloodGroup;
    String mobileNo;

    public Driver(long driverNID, long licenseNo, String name, String fathersName, String address, String birthDate, String bloodGroup, String mobileNo) {
        this.driverNID = driverNID;
        this.licenseNo = licenseNo;
        this.name = name;
        this.fathersName = fathersName;
        this.address = address;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.mobileNo = mobileNo;
    }

    public long getDriverNID() {
        return driverNID;
    }

    public void setDriverNID(long driverNID) {
        this.driverNID = driverNID;
    }

    public long getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(long licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getDriverNID() == driver.getDriverNID() &&
                getLicenseNo() == driver.getLicenseNo() &&
                Objects.equals(getName(), driver.getName()) &&
                Objects.equals(getFathersName(), driver.getFathersName()) &&
                Objects.equals(getAddress(), driver.getAddress()) &&
                Objects.equals(getBirthDate(), driver.getBirthDate()) &&
                Objects.equals(getBloodGroup(), driver.getBloodGroup()) &&
                Objects.equals(getMobileNo(), driver.getMobileNo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDriverNID(), getLicenseNo(), getName(), getFathersName(), getAddress(), getBirthDate(), getBloodGroup(), getMobileNo());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverNID=" + driverNID +
                ", licenseNo=" + licenseNo +
                ", name='" + name + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
