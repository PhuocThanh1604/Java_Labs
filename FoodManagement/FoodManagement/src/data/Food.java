/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mr.Thanh
 */
public class Food implements Serializable {
    private String id;
    private String name;
    private double  weight;
    private String type;
    private String place;
    private String expiredDate;


    public Food (String id, String name, double weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", type=" + type + ", place=" + place + ", expiredDate=" + expiredDate + '}';
    }
    
    
    public void showProfile () {
        String msg;
        msg = String.format("|%6s|%-10s|%6.1f|%-8s|%-10s|%-11s|",id,name,weight,type,place,expiredDate);
        System.out.println(msg);
    }
    
}
