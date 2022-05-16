/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Students {
    private String student_id;
    private String first_name;
    private String last_name;
    private String dob;
    private String department;
    private String entrance_date;
    private String graduation_date;
    private int credits;
    private float score;

    public Students(String student_id, String first_name, String last_name, String dob, String department, String entrance_date, String graduation_date, int credits, float score) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.department = department;
        this.entrance_date = entrance_date;
        this.graduation_date = graduation_date;
        this.credits = credits;
        this.score = score;
    }

    public Students() {
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEntrance_date() {
        return entrance_date;
    }

    public void setEntrance_date(String entrance_date) {
        this.entrance_date = entrance_date;
    }

    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
    Scanner scanner = new Scanner(System.in);
    public void Enter(){
        System.out.print("Enter ID: ");
	student_id = scanner.next();
        System.out.print("Enter First Name: ");
	first_name = scanner.next();
        System.out.print("Enter Last Name: ");
	last_name = scanner.next();
        System.out.print("Enter dob: ");
	dob = scanner.next();
        System.out.print("Enter department: ");
	department = scanner.next();
        scanner.nextLine();
        System.out.print("Enter entrance date: ");
	entrance_date = scanner.next();
        System.out.print("Enter graduate date: ");
	graduation_date = scanner.next();
        System.out.print("Enter credits: ");
	credits = scanner.nextInt();
        System.out.print("Enter score: ");
	score = scanner.nextFloat();
    }
    @Override
    public String toString() {
        return student_id + "   " + first_name + "   " + last_name + "   " + dob + "   " + department + "   " + entrance_date + "   " + graduation_date + "   " + credits + "   " + score ;
    }
    
}
