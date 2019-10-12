package com.springboot.geodesy.entity;

public class Bank {

    private Integer id;
    private String orgName;
    private String orgAddr;

    private String branLati;

    private String branLong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgAddr() {
        return orgAddr;
    }

    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr;
    }

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
