package com.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentDAO {

    public void saveStudent(Student s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        session.close();
    }
}