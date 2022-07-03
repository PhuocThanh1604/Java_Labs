
package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mr.Thanh
 */
public class Injection  implements Serializable{

    private String injectionID;
    private String place1St;
    private String place2Nd;
    private Date date1St;
    private Date date2Nd;
    private String studentID;
    private String vaccineID;
    

    public Injection() {
    }

    public Injection(String injectionID, String place1St, String place2Nd, Date date1St, Date date2Nd, String studentID, String vaccineID) {
        this.injectionID = injectionID;
        this.place1St = place1St;
        this.place2Nd = place2Nd;
        this.date1St = date1St;
        this.date2Nd = date2Nd;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getPlace1St() {
        return place1St;
    }

    public void setPlace1St(String place1St) {
        this.place1St = place1St;
    }

    public String getPlace2Nd() {
        return place2Nd;
    }

    public void setPlace2Nd(String place2Nd) {
        this.place2Nd = place2Nd;
    }

    public Date getDate1St() {
        return date1St;
    }

    public void setDate1St(Date date1St) {
        this.date1St = date1St;
    }

    public Date getDate2Nd() {
        return date2Nd;
    }

    public void setDate2Nd(Date date2Nd) {
        this.date2Nd = date2Nd;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("|%-11s|%-18s|%-9s|%-18s|%-8s|%-9s|%-10s|",
                injectionID, place1St, sdf.format(date1St), place2Nd, sdf.format(date2Nd), studentID, vaccineID);
        

    }

    public void showInjection() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date2nd, date1st;
        if(date1St == null) {
             date1st = String.format("NULL", date1St);
        } else {
            date1st = sdf.format(date1St);
        }
        if(date2Nd == null) {
            date2nd = String.format("NULL", date2Nd);
        } else {
            date2nd= sdf.format(date2Nd);
        }
        System.out.printf("|%-11s|%-18s|%-9s|%-18s|%-8s|%-9s|%-10s|\n",
                injectionID, place1St, date1st, place2Nd, date2nd, studentID, vaccineID);

    }

}
