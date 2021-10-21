package ru.example.controller;

import ru.example.model.Student;
import ru.example.service.ListOfStudents;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double mark = Double.parseDouble(req.getParameter("mark"));
        String isBlockchain = req.getParameter("blockchain");
        if (isBlockchain != null) {
            ListOfStudents.addStudent(new Student(name, mark, true));
        } else {
            ListOfStudents.addStudent(new Student(name, mark, false));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        dispatcher.forward(req, resp);
    }
}
