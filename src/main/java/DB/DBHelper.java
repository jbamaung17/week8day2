package DB;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DBHelper {

    private static Session session;
    private static Transaction transaction;

    private static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction.begin();
            session.save(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
