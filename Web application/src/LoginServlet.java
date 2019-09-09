
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet(urlPatterns = "/LoginServlet", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        UserDao userDao = new UserDao();

        if (userDao.isValidUser(name, HashPassword.getHash(pass))) {
            request.getSession().setAttribute("username", name);

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (name.equals(cookie.getName())) {
                        request.getSession().setAttribute("lastdate", cookie.getValue());
                    }
                }
            }

            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 365); //хранить куки год
            response.addCookie(userCookie);

            request.getRequestDispatcher("/ListServlet").forward(request, response);


        } else {

            request.setAttribute("errorMessage", "Неправильный логин и пароль");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

//    public boolean validUser(String user, String passw) {
//
//        return user.equalsIgnoreCase("admin") && passw.equalsIgnoreCase("admin");
//    }

}
