package com.klef.hibernatecrud;

import org.hibernate.Session;
import com.klef.hibernatecrud.entity.Product;
import com.klef.hibernatecrud.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        // INSERT
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Product p1 = new Product("Laptop", "HP Pavilion", 65000, 10);
        Product p2 = new Product("Mobile", "Samsung Galaxy", 30000, 20);

        session.save(p1);
        session.save(p2);

        session.getTransaction().commit();
        session.close();

        System.out.println("Products inserted");

        // READ
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, 1);
        System.out.println("Fetched: " + product.getName());
        session.close();

        // UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        product.setPrice(70000);
        session.update(product);
        session.getTransaction().commit();
        session.close();

        System.out.println("Product updated");

        // DELETE
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product del = session.get(Product.class, 2);
        if (del != null)
            session.delete(del);
        session.getTransaction().commit();
        session.close();

        System.out.println("Product deleted");
    }
}
