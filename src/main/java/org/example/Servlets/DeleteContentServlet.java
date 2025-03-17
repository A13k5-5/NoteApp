package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Exceptions.ContentNotFound;
import org.example.Exceptions.NoteNotFound;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/deleteContent")
public class DeleteContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long noteId = Long.parseLong(request.getParameter("noteId"));
        long contentId = Long.parseLong(request.getParameter("contentId"));
        try {
            ModelFactory.getModel().removeContent(noteId, contentId);
        } catch (ContentNotFound | NoteNotFound e) {
            request.setAttribute("message", e.getMessage());
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/error.jsp");
            dispatch.forward(request, response);
        }
        response.sendRedirect("editNote.html?id=" + noteId);
    }
}
