/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import java.util.ArrayList;
import mytoys.MyToys;

/**
 *
 * @author Mr.Thanh
 */
public class Menu {
    private String titleMenu;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String titleMenu) {
        this.titleMenu = titleMenu; 
    }
    
    public void addOption (String newOption) {
        optionList.add(newOption); 
        
    }
    
    public void printMenu () {
       
        if (optionList.isEmpty()) {
            System.out.println("nothing to print in Menu");
            return;
        }
        System.out.println(titleMenu);
        for (String x : optionList) {
            System.out.println(x);
        }
    }
    public int getChoice () {
        int maxOption = optionList.size(); 
        String inputMsg = "Choose [1..." + maxOption + "]: " ; 
         String errorMsg = "You need have a option for Menu " + maxOption; 
         return MyToys.getAnInteger(inputMsg, errorMsg,1,maxOption);

    }
}
