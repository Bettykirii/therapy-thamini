
package counselling.com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSave {



    public static void saveClients(Clients clients) {
        Transaction transaction = null;
        try (Session session = HibernateHelper.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(clients);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    public boolean validate(String userName, String password) {

        Transaction transaction = null;
        Clients user = null;
        try (Session sessions = HibernateHelper.getSessionFactory().openSession()) {
            // start a transaction
           // transaction = sessions.beginTransaction();
            // get an user object
            user = (Clients) sessions.createQuery("FROM Clients U WHERE U.username = :userName").setParameter("userName", userName)
                    .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            //transaction.commit();
        } catch (Exception e) {
            // if (transaction != null) {
            //     transaction.rollback();
            // }
            e.printStackTrace();
        }
        return false;
    }

}





