package by.kovalchuk;

import by.kovalchuk.dao.UserDao;
import by.kovalchuk.model.User;
import by.kovalchuk.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("newLoginName");
        String password = request.getParameter("newPassword");

        UserDao daoUser = new UserDao();

        User user = new User(name, HashPassword.getHash(password));

        if (daoUser.insertUser(user)) {
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существует");
            request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
    }
}

