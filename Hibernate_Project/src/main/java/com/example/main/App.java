package com.example.main;

import com.example.model.Student;
import java.util.*;
import com.example.dao.StudentDAO;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Student s = new Student();

        System.out.print("Enter Name: ");
        String sn = scan.nextLine();
        s.setName(sn);

        StudentDAO dao = new StudentDAO();
        dao.saveStudent(s);

        System.out.println("✅ Data Inserted Successfully!");
    }
}