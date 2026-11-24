package com.jee.hibernate.core;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HibernateCoreTest {

    @Test
    void persistAndDirtyCheckUpdate() {
        Long courseId;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = new Course("Hibernate 6 Mastery", 20);
            session.persist(course);
            tx.commit();
            courseId = course.getId();
        }
        assertNotNull(courseId);

        // Dirty checking: modifying a managed entity updates DB automatically on commit
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Course managed = session.find(Course.class, courseId);
            managed.setDurationHours(35);
            tx.commit();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Course updated = session.find(Course.class, courseId);
            assertEquals(35, updated.getDurationHours());
        }
    }
}
