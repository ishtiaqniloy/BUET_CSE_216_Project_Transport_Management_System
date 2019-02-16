package Model;

import java.util.Objects;

public class Vehicle {
    int regNo;
    String ownerNID;
    String regDate;
    String vehicleModel;
    String type;
    String taxValidityDate;
    String fitnessValidityDate;
    int engineCC;
    int seats;
    int weight;
    int tireSize;
    String transmission;
    int divID;

    public Vehicle(int regNo, String ownerNID, String regDate, String vehicleModel, String type, String taxValidityDate, String fitnessValidityDate, int engineCC, int seats, int weight, int tireSize, String transmission, int divID) {
        this.regNo = regNo;
        this.ownerNID = ownerNID;
        this.regDate = regDate;
        this.vehicleModel = vehicleModel;
        this.type = type;
        this.taxValidityDate = taxValidityDate;
        this.fitnessValidityDate = fitnessValidityDate;
        this.engineCC = engineCC;
        this.seats = seats;
        this.weight = weight;
        this.tireSize = tireSize;
        this.transmission = transmission;
        this.divID = divID;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxValidityDate() {
        return taxValidityDate;
    }

    public void setTaxValidityDate(String taxValidityDate) {
        this.taxValidityDate = taxValidityDate;
    }

    public String getFitnessValidityDate() {
        return fitnessValidityDate;
    }

    public void setFitnessValidityDate(String fitnessValidityDate) {
        this.fitnessValidityDate = fitnessValidityDate;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDivID() {
        return divID;
    }

    public void setDivID(int divID) {
        this.divID = divID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getRegNo() == vehicle.getRegNo() &&
                getEngineCC() == vehicle.getEngineCC() &&
                getSeats() == vehicle.getSeats() &&
                getWeight() == vehicle.getWeight() &&
                getTireSize() == vehicle.getTireSize() &&
                getDivID() == vehicle.getDivID() &&
                Objects.equals(getOwnerNID(), vehicle.getOwnerNID()) &&
                Objects.equals(getRegDate(), vehicle.getRegDate()) &&
                Objects.equals(getVehicleModel(), vehicle.getVehicleModel()) &&
                Objects.equals(getType(), vehicle.getType()) &&
                Objects.equals(getTaxValidityDate(), vehicle.getTaxValidityDate()) &&
                Objects.equals(getFitnessValidityDate(), vehicle.getFitnessValidityDate()) &&
                Objects.equals(getTransmission(), vehicle.getTransmission());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRegNo(), getOwnerNID(), getRegDate(), getVehicleModel(), getType(), getTaxValidityDate(), getFitnessValidityDate(), getEngineCC(), getSeats(), getWeight(), getTireSize(), getTransmission(), getDivID());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "regNo=" + regNo +
                ", ownerNID='" + ownerNID + '\'' +
                ", regDate='" + regDate + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", type='" + type + '\'' +
                ", taxValidityDate='" + taxValidityDate + '\'' +
                ", fitnessValidityDate='" + fitnessValidityDate + '\'' +
                ", engineCC=" + engineCC +
                ", seats=" + seats +
                ", weight=" + weight +
                ", tireSize=" + tireSize +
                ", transmission='" + transmission + '\'' +
                ", divID=" + divID +
                '}';
    }
}
