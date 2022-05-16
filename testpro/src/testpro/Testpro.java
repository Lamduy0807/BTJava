/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpro;

import DAOImplement.studentsDAOImplement;
import Model.Students;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Testpro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
//        ArrayList<Students> students = studentsDAOImplement.getInstance().getListOfStudent();
//        for(Students stu: students){
//            System.out.println(stu.toString());
//        }
     //       System.out.print(studentsDAOImplement.getInstance().getInformationById("M19010").toString());
     
           Scanner scanner = new Scanner(System.in);
	   Calendar instance = Calendar.getInstance();
            
           int iChoice = 0;
           boolean bFlag = false;
           String sID;
           
           System.out.println("Please input your choice: ");
		do {
			// Main menu for user to choose
			System.out.println("1. Print all students");
			System.out.println("2. Find student by id");
			System.out.println("3. Add a student");
			System.out.println("4. Edit a student");
			System.out.println("5. Delete a student");
			System.out.println("6. Exits");
                     do {
				// Check Choice invalid
				iChoice = scanner.nextInt();
				if(iChoice<=0)
				{
					System.out.println("Invalid choice");
					bFlag = true;
				}
			}while(bFlag);
                     switch(iChoice) {
				case 1:
				{
                                    ArrayList<Students> students = studentsDAOImplement.getInstance().getListOfStudent();
                                    for(Students stu: students){
                                        System.out.println(stu.toString());
                                    }
                                    break;
                                }
                                case 2:
                                {
                                    System.out.print("Enter student ID: ");
                                    sID = scanner.next();
                                    if(studentsDAOImplement.getInstance().checkExist(sID))
                                        System.out.println(studentsDAOImplement.getInstance().getInformationById(sID).toString());
                                    else
                                        System.out.println("No students with this ID in database");
                                    
                                    break;
                                }
                                case 3:
                                {
                                    Students student = new Students();
                                    student.Enter();
                                    System.out.println(studentsDAOImplement.getInstance().InsertNewStudent(student)? "Success":"Fail");
                                    break;
                                }
                                case 6:
                                {
                                    System.out.println("Exiting......"); 
                                    System.exit(0);
                                    break; 
                                }
                     }
                     
                }while(iChoice<7);

    }
    
}
