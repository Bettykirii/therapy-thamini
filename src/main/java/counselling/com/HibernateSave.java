
package counselling.com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSave {

    public static void main(String args []) {
        insertWithSaveMethod();


    }


public static void insertWithSaveMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        Clients clients = new Clients();
        clients.setName("Jane Doe");
        clients.setClientNeed("jane.doe@nodomain.com");

       session.save(clients);



    Counsellors counsellors = new Counsellors();
        counsellors.setName("");
        counsellors.setAreaOfExpertise("");
        counsellors.setQualifications("");

        session.save(counsellors);


        tx.commit();

    }
}
