
package foodmanagement;

import data.CabinetFood;
import data.Food;
import java.io.IOException;
import Menu.Menu;

/**
 *
 * @author Mr.Thanh
 */
public class FoodManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu("---- Wellcome to app Management Food ----");
        menu.addOption("1. Add a new food");
        menu.addOption("2. Search a food by name");
        menu.addOption("3. Remove the food by ID");
        menu.addOption("4. Print the food list in the descending order of expired date");
        menu.addOption("5. Quit");
        CabinetFood cabinetFood = new CabinetFood();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You want a add new Food");
                    cabinetFood.addFood();
                    break;
                case 2:
                    System.out.println("You want search Food by Name ");
                    cabinetFood.searchByName();
                    break;
                case 3:
                    System.out.println("You want remove Food by Id");
                    cabinetFood.removeFoodById();
                    break;
                case 4:
                    System.out.println("The list Food here!");
                    cabinetFood.printTheFoodDescendingOfDate();
                    break;
                case 5:
                    System.out.println("Bye see you again!!!");
                    break;
            }

        } while (choice != 5);

    }
}
