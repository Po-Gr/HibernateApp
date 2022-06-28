package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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

            Person person = new Person("Bill", 18);

            Item item = new Item("Keyboard", person);

            List<Item> items = new ArrayList<>();
            items.add(item);

            person.setItems(items);

            session.save(person);
            session.save(item);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
