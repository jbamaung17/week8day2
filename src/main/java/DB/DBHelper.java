package DB;

import org.hibernate.*;

import java.util.List;


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

    private static void update(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction.begin();
            session.update(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction.begin();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria cr) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = cr.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUniqueResult(Criteria cr) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) cr.uniqueResult();
            transaction.commit();

        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }



    private static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        transaction.begin();
        Criteria cr = session.createCriteria(classType);
        results = getList(cr);
        return results;
    }

}
