/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import data.Vaccine;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;
import mytoys.MyToys;
/**
 *
 * @author Mr.Thanh
 */
public class VaccineList {

   private List <Vaccine> vaccineList;
   private Scanner sc = new Scanner(System.in);
    
    public VaccineList() {
        vaccineList = new ArrayList<>();
    }
    
    public void addVaccine(Vaccine vaccine) {
        vaccineList.add(vaccine);
    }
    public void addVaccine(){
        String id;
        String name;
        id = MyToys.getString("Vaccine Id: ","Please enter again");
        name = MyToys.getString("Vaccine Name: ","Please enter again");
        vaccineList.add(new Vaccine(id, name));
    }
    
    public void printVaccineList() {
        System.out.println("List of vaccine available:");
        System.out.printf("|%-6s|%-10s|\n","Id","Name");
        for (int i = 0; i < vaccineList.size(); i++)
            vaccineList.get(i).showVaccine();
    }
     public Vaccine searchVaccineByName(String name) {
        if (name.isEmpty())
            return null;
        for (int i = 0; i < vaccineList.size(); i++)
            if (vaccineList.get(i).getName().equalsIgnoreCase(name))
                return vaccineList.get(i);
        return null;
    }
    public void searchVaccineByName() {
        if (vaccineList.isEmpty()) {
            System.out.println("not found");
        }
        char n;
        do {
            String name;
           name = MyToys.getString("Enter enter name vaccine ", "please enter vaccine");
            Vaccine xxx = searchVaccineByName(name);
            if (xxx == null) {
                System.out.println("Vaccine don't have information to print");
            } else {
                System.out.println("----------------------------");
                System.out.println("The list search information of Vaccine ");
                System.out.printf("|%-7s|%-10s|\n",
                       "StudentID", "Name");
                for (Vaccine xx : vaccineList) {
                    if (xx.getName().equalsIgnoreCase(name)) {

                        xx.showVaccine();
                    }
                }
            }
            System.out.println("Do you want search again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }
      public Vaccine searchVaccineId(String vaccineId) {
        if (vaccineList.isEmpty())
            return null;
        for (int i = 0; i < vaccineList.size(); i++)
            if (vaccineList.get(i).getVaccineID().equalsIgnoreCase(vaccineId))
                return vaccineList.get(i);
        return null;
    }   
     public void removeVaccineByName() {
        String vaccineID;
        char n;
        do {
         vaccineID = MyToys.getId("Enter vaccine id (VXX): ", "The format of Id is VXX", "[V,v]\\d{2}$");
            Vaccine tmp = searchVaccineId(vaccineID);
            System.out.println("----------------------------");
            if (tmp == null) {
                System.out.println("Not found vaccine in the list!!");
            } else {
                vaccineList.remove(tmp);
                for (Vaccine x : vaccineList) {
                    x.showVaccine();
                }
            }
            System.out.println("Do you want remove agian? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');

    }
   public void readFromFile() {  
        try {
             FileInputStream fis = new FileInputStream("Vaccine.dat");
                   ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                vaccineList = (List<Vaccine>) ois.readObject();
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writerFromFile() {
        try {
            FileOutputStream fw = new FileOutputStream("vaccine.dat");
            ObjectOutputStream bw = new ObjectOutputStream(fw);
            bw.writeObject(vaccineList);
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
