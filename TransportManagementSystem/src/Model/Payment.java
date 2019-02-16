package Model;

import java.util.Objects;

public class Payment {
    int paymentNo;
    float amount;
    String paymentDate;
    int historyNo;
    String description;
    String type;



    public Payment(int paymentNo, float amount, String paymentDate, int historyNo, String description, String type) {
        this.paymentNo = paymentNo;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.historyNo = historyNo;
        this.description = description;
        this.type = type;

//        if(historyNo < 2000)    this.type = "License Service";
//        else if(historyNo < 3000)    this.type = "Vehicle Service";
//        else this.type = "Penalty";
    }

    public int getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getHistoryNo() {
        return historyNo;
    }

    public void setHistoryNo(int historyNo) {
        this.historyNo = historyNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return getPaymentNo() == payment.getPaymentNo() &&
                Float.compare(payment.getAmount(), getAmount()) == 0 &&
                getHistoryNo() == payment.getHistoryNo() &&
                Objects.equals(getPaymentDate(), payment.getPaymentDate()) &&
                Objects.equals(getDescription(), payment.getDescription()) &&
                Objects.equals(getType(), payment.getType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPaymentNo(), getAmount(), getPaymentDate(), getHistoryNo(), getDescription(), getType());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNo=" + paymentNo +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                ", historyNo=" + historyNo +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
