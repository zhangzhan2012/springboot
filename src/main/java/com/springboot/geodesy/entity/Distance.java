package com.springboot.geodesy.entity;

public class Distance {
    private String orgName;
    private String companyName;
    private String compAddr;
    private String distance;
    private String dataDt;

    public String getDataDt() {
        return dataDt;
    }

    public void setDataDt(String dataDt) {
        this.dataDt = dataDt;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompAddr() {
        return compAddr;
    }

    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
