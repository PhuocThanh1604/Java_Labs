/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author Mr.Thanh
 */
public class Vaccine implements Serializable{
    private String vaccineID;
    private String nameVaccine;
    
    public Vaccine(){
    
    }
    public Vaccine(String vaccineID, String name) {
        this.vaccineID = vaccineID;
        this.nameVaccine = name;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }


    public String getName() {
        return nameVaccine;
    }

    public void setName(String name) {
        this.nameVaccine = name;
    }

    @Override
    public String toString() {
        return vaccineID + "," + nameVaccine;
    }

    public void showVaccine() {
        String msg;
        msg = String.format("|%-6s|%-10s|",vaccineID,nameVaccine);
        System.out.println(msg);
    }
}
