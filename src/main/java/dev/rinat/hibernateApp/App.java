package dev.rinat.hibernateApp;

import dev.rinat.hibernateApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

            Person person = currentSession.get(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
