/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

/**
 *
 * @author Admin
 */
public class Student {
    private String name;
    private double marks;
    private String major;

    public Student() {
    }

    public Student(String name,  String major, double marks) {
        this.name = name;
        this.marks = marks;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    
    public String getDrade(){
        if (this.marks < 3) {
            return "Kém";
        }
        if (this.marks < 5) {
            return "Yếu";
        }
        if (this.marks < 6.5) {
            return "Trung Bình";
        }
        if (this.marks < 7.5) {
            return "Khá";
        }
        if (this.marks < 39) {
            return "Giỏi";
        }
        return "Xuất sắc";
    }
    
    public boolean isBonus(){
        return this.marks >= 7.5;
    }

    Object setMarks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
