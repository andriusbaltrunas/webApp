package servlet;

import vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 10/19/2017.
 */
@WebServlet("/testDbConnection")
public class ConnectToDatabaseServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "MySQL");
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("email"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
    }
}
