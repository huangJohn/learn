package com.example.entity;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class Record {
    private String company;
    private String position;
    private String address;

    public Record() {
    }

    @Override
    public String toString() {
        return "Record{" +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Record(String company, String position, String address) {
        this.company = company;
        this.position = position;
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
