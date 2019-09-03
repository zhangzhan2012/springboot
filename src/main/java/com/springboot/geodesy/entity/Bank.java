package com.springboot.geodesy.entity;

public class Bank {

    private String orgName;

    private String branLati;

    private String branLong;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBranLati() {
        return branLati;
    }

    public void setBranLati(String branLati) {
        this.branLati = branLati;
    }

    public String getBranLong() {
        return branLong;
    }

    public void setBranLong(String branLong) {
        this.branLong = branLong;
    }
}
