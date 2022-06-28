package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test Cascading 4",22);

            person.addItem(new Item("Computer 1"));
            person.addItem(new Item("Computer 2"));
            person.addItem(new Item("Computer 3"));

            session.save(person);
//            session.save(item);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
