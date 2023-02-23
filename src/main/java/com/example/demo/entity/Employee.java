package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name="id")
    private int Eid;
    @Column(name = "name")
    private String Ename;
    @Column(name = "age")
    private int Age;
    @Column(name="position")
    private String position;
    @Column(name="address")
    private String Address;
    @Column(name="phone")
    private long Phone;
    @Column(name="assest")
    private String Asset_Id;

    public String getAsset_Id() {
        return Asset_Id;
    }

    public void setAsset_Id(String asset_Id) {
        Asset_Id = asset_Id;
    }

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }
}
