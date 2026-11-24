package com.jee.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopicMvcServlet", urlPatterns = {"/topics"})
public class TopicMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Topic> topics = List.of(
                new Topic(1, "Servlet Lifecycle & Filters", "Jakarta EE"),
                new Topic(2, "JSP Expression Language & JSTL", "Web Tier"),
                new Topic(3, "Hibernate SessionFactory & HQL", "ORM Layer")
        );
        req.setAttribute("topics", topics);
        req.getRequestDispatcher("/WEB-INF/views/topics.jsp").forward(req, resp);
    }
}
