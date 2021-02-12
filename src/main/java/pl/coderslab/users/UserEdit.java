package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String idOfUser = request.getParameter("id");

        int id = Integer.parseInt(idOfUser);

        UserDao userDao = new UserDao();
        try {
            request.setAttribute("user", userDao.read(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/users/edit.jsp").forward(request, response);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String idOfUser = request.getParameter("id");
        int id = Integer.parseInt(idOfUser);

        UserDao userDao = new UserDao();
        User newUser = null;
        try {
            newUser = userDao.read(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);

        try {
            userDao.update(newUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("list");

    }


}
