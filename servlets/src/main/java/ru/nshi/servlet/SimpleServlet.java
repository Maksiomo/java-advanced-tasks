package ru.nshi.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author rassafel
 */
public class SimpleServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        LOG.info("Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Got request from {}", req.getServletPath());
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Hello</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        bufferedReader.lines().forEach(System.out::println);
    }

    @Override
    public void destroy() {
        super.destroy();
        LOG.info("Servlet destroyed");
    }
}
