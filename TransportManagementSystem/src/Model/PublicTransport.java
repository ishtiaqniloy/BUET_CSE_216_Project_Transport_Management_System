package Model;

import java.util.Objects;

public class PublicTransport {
    int regNo;
    String name;
    String route;
    float fare;

    public PublicTransport(int regNo, String name, String route, float fare) {
        this.regNo = regNo;
        this.name = name;
        this.route = route;
        this.fare = fare;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicTransport that = (PublicTransport) o;
        return getRegNo() == that.getRegNo() &&
                Float.compare(that.getFare(), getFare()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getRoute(), that.getRoute());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRegNo(), getName(), getRoute(), getFare());
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                ", fare=" + fare +
                '}';
    }
}
