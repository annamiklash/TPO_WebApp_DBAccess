package view;

import model.Model;
import model.Resource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static common.Constants.MODEL_ATTRIBUTE;


@WebServlet("/result")
public class View extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Model modelAttribute = (Model) req.getAttribute(MODEL_ATTRIBUTE);
        if (modelAttribute == null) {
            resp.sendError(400, "Model instance is null");
            return;`
        }
        final List<Resource> resources = modelAttribute.getResources();

        req.setAttribute("resources", resources);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req, resp);




    }
}
