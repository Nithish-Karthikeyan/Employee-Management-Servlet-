package com.ideas2it.databaseconnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class is Singleton class used for Database Connection
 * used for opening the connection to the database
 * 
 * @author Nithish K
 * @version 1.0
 * @since 19.09.2022
 */
public class DatabaseConnection {

    private static SessionFactory sessionFactory = null;

    private DatabaseConnection() {}

    public static SessionFactory getConnection() {
        try {
            if (sessionFactory == null || sessionFactory.isOpen()) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sessionFactory;
    }
}