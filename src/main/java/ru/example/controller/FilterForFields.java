package ru.example.controller;

import ru.example.service.ListOfStudents;

import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterForFields implements Filter {

    private static final String REGEX_DOUBLE = "[0-5](\\.[0-9]+)?";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String mark = servletRequest.getParameter("mark");
        servletResponse.setCharacterEncoding("UTF-8");

        if (name == null || mark == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if ("".equals(name) || "".equals(mark)) {
            servletRequest.setAttribute("errorMessage", "Пустые значения не допустимы");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/pages/errorPage.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (ListOfStudents.getNamesOfStudents().contains(name)) {
            servletRequest.setAttribute("errorMessage", "Студент с таким именем уже есть в списке");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/pages/errorPage.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (!mark.matches(REGEX_DOUBLE)) {
            servletRequest.setAttribute("errorMessage", "Недопустимое значение среднего балла");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/pages/errorPage.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
