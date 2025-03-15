package org.example.Servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Classes.StorageItems.Note;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

@WebServlet("/notes.html")
public class NotesPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        request.setAttribute("contents", model.getCurDir());
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/notes.jsp");
        dispatch.forward(request, response);
    }
}
