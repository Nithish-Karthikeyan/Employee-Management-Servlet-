package com.ideas2it.databaseconnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

/**
 * This class is Singleton class used for Database Connection
 * used for opening and closing the connection to the database 
 * 
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class DatabaseConnection {

    private static Session session = null;

    private DatabaseConnection() {}

    public static Session getConnection() {
        try {
            if (session == null || session.isOpen()) {
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return session;
    }

    public static void closeConnection() {
        try {
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
}