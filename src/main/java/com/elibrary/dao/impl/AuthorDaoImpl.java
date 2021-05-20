package com.elibrary.dao.impl;

import com.elibrary.dao.AuthorDao;
import com.elibrary.entity.Author;
import com.elibrary.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {
    public Author get(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Author author = null;
        try {
            author = session.get(Author.class, id);
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return author;
    }

    public Author save(Author author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(author);
            session.getTransaction().commit();
        }
        catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return author;
    }

    public Author update(Author author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(author);
            session.getTransaction().commit();
        }
        catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return author;
    }

    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Author author = session.get(Author.class, id);
            if (author != null){
                session.delete(author);
            }
            session.getTransaction().commit();
        }
        catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
