package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resourceDetail")
public class DetailsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String details = (String) request.getSession().getAttribute("details");
        request.setAttribute("details", details);
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("resourceDetail.jsp");
        requestDispatcher.forward(request, response);

    }
}
