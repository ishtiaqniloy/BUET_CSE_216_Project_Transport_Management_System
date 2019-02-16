package Model;

import java.util.Objects;

public class Penalty {
    Integer PID;
    String section;
    String Name;
    Float fine;

    public Penalty(Integer PID, String section, String name, Float fine) {
        this.PID = PID;
        this.section = section;
        Name = name;
        this.fine = fine;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penalty penalty = (Penalty) o;
        return Objects.equals(getPID(), penalty.getPID()) &&
                Objects.equals(getSection(), penalty.getSection()) &&
                Objects.equals(getName(), penalty.getName()) &&
                Objects.equals(getFine(), penalty.getFine());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPID(), getSection(), getName(), getFine());
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "PID=" + PID +
                ", section='" + section + '\'' +
                ", Name='" + Name + '\'' +
                ", fine=" + fine +
                '}';
    }

}
