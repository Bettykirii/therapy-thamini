package counselling.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author bkirii
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HibernateSave loginDao;
    

    public void init() {
        loginDao = new HibernateSave();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("loginclient.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
}