package controller;

import logic.UserLogic;
import logic.UserLogicImpl;
import model.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

import static common.Constants.PASSWORD_PARAMETER;
import static common.Constants.USERNAME_PARAMETER;
import static common.Constants.USER_SESSION_ATTRIBUTE;

@WebServlet(name = "FormServlet", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Resource(name = "jdbc/web-jdbc")
    private DataSource dataSource;

    private UserLogic userLogic;

    public void init() {
        userLogic = new UserLogicImpl(dataSource);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final String username = request.getParameter(USERNAME_PARAMETER);
        final String password = request.getParameter(PASSWORD_PARAMETER);

        final User user = userLogic.getUser(username, password);

        if (user != null) {
            final HttpSession session = request.getSession();
            session.setAttribute(USER_SESSION_ATTRIBUTE, user);

            response.sendRedirect(getServletContext().getContextPath() + "/result");
            return;

        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credentials Not Valid");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}

