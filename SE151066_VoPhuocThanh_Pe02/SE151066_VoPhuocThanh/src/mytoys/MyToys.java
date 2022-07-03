package mytoys;

import static java.lang.String.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mr.Thanh
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

   
    public static int getAnInteger(String inputMsg, String errosMsg, int lower, int upper) {
        int n, tmp;
        if (lower > upper) {
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

    public static int getAnIntegerNumber(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Injection 1st");
                } else if (n == 2) {
                    System.out.println("Injection 2st");

                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }

    }

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n = 1;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n != 1) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }


    public static String getId(String inputMsg, String errorMsg, String format) {
        while (true) {
            System.out.print(inputMsg);
            String s = sc.nextLine().trim();
            if (s.length() == 0 || s.isEmpty() || s.matches(format) == false) {
                System.err.println(errorMsg);
            } else {
                return s;
            }
        }
    }

    
    public static String getString(String inputMsg, String errorMsg) {
        String n;
        while (true) {
            System.out.println(inputMsg);
            n = sc.nextLine().trim();
            if (n.length() == 0 || n.isEmpty()) 
            {
                System.out.println(errorMsg);
            } else {
                return n;
            }
        }
    }

    public static String getStringNull(String inputMsg, String errosMsg) {
        String n = null;
        try {
            System.out.println(inputMsg);
            n = sc.nextLine();
        } catch (Exception e) {
            System.out.println("");
        }
        return n;

    }

    public static boolean getYesNo(String inputMsg) {
        while (true) {
            System.out.println(inputMsg);
            String str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.err.println("Do not accpect empty");
                continue;
            }
            if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("n") || str.equalsIgnoreCase("no")) {
                if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes")) {
                    return true;
                }
                if (str.equalsIgnoreCase("n") || str.equalsIgnoreCase("no")) {
                    return false;
                }
            } else {
                System.err.println("Format is Yes-Y|No-N!\n");
            }

        }

    }

    public static String getStringDate(String inputMsg, String errorMsg, String format) {
        String date;
        boolean match;
        boolean samilar;
        while (true) {
            System.out.println(inputMsg);
            date = sc.nextLine();
            samilar = date.matches(format);
            match = checkDate(date);
            if (match == false || samilar == false) {
                return date;

            } else {
                System.out.println(errorMsg);
            }
        }

    }

    public static boolean checkDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        try {

            testDate = df.parse(date);

        } catch (ParseException e) {

            return false;

        }
        if (!df.format(testDate).equals(date)) {

            return false;
        }

        return true;
    }

    public static Date inputDate(String inputMsg, String errorMsg) {
        int day, month, year;
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        String dateFormat = "\\d{2}-\\d{2}-\\d{4}";
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        Date date = null;
        d.setLenient(false);
        do {
            System.out.println(inputMsg);
            String data = sc.nextLine();
            if (data.matches(dateFormat)) {
                try {
                    date = d.parse(data);
                    check = true;
                } catch (Exception e) {
                    System.out.println(errorMsg);;
                    check = false;
                }
            } else {
                System.out.println("DateFormat invalid.");
                check = false;
            }
        } while (check != true);
        return date;
    }

    static boolean IsNamNhuan(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getDate(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return date;
    }

    public static long getDifferenceDays(Date date1, Date date2) {        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        long diff = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        return diff;
        
    }
     

}
