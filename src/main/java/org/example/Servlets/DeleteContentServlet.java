package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/deleteContent")
public class DeleteContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long noteId = Long.parseLong(request.getParameter("noteId"));
        long contentId = Long.parseLong(request.getParameter("contentId"));
        ModelFactory.getModel().removeContent(noteId, contentId);
        response.sendRedirect("editNote.html?id=" + noteId);
    }
}
