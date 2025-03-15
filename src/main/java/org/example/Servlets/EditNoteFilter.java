package org.example.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter("/editNote.html")
//public class EditNoteFilter implements Filter {
////    @Override
////    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
////        HttpServletRequest request = (HttpServletRequest) servletRequest;
////        HttpServletResponse response = (HttpServletResponse) servletResponse;
////
////        if (request.getParameter("noteId") == null || request.getParameter("id").isEmpty()) {
//////            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or empty id parameter");
////            response.sendRedirect("/notes.html");
////            return;
////        }
////        filterChain.doFilter(servletRequest, servletResponse);
////    }
//}
