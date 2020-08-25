
package counselling.com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSave {

    public static void main(String args []) {
        insertWithSaveorUpdateMethod();


    }


public static void insertWithSaveorUpdateMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        Clients clients = new Clients();
        clients.setFirstName("Jane ");
        clients.setLastName("Doe");
        clients.setUsername("Jdoe");
        clients.setPassword("janeydoe");


       session.saveOrUpdate(clients);


//
//    Counsellors counsellors = new Counsellors();
//        counsellors.setName("");
//        counsellors.setAreaOfExpertise("");
//        counsellors.setQualifications("");
//
//        session.save(counsellors);


        tx.commit();

    }
}
