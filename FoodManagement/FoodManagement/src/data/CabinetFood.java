package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import mytoys.MyToys;

/**
 *
 * @author Mr.Thanh
 */
public class CabinetFood {

    private ArrayList<Food> food = new ArrayList(); //lưu danh sách hồ sơ
    private Scanner sc = new Scanner(System.in);

    public void addFood() {
        String id, name, type, place;
        String expiredDate;
        double weight;
        int pos; //lưu vị trí tìm thấy id       
        char n;
        do {
            do {
                id = MyToys.getId("Input Food Id(DXXXX)", "The format of id is DXXXX", "[D|d]\\d{4}$");
                pos = searchByIdFood(id);
                if (pos >= 0) {
                    System.out.println("The Food id already exists.");
                }
            } while (pos != -1);
            name = MyToys.getString("Input name Food: ", "please enter again!!");
            type = MyToys.getString("Input type Food: ", "please enter again!!");
            place = MyToys.getString("Input place Food: ", "please enter again!!");
            expiredDate = MyToys.getStringDate("Input Date Food(dd/MM/yyyy) ", "please enter again!!");
            weight = MyToys.getADouble("Input weight Food (1->100): ", "Weight is from 1 to 100!", 1, 100);
            food.add(new Food(id, name, weight, type, place, expiredDate));
            System.out.println("Add a new food sucessfully");
            System.out.println("Do you want add new Food again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');

    }

    public void searchByIdFood() {
        //hàm tìm Id của food, yêu cầu nhập id để tìm 
        String id;
        Food x; //lưu vị trí tạm thời
        id = MyToys.getString("Input ID Food", "Please enter ID Food again!!");
        x = searchFoodObjectById(id);
        System.out.println("------------------------");
        if (x == null) {
            System.out.println("nothing!!");
        } else {
            System.out.println("Have is infomation Food" + "that you want to search");
            x.showProfile();
        }
    }

    public Food searchFoodObjectById(String foodID) {
        if (foodID.isEmpty()) //hàm tìm, nếu không thấy sẽ return rỗng
        {
            return null;
        }
        for (int i = 0; i < food.size(); i++) {
            if (food.get(i).getId().equalsIgnoreCase(foodID)) {
                return food.get(i);
            }
        }
        return null; //nếu không thấy gì hàm trả về return null
    }

    public void searchByName() {
        String name;
        char n;
        do {
            name = MyToys.getString("Input Name of Food", "Please enter Name again!");
            Food xxx = searchObjectByName(name);
            System.out.println("------------------------");
            if (xxx == null) {
                System.out.println("Not found");
            } else {
                System.out.println("The list Food by Name" + "that you want to search");
                String header = String.format("|%-6s|%-10s|%-6s|%-8s|%-10s|%-10s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIREDDATE");
                System.out.println(header);
                for (Food xx : food) {
                    if (xx.getName().equalsIgnoreCase(name)) {
                        xx.showProfile();
                    }
                }
            }
            System.out.println("Do you want search Food again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }

    public Food searchObjectByName(String name) {
        if (name.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < food.size(); i++) {
                if (food.get(i).getName().equalsIgnoreCase(name)) {
                    return food.get(i);
                }
            }
        }
        return null;
    }

    public int searchByIdFood(String foodID) {
        //hàm so sánh xem có khớp với id trong mảng hay không?
        int pos;
        if (foodID.isEmpty()) {
            return -1; // không tìm hết trả về -1
        }
        for (int i = 0; i < food.size(); i++) {
            if (food.get(i).getId().equalsIgnoreCase(foodID)) {
                return i;
            }
        }
        return -1; //không tìm thấy trả về -1

    }

    public void removeFoodById() {
        String id;
        char n;
        do {
            int tmp; //vị trí đã tìm thấy food có trong sách
            id = MyToys.getId("Input Food Id(DXXXX)", "The format of Id is DXXXX", "[D|d]\\d{4}$");
            tmp = searchByIdFood(id);
            System.out.println("----------------------------");
            if (tmp == -1) {
                System.out.println("Not found!!");
            } else {
                food.remove(tmp);
                System.out.println("You remove Food Successfully!!");
                System.out.println("----------------------------");
                System.out.println("The list Food here after you remove");
                String header = String.format("|%-6s|%-10s|%-6s|%-8s|%-10s|%-10s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIREDDATE");
                System.out.println(header);
                for (Food x : food) {
                    x.showProfile();
                }
            }
            System.out.println("Do you want remove Food agian? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');

    }

    public void printTheFoodDescendingOfDate() throws IOException {
        if (food.isEmpty()) {
            System.out.println("Nothing print");
            return;
        }
        Comparator date = new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpiredDate().compareToIgnoreCase(o1.getExpiredDate());
            }
        };
            Collections.sort(food,date);
        System.out.println("----------------------------");
        String header = String.format("|%-6s|%-10s|%-6s|%-8s|%-10s|%-10s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIREDDATE");
        System.out.println(header);
        for (Food xx : food) {
            xx.showProfile();
        }
            try {
                String fileName = "";
                System.out.println("Input name (<<file_name>>.dat) that you want save");
                fileName = sc.nextLine();
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream fw = new ObjectOutputStream (file);
                for (Food x : food) {
                    fw.writeObject(x);
                }
                fw.close();
                file.close();
        } catch (Exception e) {
                System.out.println(e);
        }
            System.out.println("You save the file Successfully!!!");
    }

}
