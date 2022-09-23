/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastudent;

/**
 *
 * @author Mr.Thanh
 */
public class Student {
    private String idStudent;       //id học sinh
    private String name;            //Tên học sinh được tiêm
    private String idInjection;     //id mũi tiêm
    private String idVaccine;       // mã số vaccine
    private String place;           //nơi tiêm vắc xin
    private int number;             //số lần tiêm 
    private String date;            //Ngày tiêm 

    public Student(String idStudent, String name, String idInjection, String idVaccine, String place, int number, String date) {
        this.idStudent = idStudent;
        this.name = name;
        this.idInjection = idInjection;
        this.idVaccine = idVaccine;
        this.place = place;
        this.number = number;
        this.date = date;
    }

   

    

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdInjection() {
        return idInjection;
    }

    public void setIdInjection(String idInjection) {
        this.idInjection = idInjection;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIdVaccine() {
        return idVaccine;
    }

    public void setIdVaccine(String idVaccine) {
        this.idVaccine = idVaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", name=" + name + ", idInjection=" + idInjection + ", idVaccine=" + idVaccine + ", place=" + place + ", number=" + number + ", date=" + date + '}';
    }

   
   
    public void showProfile() {
        System.out.printf("|%6s|%-10s|%-6s|%-6s|%-8s|%-4s|%4d|%-10s|",idStudent,name,idInjection,idVaccine,place, number,date);
    }
}
