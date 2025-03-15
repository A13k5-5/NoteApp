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

import java.io.IOException;

@WebServlet("/editNote.html")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,  // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
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
        String newTitle = request.getParameter("title");
        long noteIdToEdit = Long.parseLong(request.getParameter("noteId"));
        Model model = ModelFactory.getModel();

        // Handle text contents
        request.getParameterMap().forEach((paramName, paramValues) -> {
            if (paramName.startsWith("content_")) {
                long contentIdToEdit = Long.parseLong(paramName.substring(8));
                String newContent = paramValues[0];
                model.editNote(noteIdToEdit, contentIdToEdit, newContent, newTitle);
            }
        });

        // Handle file uploads
        for (Part part : request.getParts()) {
            if (part.getName().startsWith("content_") && part.getSize() > 0) {
                long contentIdToEdit = Long.parseLong(part.getName().substring(8));
                byte[] imageData = part.getInputStream().readAllBytes();
                model.editNote(noteIdToEdit, contentIdToEdit, imageData, newTitle);
            }
        }

        response.sendRedirect("notes.html");
    }
}
