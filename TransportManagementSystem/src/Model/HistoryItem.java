package Model;

import java.util.Objects;

public class HistoryItem {
    int entryNo;
    int ID;
    String name;
    float amount;
    int vehicleRegNo;
    long licenseNo;
    String date;
    String status;
    int paymentNo;

    public HistoryItem(int entryNo, int ID, String name, float amount, int vehicleRegNo, long licenseNo, String date, String status, int paymentNo) {
        this.entryNo = entryNo;
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.vehicleRegNo = vehicleRegNo;
        this.licenseNo = licenseNo;
        this.date = date;
        this.status = status;
        this.paymentNo = paymentNo;
    }

    public int getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(int entryNo) {
        this.entryNo = entryNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(int vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public long getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(long licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryItem that = (HistoryItem) o;
        return getEntryNo() == that.getEntryNo() &&
                getID() == that.getID() &&
                Float.compare(that.getAmount(), getAmount()) == 0 &&
                getVehicleRegNo() == that.getVehicleRegNo() &&
                getLicenseNo() == that.getLicenseNo() &&
                getPaymentNo() == that.getPaymentNo() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEntryNo(), getID(), getName(), getAmount(), getVehicleRegNo(), getLicenseNo(), getDate(), getStatus(), getPaymentNo());
    }

    @Override
    public String toString() {
        return "HistoryItem{" +
                "entryNo=" + entryNo +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", vehicleRegNo=" + vehicleRegNo +
                ", licenseNo=" + licenseNo +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", paymentNo=" + paymentNo +
                '}';
    }
}
