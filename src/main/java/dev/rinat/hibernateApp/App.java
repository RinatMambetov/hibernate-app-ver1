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

            Person person1 = new Person("Rinat", 25);
            Person person2 = new Person("Mahmoud", 30);
            Person person3 = new Person("Ali", 27);

            currentSession.save(person1);
            currentSession.save(person2);
            currentSession.save(person3);

//            Person person = currentSession.get(Person.class, 1);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
