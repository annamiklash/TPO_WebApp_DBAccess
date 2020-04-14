package controller;

import logic.UserLogic;
import logic.UserLogicImpl;
import model.Resource;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

import static common.Constants.USER_SESSION_ATTRIBUTE;

@WebServlet("/result")
public class ResultController extends HttpServlet {

    @javax.annotation.Resource(name = "jdbc/web-jdbc")
    private DataSource dataSource;

    private UserLogic userLogic;

    public void init() {
        userLogic = new UserLogicImpl(dataSource);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect(getServletContext().getContextPath() + "/resourceDetail");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final User user = (User) request.getSession().getAttribute(USER_SESSION_ATTRIBUTE);

        final List<Resource> resources = userLogic.getUserResources(user);

        request.setAttribute("resources", resources);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);
    }
}
