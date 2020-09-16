package Controllers;

import counselling.com.HibernateSave;
import models.Counsellors;

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

        registercounselors(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registercounsellors.html");
    }

    private void registercounselors(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String first_Name = request.getParameter("first_Name");
        String last_Name = request.getParameter("last_Name");
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String specialization = request.getParameter("specialization");
        String Gender =request.getParameter("Gender");
        String email =request.getParameter("email");


        Counsellors counsellors = new Counsellors();
        counsellors.setFirst_name(first_Name);
        counsellors.setLast_name(last_Name);
        counsellors.setUser_name(user_name);
        counsellors.setPassword(password);
        counsellors.setSpecialization(specialization);
        counsellors.setGender(Gender);
        counsellors.setEmail(email);

        counselorDao.saveCounsellors(counsellors);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
        dispatcher.forward(request, response);
    }
}