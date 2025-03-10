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
import java.util.List;

@WebServlet("/editNote.html")
public class EditNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idToEdit =  Integer.parseInt(request.getParameter("id"));
        Model model = ModelFactory.getModel();
        List<Note> notes = model.readNotes();
        Note noteToEdit = null;
        for (Note n : notes)
            if (n.getId() == idToEdit){
                noteToEdit = n;
                break;
            }
        request.setAttribute("noteToEdit", noteToEdit);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
        dispatch.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newContent = request.getParameter("content");
        String newTitle = request.getParameter("title");
        int idToEdit = Integer.parseInt(request.getParameter("id"));
        Model model = ModelFactory.getModel();
        List<Note> notes = model.readNotes();
        for (Note note : notes)
            if (note.getId() == idToEdit){
                note.setName(newTitle);
                note.setContent(newContent);
                break;
            }
        model.writeNotes(notes);
        response.sendRedirect("notes.html");
    }
}
