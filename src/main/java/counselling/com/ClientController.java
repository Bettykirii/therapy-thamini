package counselling.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author makena
 */

@WebServlet("/register")
public class ClientController extends HttpServlet {
    private HibernateSave userDao;

    public void init() {
        userDao = new HibernateSave();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Clients clients = new Clients();
        clients.setFirstName(firstName);
        clients.setLastName(lastName);
        clients.setUsername(username);
        clients.setPassword(password);

        userDao.saveClients(clients);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
        dispatcher.forward(request, response);
    }
}