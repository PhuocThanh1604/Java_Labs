package vaccinemanagement;

import data.InjectionList;
import data.StudentList;
import data.VaccineList;
import java.io.IOException;
import menu.Menu;

/**
 *
 * @author Mr.Thanh
 */
public class VaccineManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException   {
        Menu menu = new Menu("---- Wellcome to app Management Vaccine ----");
        menu.addOption("1. Show information all student have been injected");
        menu.addOption("2. Add student's vaccine injection information");
        menu.addOption("3. Updating information of student's vaccine injection");
        menu.addOption("4. Delete student vaccine injection information");
        menu.addOption("5. Search for injection information by studentID");
         menu.addOption("6. Search for injection information by Name");
        menu.addOption("7. Exit");
        InjectionList injection = new InjectionList();
        StudentList student = new StudentList();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("Show information all student");
                    injection.readFromFile();
                    injection.showInformationOfAllStudentInInjection();
                    break;
                case 2:
                    System.out.println("Add new an Student");
                    injection.addNewInjection();
                    injection.writerFromFile();
                    break;
                case 3:
                    System.out.println("Update student injection information ");
                    injection.updateInformationStudent();
                    injection.writerFromFile();
                    break;
                case 4:
                    System.out.println("Delete a student is information");
                    injection.removeInformationStudentInjection();
                    injection.writerFromFile();
                    break;
                case 5:
                    System.out.println("Search for information student");
                    injection.searchInformationStudentByDate();
                   // injection.searchInformationStudentByID();           
                    break;
                case 6:
                    System.out.println("Search for information student By Name");
                    injection.searchInjectionByStudentName();
                    break;
                  case 7:
                    System.out.println("Bye see you again");
                    break;
            }

        } while (choice != 7);
    }

}
