
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






}

