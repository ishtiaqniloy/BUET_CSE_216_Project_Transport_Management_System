package Model;

import java.util.Objects;

public class Owner {
    String ownerNID;
    String name;
    String address;
    String eTIN;
    String mobileNo;
    int numberOfVehicles;

    public Owner(String ownerNID, String name, String address, String eTIN, String mobileNo, int numberOfVehicles) {
        this.ownerNID = ownerNID;
        this.name = name;
        this.address = address;
        this.eTIN = eTIN;
        this.mobileNo = mobileNo;
        this.numberOfVehicles = numberOfVehicles;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
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

    public String getETIN() {
        return eTIN;
    }

    public void setETIN(String eTIN) {
        this.eTIN = eTIN;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return getNumberOfVehicles() == owner.getNumberOfVehicles() &&
                Objects.equals(getOwnerNID(), owner.getOwnerNID()) &&
                Objects.equals(getName(), owner.getName()) &&
                Objects.equals(getAddress(), owner.getAddress()) &&
                Objects.equals(getETIN(), owner.getETIN()) &&
                Objects.equals(getMobileNo(), owner.getMobileNo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOwnerNID(), getName(), getAddress(), getETIN(), getMobileNo(), getNumberOfVehicles());
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerNID='" + ownerNID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", eTIN='" + eTIN + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", numberOfVehicles=" + numberOfVehicles +
                '}';
    }
}
