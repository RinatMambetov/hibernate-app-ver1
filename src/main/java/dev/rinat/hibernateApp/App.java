package dev.rinat.hibernateApp;

import dev.rinat.hibernateApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

//            List<Person> fromPerson = currentSession.createQuery("from Person", Person.class).getResultList();

//            List<Person> fromPerson = currentSession.createQuery(
//                    "from Person where age > 25", Person.class).getResultList();

//            List<Person> fromPerson = currentSession.createQuery(
//                    "from Person where name like 'Ja%'", Person.class).getResultList();

//            currentSession.createMutationQuery(
//                    "update Person set name='test2' where age < 25").executeUpdate();

            currentSession.createMutationQuery(
                    "delete from Person where age < 25").executeUpdate();

            List<Person> fromPerson = currentSession.createQuery(
                    "from Person", Person.class).getResultList();
            for (Person person : fromPerson) {
                System.out.println(person);
            }

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
