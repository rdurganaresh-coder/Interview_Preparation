package com.jee.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "Candidate";
        }

        HttpSession session = req.getSession(true);
        Integer visits = (Integer) session.getAttribute("visits");
        visits = (visits == null) ? 1 : visits + 1;
        session.setAttribute("visits", visits);

        try (PrintWriter out = resp.getWriter()) {
            out.printf("{\"message\":\"Hello, %s!\",\"sessionVisits\":%d,\"port\":8401}%n", name, visits);
        }
    }
}
