package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.Classes.StorageItems.Note;
import org.example.Exceptions.ContentNotFound;
import org.example.Exceptions.NoteNotFound;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/editNote.html")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,   // 1MB
        maxFileSize = 1024 * 1024 * 10,    // 10MB
        maxRequestSize = 1024 * 1024 * 11 // 11MB
)
public class EditNoteServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(EditNoteServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        long idToEdit =  Long.parseLong(request.getParameter("id"));
        try {
            request.setAttribute("noteToEdit", model.findNote(idToEdit));
        } catch (NoteNotFound e) {
            request.setAttribute("message", e.getMessage());
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/error.jsp");
            dispatch.forward(request, response);
            return;
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newTitle = request.getParameter("title");
        long noteIdToEdit = Long.parseLong(request.getParameter("noteId"));
        Model model = ModelFactory.getModel();
        String contentPrefix = "content_";
        String descriptionPrefix = "description_";
        String imagePrefix = "img_";

        try {
            request.getParameterMap().forEach((paramName, paramValues) -> {
                if (paramName.startsWith(contentPrefix)) {
                    long contentIdToEdit = Long.parseLong(paramName.substring(contentPrefix.length()));
                    String newContent = paramValues[0];
                    try {
                        model.editText(noteIdToEdit, contentIdToEdit, newContent, newTitle);
                    } catch (ContentNotFound | NoteNotFound e) {
                        logger.log(Level.WARNING, "Content not found while editing text", e);
                    }
                } else if (paramName.startsWith(descriptionPrefix)) {
                    long contentIdToEdit = Long.parseLong(paramName.substring(descriptionPrefix.length()));
                    String newDescription = paramValues[0];
                    try {
                        model.editImageDescription(noteIdToEdit, contentIdToEdit, newDescription);
                    } catch (ContentNotFound | NoteNotFound e) {
                        logger.log(Level.WARNING, "Content not found while editing image description", e);
                    }
                }
            });

            for (Part part : request.getParts()) {
                if (part.getName().startsWith(imagePrefix) && part.getSize() > 0) {
                    long contentIdToEdit = Long.parseLong(part.getName().substring(imagePrefix.length()));
                    try {
                        model.editImage(noteIdToEdit, contentIdToEdit, part);
                    } catch (ContentNotFound e) {
                        logger.log(Level.WARNING, "Content not found while editing image", e);
                    }
                }
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/error.jsp");
            dispatch.forward(request, response);
        }

        response.sendRedirect("viewNote.html?id=" + noteIdToEdit);
    }
}
