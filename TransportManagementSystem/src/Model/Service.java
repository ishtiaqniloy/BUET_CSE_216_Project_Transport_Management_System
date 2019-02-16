package Model;

public class Service {
    Integer SID;
    String name;
    Float fee;
    String type;

    public Service(Integer SID, String name, Float fee, String type) {
        this.SID = SID;
        this.name = name;
        this.fee = fee;
        this.type = type;
    }

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
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

        Service service = (Service) o;

        if (!getSID().equals(service.getSID())) return false;
        if (!getName().equals(service.getName())) return false;
        if (!getFee().equals(service.getFee())) return false;
        return getType().equals(service.getType());
    }

    @Override
    public int hashCode() {
        int result = getSID().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getFee().hashCode();
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "SID=" + SID +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", type='" + type + '\'' +
                '}';
    }


}
