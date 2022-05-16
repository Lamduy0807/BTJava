/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import DAO.studentsDAO;
import Db.DbConnection;
import Model.Students;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class studentsDAOImplement implements studentsDAO{
    private static studentsDAO instance;
   private Connection connection;
   private studentsDAOImplement() throws ClassNotFoundException{
       connection = DbConnection.getConnect();
   }
   public static studentsDAO getInstance() throws ClassNotFoundException{
       if(instance == null)
       {
           instance = new studentsDAOImplement();
       }
       return instance;
   }
   private Students setDataIntoResultSet(ResultSet r) throws SQLException{
      String id = r.getString(1);
      String fname = r.getString(2);
      String lname = r.getString(3);
      String dob = r.getString(4);
      String depart = r.getString(5);
      Date entran = r.getDate(6);
      Date gradua = r.getDate(7);
      int credits = r.getInt(8);
      float score = r.getFloat(9);
      return new Students(id, fname, lname, dob, depart, entran.toString() , "NULL", credits, score);
   }
    @Override
    public ArrayList<Students> getListOfStudent() {
        String sql = "SELECT student_id, first_name, last_name, dob, department, entrance_date, graduation_date, credits, score FROM students";
        ArrayList<Students> Students = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {
                    Students stu = setDataIntoResultSet(resultSet);
                    Students.add(stu);
                }
                preparedStatement.close();
            } catch (SQLException ex) {
                System.out.print("Error");
            }
            return Students;     
    }

    @Override
    public Students getInformationById(String id) {
        String sql = "SELECT student_id, first_name, last_name, dob, department, entrance_date, graduation_date, credits, score FROM students WHERE student_id = '"+ id + "'";
        Students student = new Students();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {
                    student  = setDataIntoResultSet(resultSet);
                }
                preparedStatement.close();
            } catch (SQLException ex) {
                System.out.print("Error");
            }
            return student;
    }

    @Override
    public Boolean checkExist(String id) {
        String sql = "SELECT student_id, first_name, last_name, dob, department, entrance_date, graduation_date, credits, score FROM students WHERE student_id = '"+ id + "'";
        int cout = 0; 
        PreparedStatement preparedStatement;
        ResultSet resultSet;
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                
                while(resultSet.next())
                {
                    cout++;
                }
                preparedStatement.close();
            } catch (SQLException ex) {
                System.out.print("Error");
            }
        return cout ==1;
    }

    @Override
    public Boolean InsertNewStudent(Students student) {
        String sql = "INSERT INTO students (	\n" +
"					student_id, \n" +
"					first_name, \n" +
"					last_name, \n" +
"					dob, \n" +
"					department, \n" +
"					entrance_date, \n" +
"					graduation_date,\n" +
"					credits, \n" +
"					score) \n" +
"				VALUES (?,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);    
      preparedStatement.setString(1, student.getStudent_id());
      preparedStatement.setString(2, student.getFirst_name());
      preparedStatement.setString(3, student.getLast_name());
      
      DateFormat  dateformatter = new SimpleDateFormat("yyyy-MM-dd");  
      Date fd = null;
      Date fd1 = null;
      Date fd2 = null;
            try {
                fd = new SimpleDateFormat("yyyy-MM-dd").parse(student.getDob());
                fd1 = new SimpleDateFormat("yyyy-MM-dd").parse(student.getEntrance_date());
            } catch (ParseException ex) {
                Logger.getLogger(studentsDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
      java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
      preparedStatement.setDate(4, sqlDate);
      
      preparedStatement.setString(5, student.getDepartment());
      
      java.sql.Date sqlDate1 = new java.sql.Date(fd1.getTime());
      preparedStatement.setDate(6, sqlDate1);
      
      java.sql.Date sqlDate2;
      if("NULL".equals(student.getGraduation_date()))
      {
          sqlDate2 = new java.sql.Date(Types.NULL);
      }
      else
        {
          try { 
              fd2 = new SimpleDateFormat("yyyy-MM-dd").parse(student.getGraduation_date());
          } catch (ParseException ex) {
              Logger.getLogger(studentsDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
          }
          sqlDate2 = new java.sql.Date(fd2.getTime());
        } 
      preparedStatement.setDate(7, sqlDate2);
      preparedStatement.setInt(8, student.getCredits());
      preparedStatement.setFloat(9, student.getScore());

      return preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      System.out.print("Error when inserting!!");
    }
    return false;
    }
    
}
