package com.example.restaurantselection.Models;

import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {

    private int id;
    private String Name;
    private String website;
    private Date openingTime;
    private Date closingTime;
    private long contactNumber;
    private String category;
    private String address;

    public Restaurant(int id, String name, String website, Date openingTime, Date closingTime, long contactNumber, String category, String address) {
        this.id = id;
        Name = name;
        this.website = website;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.contactNumber = contactNumber;
        this.category = category;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
