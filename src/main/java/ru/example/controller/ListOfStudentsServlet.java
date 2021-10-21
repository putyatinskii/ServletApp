package ru.example.controller;

import ru.example.model.Student;
import ru.example.service.ListOfStudents;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListOfStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = resp.getWriter();
        String isBlockchain = req.getParameter("isBlockchain");
        String isGenius = req.getParameter("isGenius");

        List<Student> listOfStudents;
        if (isBlockchain != null) {
            listOfStudents = ListOfStudents.getBlockchain();
        } else if (isGenius != null) {
            listOfStudents = ListOfStudents.getListOfGeniuses();
        } else {
            listOfStudents = ListOfStudents.getList();
        }

        printWriter.write("<h1 align=\"center\">Список студентов: </h1>");

        for (Student s: listOfStudents){
            printWriter.write(s.toString() + "<br/>");
        }
        printWriter.write("<form action=\"add-student\" method=\"get\">");
        printWriter.write("<hr>");
        printWriter.write("<input type=\"submit\" value=\"Вернуться не предыдущую страницу\" />");
        printWriter.write("</form>");

    }
}
