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

@WebServlet("/registercounselors")
public class CounsellorsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HibernateSave counselorDao;

    public void init() {
        counselorDao = new HibernateSave();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("==================================");
        registercounselors(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registercounselors.jsp");
    }

    private void registercounselors(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");


        Counsellors counsellors = new Counsellors();
        counsellors.setFirst_name(first_name);
        counsellors.setLast_name(last_name);
        counsellors.setUser_name(user_name);
        counsellors.setPassword(password);





        counselorDao.saveCounsellors(counsellors);

        RequestDispatcher dispatcher = request.getRequestDispatcher("counselors.html");
        dispatcher.forward(request, response);
    }
}