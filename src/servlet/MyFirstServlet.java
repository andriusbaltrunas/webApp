package servlet;

import vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andriusbaltrunas on 10/19/2017.
 */
@WebServlet("/myServlet")
public class MyFirstServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // prideda nauja kintamaji i req
        req.setAttribute("myParam", "tis is default param from servlet");

        Student student = new Student(1, "Andrius", "Baltrunas", "+370 73 38 33", "myEmail@yahoo.com");

        req.setAttribute("st", student);
        //siucia requesta i welcome psl
        req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);

    }
}
