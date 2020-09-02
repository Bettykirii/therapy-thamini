
package counselling.com;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class HibernateSave {

public static void saveCounsellors(Counsellors counsellors) {
        Transaction transaction = null;
        try (Session session2 = HibernateHelper.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session2.beginTransaction();
            // save the student object
            session2.save(counsellors);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }
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

        //Transaction transaction = null;
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





