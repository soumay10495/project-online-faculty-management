package com.controller;

import com.bean.Faculty;
import com.service.FacultyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "add", urlPatterns = "/add")
public class AddController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Faculty fac=new Faculty();

        fac.setName(request.getParameter("name"));
        fac.setAddress(request.getParameter("address"));
        fac.setStream(request.getParameter("stream"));
        fac.setSalary(Double.valueOf(request.getParameter("salary")));
        fac.setYears_of_experience(Integer.valueOf(request.getParameter("years")));
        fac.setPhoneno(Long.valueOf(request.getParameter("phone")));
        fac.setGrade(request.getParameter("grade"));

        FacultyDao facDao=new FacultyDao();
        boolean flag = facDao.addFaculty(fac);

        response.setContentType("text/html");
        PrintWriter pw= response.getWriter();

        if(flag)
            pw.println("Faculty has been added");
        else
            pw.println("Operation failed");

        pw.println("<a href='index.jsp'>Back to home</a>");
    }
}
