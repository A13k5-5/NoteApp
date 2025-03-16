package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        long idToDelete = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        if (type.equals("note"))
            model.deleteNote(idToDelete);
        else if(type.equals("dir"))
            model.deleteDir(idToDelete);
        response.sendRedirect("notes.html");
    }
}
