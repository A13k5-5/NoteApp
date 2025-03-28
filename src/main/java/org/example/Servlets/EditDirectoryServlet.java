package org.example.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Classes.StorageItems.Directory;
import org.example.Exceptions.DirectoryNotFound;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/editDir")
public class EditDirectoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        long idToEdit = Long.parseLong(request.getParameter("dirId"));
        Directory toEdit = null;
        try {
            toEdit = model.findDir(idToEdit);
        } catch (DirectoryNotFound e) {
            request.setAttribute("message", e.getMessage());
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/error.jsp");
            dispatch.forward(request, response);
            return;
        }
        request.setAttribute("curDir", toEdit);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editDir.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newName = request.getParameter("name");
        long dirId = Long.parseLong(request.getParameter("dirId"));
        ModelFactory.getModel().changeDirName(dirId, newName);
        response.sendRedirect("/");
    }
}
