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

@WebServlet("/editNote.html")
public class EditNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        long idToEdit =  Long.parseLong(request.getParameter("id"));
        request.setAttribute("noteToEdit", model.find(idToEdit));
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newContent = request.getParameter("content");
        String newTitle = request.getParameter("title");
        long idToEdit = Long.parseLong(request.getParameter("id"));
        Model model = ModelFactory.getModel();
        model.editNote(idToEdit, newContent, newTitle);
        response.sendRedirect("viewNote.html?id=" + idToEdit);
    }
}
