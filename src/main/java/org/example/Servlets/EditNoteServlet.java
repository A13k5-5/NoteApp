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
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.File;
import java.io.IOException;
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
        request.setAttribute("noteToEdit", model.find(idToEdit));
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editNote.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newTitle = request.getParameter("title");
        long noteIdToEdit = Long.parseLong(request.getParameter("noteId"));
        Model model = ModelFactory.getModel();

        request.getParameterMap().forEach((paramName, paramValues) -> {
            if (paramName.startsWith("content_")) {
                long contentIdToEdit = Long.parseLong(paramName.substring(8));
                String newContent = paramValues[0];
                model.editNote(noteIdToEdit, contentIdToEdit, newContent, newTitle);
            }
        });

        for (Part part : request.getParts()) {
            if (part.getName().startsWith("img_") && part.getSize() > 0) {
                long contentIdToEdit = Long.parseLong(part.getName().substring(4));
                model.editNote(noteIdToEdit, contentIdToEdit, part);
            }
        }
        response.sendRedirect("viewNote.html?id=" + noteIdToEdit);
    }
}
