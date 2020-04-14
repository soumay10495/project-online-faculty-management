package com.controller;

import com.service.FacultyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class DeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Integer id=Integer.valueOf(request.getParameter("id"));

        FacultyDao facdao=new FacultyDao();
        boolean flag = facdao.removeFaculty(id);

        if(flag)
            pw.println("Faculty with ID "+id+" has been removed");
        else
            pw.println("Operation failed");

        pw.println("<a href='index.jsp'>Back to home</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
