package dev.rinat.hibernateApp;

import dev.rinat.hibernateApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

//            Person person = currentSession.get(Person.class, 1);
//            person.setName("Rinat");

//            Person person2 = currentSession.get(Person.class, 2);
//            currentSession.remove(person2);

            Person person3 = new Person("Rustam", 32);
            currentSession.persist(person3);
            System.out.println(person3.getId());

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
