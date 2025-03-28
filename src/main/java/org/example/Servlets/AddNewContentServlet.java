package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Classes.Contents.Image;
import org.example.Classes.Contents.Text;
import org.example.Classes.StorageItems.Note;
import org.example.Exceptions.NoteNotFound;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/addContent")
public class AddNewContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        String type = request.getParameter("type");
        long noteId = Long.parseLong(request.getParameter("id"));
        Note noteToEdit = null;
        try {
            noteToEdit = model.findNote(noteId);
        } catch (NoteNotFound e) {
            request.setAttribute("message", e.getMessage());
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/error.jsp");
            dispatch.forward(request, response);
            return;
        }
        if (type.equals("text")) {
            noteToEdit.addContent(new Text());
        } else if(type.equals("image")) {
            noteToEdit.addContent(new Image());
        }
        response.sendRedirect("editNote.html?id=" + noteId);
    }
}
