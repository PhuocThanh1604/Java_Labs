/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


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
        this.titleMenu = titleMenu; //hảm khỏi tạo đặt tên cho appMenu
    }
    
    public void addOption (String newOption) {
        optionList.add(newOption); // hàm check nếu không trùm, thì sẽ được add vào danh sách lựa chọn
        
    }
    
    public void printMenu () {
        //hàm in ra danh sách lựa chọn cho ngươi dùng 
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
        int maxOption = optionList.size(); //tối đa của sự lựa chọn 
        String inputMsg = "Choose [1..." + maxOption + "]: " ; 
         String errorMsg = "You need have a option for Menu " + maxOption; 
         return MyToys.getAnInteger(inputMsg, errorMsg,1,maxOption);

    }
}
