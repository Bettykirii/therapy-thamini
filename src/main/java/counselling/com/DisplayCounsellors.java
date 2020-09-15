package counselling.com;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/display_counsellors"})
public class DisplayCounsellors extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Session session = HibernateHelper.getSessionFactory().openSession();
        List<models.Clients> clients = session.createQuery("FROM counsellors p").getResultList();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients);
            response.getWriter().println(json);
        } catch(Exception e) {
            //e.printStackTrace();
            response.getWriter().println(e.getMessage());

        }
    }
}
