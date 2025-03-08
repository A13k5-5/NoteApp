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
import org.example.Classes.Note;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

@WebServlet("/notes.html")
public class NotesPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        List<Note> notes = model.readNotes();
        request.setAttribute("notes", notes);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/notes.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteContent = request.getParameter("content");
        Note newNote = new Note(noteContent);
        Model model = ModelFactory.getModel();
        model.addNote(newNote);
        response.sendRedirect("notes.html");
    }
}
