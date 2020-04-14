package controller;

import logic.UserLogic;
import logic.UserLogicImpl;
import model.Model;
import model.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

import static common.Constants.MODEL_ATTRIBUTE;
import static common.Constants.PASSWORD_PARAMETER;
import static common.Constants.USERNAME_PARAMETER;

@WebServlet(name = "FormServlet", urlPatterns = "/res")
public class Controller extends HttpServlet {

    @Resource(name = "jdbc/web-jdbc")
    private DataSource dataSource;

    private UserLogic userLogic;

    public void init() {
        userLogic = new UserLogicImpl(dataSource);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter(USERNAME_PARAMETER);
        final String password = request.getParameter(PASSWORD_PARAMETER);

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            final boolean exists = userLogic.userExists(username, password);

            if (exists) {
                User user = userLogic.getUser(username, password);
                final Model model = userLogic.getUserResources(user);

                request.setAttribute(MODEL_ATTRIBUTE, model);
                redirectToResult(request, response);

            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credentials Not Valid");
            }
        }
    }

    private void redirectToResult(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        final ServletContext servletContext = getServletContext();
        final RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/result");

        requestDispatcher.forward(req, res);
    }
}
