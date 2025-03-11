package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Classes.Note;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/addNote.html")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/addNote.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteContent = request.getParameter("content");
        String noteName = request.getParameter("name");
        Note newNote = new Note(noteContent, noteName);
        Model model = ModelFactory.getModel();
        model.addItem(newNote);
        response.sendRedirect("notes.html");
    }
}
