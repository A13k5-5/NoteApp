package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/viewNote.html")
public class ViewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        long idToView = Long.parseLong(request.getParameter("id"));
        request.setAttribute("note", model.findNote(idToView));
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/viewNote.jsp");
        dispatch.forward(request, response);
    }
}
