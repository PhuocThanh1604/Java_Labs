package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import mytoys.MyToys;

/**
 *
 * @author Mr.Thanh
 */
public class InjectionList {

    private List<Injection> injection = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    private VaccineList vaccine = new VaccineList();
    private StudentList student = new StudentList();

    public InjectionList() throws ClassNotFoundException {
        vaccine.readFromFile();
        student.readFromFile();
    }

    public int getSize() {
        return injection.size();
    }

    public void showInformationOfAllStudentInInjection() {
        if (injection.isEmpty()) {
            System.out.println("nothing to show\n");
        } else {
            System.out.println("----------------------------");
            System.out.println("The list student Injection after updating");
            System.out.printf("|%-7s|%-10s|%-9s|%-9s|%-8s|%-4s|%-10s|\n",
                    "InjectionID", "1St InjectionPlace", "1St Date", "2St InjectionPlace", "2St Date", "StudentID", "VaccineID");
            for (Injection i : injection) {
                i.showInjection();
            }
        }
    }

    public int searchInjectionByID(String injecttionID) {
        if (injection.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getInjectionID().equalsIgnoreCase(injecttionID)) {
                return i;
            }
        }
        return -1;
    }

    public void addAllInjection(String studentID) {
        String injectionID, place1St, place2Nd;
        Date date1St = null;
        Date date2St = null;

        int pos;
        do {
            injectionID = MyToys.getId("Enter  injection ID(IXX): ", "The format of id is IXX", "[I,i]\\d{2}$");
            pos = searchInjectionByID(injectionID);
            if (pos >= 0) {
                System.out.println("The injection id already exits!!");
            }
        } while (pos != -1);

        place1St = MyToys.getString("Input 1St place injecttion vaccine: ", "Please enter again!!");
        date1St = MyToys.inputDate("Enter 1St vaccination date(dd-mm-yyyy):", "Please enter again!!");
        place2Nd = MyToys.getStringNull("Input 2St place injecttion vaccine: ", "Please enter again!!");
        while (true) {

            date2St = MyToys.inputDate("Enter 2St vaccination date(dd-mm-yyyy):", "Please enter again!!");
            if (MyToys.getDifferenceDays(date1St, date2St) > 28) {
                break;
            } else {
                System.out.println("Invalid!!Distance 1st Date and 2st Date is 28days");
            }
        }

        vaccine.printVaccineList();
        String vaccineID;
        while (true) {
            vaccineID = MyToys.getId("Enter  Vaccine ID(VXX): ", "The format of id is VXX", "^[v,V]{1}[0-4]{2}$").toUpperCase().trim();

            if (vaccine.searchVaccineId(vaccineID) != null) {
                break;
            } else {
                System.out.println(" There is no Vaccine with the ID!! Try again");
            }
        }

        injection.add(new Injection(injectionID, place1St, place2Nd, date1St, date2St, studentID, vaccineID));
        System.out.println("\nAdd new information sucessfully injection! This student completed 2 injection!\n");

    }

    public void addFistInjection(String studentID) {
        String injectionID, place1St, place2nd = "";
        Date date1St;
        Date date2nd;
        int pos;
        do {
            injectionID = MyToys.getId("Enter  injection ID(IXX): ", "The format of id is IXX", "[I,i]\\d{2}$");
            pos = searchInjectionByID(injectionID);
            if (pos >= 0) {
                System.out.println("The injection id already exits!!");
            }
        } while (pos != -1);
        place1St = MyToys.getString("Input 1St place injecttion vaccine: ", "Please enter again!!");
        date1St = MyToys.inputDate("Enter 1St vaccination date(dd-mm-yyyy):", "Please enter again!!");
        vaccine.printVaccineList();
        String vaccineID;
        while (true) {
            vaccineID = MyToys.getId("Enter  VaccineID(VXX): ", "The format of id is VXX", "^[v,V]{1}[0-4]{2}$").toUpperCase().trim();

            if (vaccine.searchVaccineId(vaccineID) != null) {
                break;
            } else {
                System.out.println(" There is no Vaccine with the id!! Try again");
            }
        }
        injection.add(new Injection(injectionID, place1St, null, date1St, null, studentID, vaccineID));
        System.out.println("Succesffly add first injection");

    }

    public void addSecondInjection(String studentID, Date date1St) {
        String place2St = MyToys.getString("Input 2St place injecttion vaccine: ", "Please enter again!!");
        Date date2St;
        while (true) {
            date2St = MyToys.inputDate("Enter 2St vaccination date(dd-mm-yyyy):", "Please enter again!!");
            if (MyToys.getDifferenceDays(date1St, date2St) > 28) {
                break;
            } else {
                System.out.println("Invalid!!Distance 1st Date and 2st Date is 28days");
            }
        }

        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getStudentID().equalsIgnoreCase(studentID)) {
                injection.get(i).setPlace2Nd(place2St);
                injection.get(i).setDate2Nd(date2St);
            }
        }
        System.out.println("\n Succesffly add second injection");
    }

    public void addNewInjection() {

        do {
            String studentID;
            
        student.printStudentList();
            while (true) {
                studentID = MyToys.getId("Enter  Student ID(SXX): ", "The format of id is SXX", "[S,s]\\d{2}$");
                Student xxx = student.searchStudentId(studentID);
                if (xxx != null) {
                    break;
                } else {
                    System.out.println("Student does not exist! Try again!");
                }
            }
            Injection tmp = null;
            for (int i = 0; i < injection.size(); i++) {
                if (injection.get(i).getStudentID().equalsIgnoreCase(studentID)) {
                    tmp = injection.get(i);
                }
            }
            if (tmp != null) {
                if (tmp.getPlace1St() != null && tmp.getPlace2Nd() != null) {
                    System.out.println("This student has completed 2 injections. No more input required.!");
                } else {
                    if (MyToys.getYesNo("This student has had the 1st injection.Do you want to enter the 2nd injection information? [Yes-Y/No-N]: ")) {
                        addSecondInjection(studentID, tmp.getDate1St());
                        writerFromFile();
                    } else {
                        System.out.println("You choose not! That student's injection information remains the same!");
                    }
                }
            } else {
                System.out.println("\nThis student has no injection information yet! What do you want to do?");
                System.out.println("1. Add 1st injection information.");
                System.out.println("2. Add both 1st and 2nd injection information.");
                System.out.println("3. Cancel - Do not add injection information for this student.");
                int choice = MyToys.getAnInteger("Enter your choice: ", "\nWrong format or Out of range choice! Try again!\n", 1, 3);
                switch (choice) {
                    case 1:
                        addFistInjection(studentID);
                        writerFromFile();
                        break;
                    case 2:
                        addAllInjection(studentID);
                        writerFromFile();
                        break;
                    case 3:
                        System.out.println("\nCancel! Do not add this student's injection information!\n");
                        break;
                }
            }
        } while (MyToys.getYesNo("Do you want to add another new injection? [Yes-Y|No-N]: "));
        System.out.println();

    }

    public Injection searchInjectionObjectByStudentId(String studentID) {
        if (injection.isEmpty()) {
            return null;
        }
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getStudentID().equalsIgnoreCase(studentID)) {
                return injection.get(i);
            }
        }
        return null;
    }

    public void searchInformationStudentByID() {
        if (injection.isEmpty()) {
            System.out.println("not found");
        }
        char n;
        do {
            String studentID;
            studentID = MyToys.getId("Enter  student ID(SXX): ", "The format of id is SXX", "[S]\\d{2}$");
            Injection xxx = searchInjectionObjectByStudentId(studentID);
            if (xxx == null) {
                System.out.println("Student don't have information to print");
            } else {
                System.out.println("----------------------------");
                System.out.println("The list search information of Student ");
                System.out.printf("|%-7s|%-10s|%-9s|%-9s|%-8s|%-4s|%-10s|\n",
                        "InjectionID", "1St InjectionPlace", "1St Date", "2St InjectionPlace", "2St Date", "StudentID", "VaccineID");
                for (Injection xx : injection) {
                    if (xx.getStudentID().equalsIgnoreCase(studentID)) {

                        xx.showInjection();
                    }
                }
            }
            System.out.println("Do you want search again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }

    public Injection searchInjectionObjectByID(String injectionID) {
        if (injection.isEmpty()) {
            return null;
        }
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getInjectionID().equalsIgnoreCase(injectionID)) {
                return injection.get(i);
            }
        }

        return null;
    }

    public void updateInformationStudent() {
        String tmpstudentID, tmpPlace2;
        int number;
        char n;
        do {
            String injectionID = MyToys.getId("Enter injection Id(IXX):", "The format of Id is IXX", "[I]\\d{2}$");
            Injection tmp = searchInjectionObjectByID(injectionID);
            System.out.println("------------------------------------------");
            if (tmp == null) {
                System.out.println("Injection do not exits in the list");
            } else {
                System.out.println("The list Injecttion before updating");
                String header = String.format("|%-7s|%-10s|%-9s|%-9s|%-8s|%-4s|%-10s|\n",
                        "InjectionID", "1St InjectionPlace", "1St Date", "2St InjectionPlace", "2St Date", "StudentID", "VaccineID");
                System.out.println(header);
                tmp.showInjection();
                System.out.println("\nHere is the information of this Injection:");
                System.out.printf("| Student ID: %s, Student Name: %s\n", tmp.getStudentID(), student.searchStudentId(tmp.getStudentID()).getName());
                System.out.printf("| Vaccine ID: %s, Vaccine Name: %s\n", tmp.getVaccineID(), vaccine.searchVaccineId(tmp.getVaccineID()).getName());
                Date date2St;

                tmpPlace2 = MyToys.getStringNull("Enter where you 2St InjectionPlace: ", "Please enter again!!");
                while (true) {
                    date2St = MyToys.inputDate("Enter 2St vaccination date(dd-mm-yyyy):", "Please enter again!!");
                    if (MyToys.getDifferenceDays(tmp.getDate1St(), date2St) > 28) {
                        break;
                    } else {
                        System.out.println("Invalid!!Distance 1st Date and 2st Date is 28days");
                    }
                }
                if (MyToys.getYesNo("You need to verify the information was updated? [Yes-Y|No-N]: ")) {
                    tmp.setDate2Nd(date2St);
                    tmp.setPlace2Nd(tmpPlace2);
                    if (tmpPlace2 == null || tmpPlace2 == null) {
                        System.out.println("You have not competed 2 injections");

                    } else {
                        System.out.println("You have compeleted 2 injection");
                    }
                    System.out.println("----------------------------");
                    System.out.println("The list Injecttion after updating");
                    System.out.println(header);
                    tmp.showInjection();
                    System.out.println("The list information updated successfully");

                } else {
                    System.out.println("\n not accpected! not update");
                }
            }
            System.out.println("Do you want update agian another? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');

    }

    public void removeInformationStudentInjection() {
        String injectionID;
        char n;
        do {
            int tmp;
            char c;
            injectionID = MyToys.getId("Enter injection Id(IXX): ", "The format of Id is IXX", "[I]\\d{2}$");
            tmp = searchInjectionByID(injectionID);
            System.out.println("----------------------------");
            if (tmp == -1) {
                System.out.println("Not found student in the list!!");
            } else {
                System.out.println("List of all student before remove out list");
                String header = String.format("|%-7s|%-10s|%-9s|%-9s|%-8s|%-4s|%-10s|\n",
                        "InjectionID", "1St InjectionPlace", "1St Date", "2St InjectionPlace", "2St Date", "StudentID", "VaccineID");
                System.out.println(header);
                for (Injection x : injection) {
                    x.showInjection();
                }
                System.out.println("You need confirm delected information ");
                System.out.println("Do you want remove Injection again? (Y/N)");
                System.out.print("You should enter Y to continue: ");
                n = sc.nextLine().charAt(0);
                if (n == 'Y' || n == 'y') {
                    injection.remove(tmp);
                    System.out.println("You remove Successfully!!");
                    System.out.println("----------------------------");
                    System.out.println("List of all student after remove out list");
                    System.out.println(header);
                    for (Injection x : injection) {
                        x.showInjection();
                    }
                }
                if (n == 'N' || n == 'n') {
                    System.out.println("Remove not successfully");
                }
            }
            System.out.println("Do you want remove agian? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("injection.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                injection = (List<Injection>) ois.readObject();
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
            FileOutputStream fw = new FileOutputStream("injection.dat");
            ObjectOutputStream bw = new ObjectOutputStream(fw);
            bw.writeObject(injection);
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public Injection searchInjectionObjectByDate(Date date1St) {
        if (injection.isEmpty()) {
            return null;
        }
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getDate1St().equals(date1St)) {
                return injection.get(i);
            }
        }
        return null;
    }

    public void searchInformationStudentByDate() {
        if (injection.isEmpty()) {
            System.out.println("not found");
        }
        char n;
        do {
          
           // studentID = MyToys.getId("Enter  student ID(SXX): ", "The format of id is SXX", "[S]\\d{2}$");
           Date date1St = MyToys.inputDate("Enter date1St ", "Erros");
            Injection xxx = searchInjectionObjectByDate(date1St);
            if (xxx == null) {
                System.out.println("Student don't have information to print");
            } else {
                System.out.println("----------------------------");
                System.out.println("The list search information of Student ");
                System.out.printf("|%-7s|%-10s|%-9s|%-9s|%-8s|%-4s|%-10s|\n",
                        "InjectionID", "1St InjectionPlace", "1St Date", "2St InjectionPlace", "2St Date", "StudentID", "VaccineID");
                for (Injection xx : injection) {
                    if (xx.getDate1St().equals(date1St)) {

                        xx.showInjection();
                    }
                }
            }
            System.out.println("Do you want search again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }

   public void searchInjectionByStudentName(){
        String studentName;
        studentName = MyToys.getString("Student name you want to find: ","Please enter again");
        List<Student> xxx = student.searchInjectionByName(studentName);
        for (Student student : xxx) {
            for (Injection injection : injection) {
                if(injection.getStudentID().equalsIgnoreCase(student.getStudentID()))
                injection.showInjection();
            }
        }
        
    }

}
