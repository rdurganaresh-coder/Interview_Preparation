package com.jee.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*")
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest httpReq = (HttpServletRequest) request;
        chain.doFilter(request, response);
        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("[ServletFilter] %s %s completed in %d ms%n",
                httpReq.getMethod(), httpReq.getRequestURI(), elapsed);
    }
}
