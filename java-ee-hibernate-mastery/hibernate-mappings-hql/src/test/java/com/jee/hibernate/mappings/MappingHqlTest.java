package com.jee.hibernate.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MappingHqlTest {

    @Test
    void joinFetchAvoidsLazyInitException() {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Department eng = new Department("Platform Engineering");
            eng.addEmployee(new Employee("Aarav Sharma"));
            eng.addEmployee(new Employee("Diya Nair"));
            session.persist(eng);
            tx.commit();
        }

        List<Department> loaded;
        try (Session session = sf.openSession()) {
            loaded = session.createQuery(
                    "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees",
                    Department.class
            ).getResultList();
        }

        assertEquals(1, loaded.size());
        assertEquals(2, loaded.get(0).getEmployees().size());
        sf.close();
    }
}
