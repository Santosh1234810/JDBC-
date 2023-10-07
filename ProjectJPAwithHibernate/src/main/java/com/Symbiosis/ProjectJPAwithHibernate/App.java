package com.Symbiosis.ProjectJPAwithHibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP");
       EntityManager em = emf.createEntityManager();
       
       Actor a = new Actor(101, "SunnyDeol","Gadar2");
       em.getTransaction().begin();
       em.persist(a);
       em.getTransaction().commit();
       System.out.println("Saved data");
    }
}
