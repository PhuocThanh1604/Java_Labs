/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagement;

import Menu.Menu;

/**
 *
 * @author Mr.Thanh
 */
public class VaccineManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("---- Wellcome to app Management Vaccine ----");
        menu.addOption("1. Show information all student have been injected");
        menu.addOption("2. Add student's vaccine injection information");
        menu.addOption("3. Updating information of student's vaccine injection");
        menu.addOption("4. Delete student vaccine injection information");
        menu.addOption("5. Search for injection information by studentID");
        menu.addOption("6. Exit");
        
        int choice;
        do {   
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice) {
                case 1:
                    System.out.println("");
                    break;
                     case 2:
                    System.out.println("");
                    break;
                     case 3:
                    System.out.println("");
                    break;
                     case 4:
                    System.out.println("");
                    break;
                     case 5:
                    System.out.println("");
                    break;
                     case 6:
                    System.out.println("Bye see you again");
                    break;
            }
                    
        } while (true);
    }
    
}
