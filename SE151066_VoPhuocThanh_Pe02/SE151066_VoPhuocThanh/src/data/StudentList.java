/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mytoys.MyToys;

/**
 *
 * @author Mr.Thanh
 */
public class StudentList {

    private List <Student> studentList;
    private Scanner sc = new Scanner(System.in);
    public StudentList() {
        studentList = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        studentList.add(student);
    }
    public void addStudent(){
        String id;
        String name;
        id = MyToys.getString("Student Id: ","please enter again!!");
        name = MyToys.getString("Student Name: ","please enter again!!");
        studentList.add(new Student(id, name));
    }
     public void printStudentList() {
        System.out.println("The list of Student");
        System.out.printf("|%-6s|%-10s|\n","Id","Name");
        for (int i = 0; i < studentList.size(); i++)
            studentList.get(i).showStudent();
    }
    
    public String[] searchStudentByNameReturnStudentId (String name) {
        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(name))
                count++;
        }
        String[] arrId = new String[count];
        count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(name)) {
                arrId[count] = studentList.get(i).getStudentID();
                count++;
            }
        }
        return arrId;
    }
    
    public Student[] returnArrayOfStudent() {
        Student arr[] = new Student[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) 
            arr[i] = studentList.get(i);
        return arr;
    }
    
    public Student searchStudentId(String studentID) {
        if (studentID.isEmpty())
            return null;
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getStudentID().equalsIgnoreCase(studentID))
                return studentList.get(i);
        return null;
    }
     public List<Student> searchInjectionByName(String name){
        List<Student> stu = new ArrayList();
        if (studentList.isEmpty())
            return null;
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getName().equalsIgnoreCase(name))
                stu.add(studentList.get(i));            
        return stu;
    }
    
   
    public void removeStudentByName() {
        String studentID;
        char n;
        do {
         studentID = MyToys.getId("Enter student id (SXX): ", "The format of Id is SXX", "[S,s]\\d{2}$");
            Student tmp = searchStudentId(studentID);
            System.out.println("----------------------------");
            if (tmp == null) {
                System.out.println("Not found student in the list!!");
            } else {
                studentList.remove(tmp);
                for (Student x : studentList) {
                    x.showStudent();
                }
            }
            System.out.println("Do you want remove agian? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');

    }
    public Student searchStudentByName(String name) {
        if (name.isEmpty())
            return null;
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getName().equalsIgnoreCase(name))
                return studentList.get(i);
        return null;
    }
    public void searchStudentByName() {
        if (studentList.isEmpty()) {
            System.out.println("not found");
        }
        char n;
        do {
            String name;
           name = MyToys.getString("Enter enter name student ", "please enter name");
            Student xxx = searchStudentByName(name);
            if (xxx == null) {
                System.out.println("Student don't have information to print");
            } else {
                System.out.println("----------------------------");
                System.out.println("The list search information of Student ");
                System.out.printf("|%-7s|%-10s|\n",
                       "StudentID", "Name");
                for (Student xx : studentList) {
                    if (xx.getName().equalsIgnoreCase(name)) {

                        xx.showStudent();
                    }
                }
            }
            System.out.println("Do you want search again? (Y/N)");
            System.out.print("You should enter Y to continue: ");
            n = sc.nextLine().charAt(0);
        } while (n != 'N');
    }

    public void readFromFile() {
      try {
             FileInputStream fis = new FileInputStream("student.dat");
                   ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
               studentList= (List<Student>) ois.readObject();
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
            FileOutputStream fw = new FileOutputStream("student.dat");
            ObjectOutputStream bw = new ObjectOutputStream(fw);
            bw.writeObject(studentList);
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
