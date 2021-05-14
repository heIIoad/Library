package com.elibrary.utils;

import com.elibrary.entity.Author;
import com.elibrary.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration conf = new Configuration()
                        .addAnnotatedClass(Author.class)
                        .addAnnotatedClass(Book.class)
                        .configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
                sessionFactory = conf.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e){
                e.printStackTrace();
                if (serviceRegistry != null){
                    StandardServiceRegistryBuilder.destroy(serviceRegistry);
                }
            }
        }
        return sessionFactory;
    }
}
