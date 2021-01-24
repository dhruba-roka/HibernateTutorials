package com.dhruba.HibernateWithAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Teacher t1 = new Teacher();
        t1.setName("shyam");
        t1.setDepartment("damauli");
    	
    	Configuration configuration= new Configuration();
        configuration.configure("com/dhruba/HibernateWithAnnotation/hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        
        Transaction transaction=session.beginTransaction();
        session.save(t1);
        transaction.commit();
        session.close();
    }
}
