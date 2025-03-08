package org.example.Servlets;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

@WebServlet("/data.html")
public class DisplayDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        List<String> data = model.readFile(new File("data/test.txt"));
        request.setAttribute("data", data);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/data.jsp");
        dispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newData = request.getParameter("data");
        Model model = ModelFactory.getModel();
        model.editFile(new File("data/test.txt"), newData);
        response.sendRedirect("data.html");
    }
}
