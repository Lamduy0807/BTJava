/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Students;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface studentsDAO {
    ArrayList<Students> getListOfStudent();
    Students getInformationById(String id);
    Boolean checkExist(String id);
    Boolean InsertNewStudent(Students student);
}
