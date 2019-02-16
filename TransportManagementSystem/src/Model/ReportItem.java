package Model;

import java.util.Date;
import java.util.Objects;

public class ReportItem {
    String num;
    String NID;
    String date;
    String description;
    Integer div_ID;

    public ReportItem(String num, String NID, String date, String description, Integer div_ID) {
        this.num = num;
        this.NID = NID;
        this.date = date;
        this.description = description;
        this.div_ID = div_ID;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiv_ID() {
        return div_ID;
    }

    public void setDiv_ID(Integer div_ID) {
        this.div_ID = div_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportItem that = (ReportItem) o;
        return Objects.equals(getNum(), that.getNum()) &&
                Objects.equals(getNID(), that.getNID()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getDiv_ID(), that.getDiv_ID());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNum(), getNID(), getDate(), getDescription(), getDiv_ID());
    }

    @Override
    public String toString() {
        return "ReportItem{" +
                "num='" + num + '\'' +
                ", NID='" + NID + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", div_ID=" + div_ID +
                '}';
    }
}
