package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/sort")
public class SortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sortOrder = request.getParameter("sortOrder");
        if (sortOrder.equals("a-z")) {
            ModelFactory.getModel().sort(false);
        } else if (sortOrder.equals("z-a")) {
            ModelFactory.getModel().sort(true);
        } else if (sortOrder.equals("oldest-to-newest")) {
            ModelFactory.getModel().sort(true);
        }
        response.sendRedirect("/");
    }
}
