package com.black.jakarta_test2.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Persons", urlPatterns = "/sample.do", loadOnStartup = 1)
public class Sample extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
//        resp.sendRedirect("/persons/persons.jsp");
        req.getRequestDispatcher("/persons/persons.jsp").forward(req, resp);

        System.out.println("Address: " + req.getRemoteAddr());
        System.out.println("Host: " + req.getRemoteHost());
        System.out.println("Port: " + req.getRemotePort());

        System.out.println("URL: " + req.getRequestURL());
        System.out.println("URI: " + req.getRequestURI());
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}

