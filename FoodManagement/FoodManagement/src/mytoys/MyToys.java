package mytoys;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Mr.Thanh
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    //nhập vào số thực, nếu không đúng số thực thì bắt người dùng nhập lại
    public static double getADouble(String inputMsg, String errosMsg, double lower, double upper) {
        double n, tmp;
        if (lower > upper) {
            //nếu đầu vào lower thì sẽ đổi chỗ upper
            tmp = lower;
            lower = upper;
            upper = tmp;
        }
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errosMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errosMsg, int lower, int upper) {
        int n, tmp;
        if (lower > upper) {
            //nếu đầu vào lower thì sẽ đổi chỗ upper
            tmp = lower;
            lower = upper;
            upper = tmp;
        }
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errosMsg);
            }
        }

    }

//nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    public static String getId(String inputMsg, String errorMsg, String format) {
        String id;
        boolean n;  //biến định dạng chuỗi
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            n = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || n == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    //Nhập vào một chuỗi kí tự khác rỗng , nếu người dùng nhập khác chuỗi
    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) //nếu không 1 trong 2 k thỏa đk thì thì người dùng nhập lại
            {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getStringDate(String inputMsg, String errorMsg) {
        
          SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        String date;
        while (true) {
            try {
                date = getString(inputMsg, errorMsg);
                df.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println(errorMsg);
            }
        }
    }

    


}
