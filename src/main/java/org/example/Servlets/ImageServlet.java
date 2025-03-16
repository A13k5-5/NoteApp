package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.Model;
import org.example.Model.ModelFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.logging.Logger;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imagePath = request.getPathInfo().substring(1);
        Model model = ModelFactory.getModel();

        try {
            String contentType = Files.probeContentType(new File("images", imagePath).toPath());
            response.setContentType(contentType);

            model.serveImage(imagePath, response.getOutputStream());
        } catch (FileNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}