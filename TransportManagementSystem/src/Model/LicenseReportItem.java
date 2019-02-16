package Model;

import java.util.Objects;

public class LicenseReportItem {
    long licenseNo;
    int penaltyNo;

    public LicenseReportItem(long licenseNo, int penaltyNo) {
        this.licenseNo = licenseNo;
        this.penaltyNo = penaltyNo;
    }

    public long getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(long licenseNo) {
        this.licenseNo = licenseNo;
    }

    public int getPenaltyNo() {
        return penaltyNo;
    }

    public void setPenaltyNo(int penaltyNo) {
        this.penaltyNo = penaltyNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseReportItem that = (LicenseReportItem) o;
        return getLicenseNo() == that.getLicenseNo() &&
                getPenaltyNo() == that.getPenaltyNo();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLicenseNo(), getPenaltyNo());
    }

    @Override
    public String toString() {
        return "LicenseReportItem{" +
                "licenseNo=" + licenseNo +
                ", penaltyNo=" + penaltyNo +
                '}';
    }
}

