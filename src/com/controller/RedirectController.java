package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RedirectController", urlPatterns = "/redirect")
public class RedirectController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        String op=request.getParameter("operation");

        if(op.equals("Add"))
            response.sendRedirect("add.jsp");
        else if(op.equals("Delete"))
            response.sendRedirect("delete.jsp");
        else if(op.equals("Update"))
            response.sendRedirect("update.jsp");
        else if(op.equals("Display"))
            response.sendRedirect("display");
        else
            pw.println("Error.....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
