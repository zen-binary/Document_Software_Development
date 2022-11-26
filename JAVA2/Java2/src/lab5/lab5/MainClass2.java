/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MainClass2 {
    
    public static void main(String[] args) {
        String path = "students.dat";
        
        List<Student> list = new ArrayList<>();
        List<Student> listnew = new ArrayList<>();
        
        Student sv = new Student("abc", "Cntt", 9);
        Student svnew = new Student();
        
        
        list.add(new Student("a", "cnnt", 10));    
        list.add(new Student("a", "cnnt", 10));
        list.add(new Student("a", "cnnt", 10));
        list.add(new Student("a", "cnnt", 10));
        list.add(new Student("a", "cnnt", 10));


        
        try {
            
             XFile.writeObj(path, list);
             
             listnew = (List<Student>) XFile.readObj(path);
             for (Student s : listnew) {
                 System.out.println("Name: " + s.getName());
                 System.out.println("Mark: " + s.getMarks());
                 System.out.println("Major: " + s.getMajor());
            }
//            XFile.writeObj(path, sv);
           
//            svnew = (Student) XFile.readObj(path);
//            System.out.println("Name: " + svnew.getName());
//            System.out.println("Mark: " + svnew.getMarks());
//            System.out.println("Major: "+ svnew.getMajor());
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
