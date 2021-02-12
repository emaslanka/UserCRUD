package pl.coderslab.users;

import pl.coderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "UserList", urlPatterns= "/user/list")
@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String idOfUser = request.getParameter("id");
        int id = Integer.parseInt(idOfUser);

        UserDao userDao = new UserDao();
        try {
            userDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect("list");



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}
