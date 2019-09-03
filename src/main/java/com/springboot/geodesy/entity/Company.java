package com.springboot.geodesy.entity;

public class Company {
    private String companyName;

    private String compLati;

    private String compLong;

    private String compAddr;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompLati() {
        return compLati;
    }

    public void setCompLati(String compLati) {
        this.compLati = compLati;
    }

    public String getCompLong() {
        return compLong;
    }

    public void setCompLong(String compLong) {
        this.compLong = compLong;
    }

    public String getCompAddr() {
        return compAddr;
    }

    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }
}
