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
import java.util.ArrayList;

@WebServlet(name = "DisplayController", urlPatterns = "/display")
public class DisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Faculty> facs;

        FacultyDao facdao=new FacultyDao();
        facs=facdao.displayFaculty();

        request.setAttribute("result", facs);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
