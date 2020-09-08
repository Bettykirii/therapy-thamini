package counselling.com;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/DisplayClients" })
    public class DisplayClients extends HttpServlet {


        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Session session = HibernateHelper.getSessionFactory().getCurrentSession();
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                List<Transaction> transactions = session.createQuery("From Transactions r").getResultList();
                //List<Student> students = session.createCriteria(Student.class).list();
                ObjectMapper json = new ObjectMapper();
                response.getWriter().println(json.writeValueAsString(transactions));
                tx.commit();
            }catch (Exception e){
                // TODO: handle exception properly
                response.getWriter().println("An error has occurred");
                e.printStackTrace();
            }
        }
}
