package com.dstapen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.dstapen.TodoTuple.*;

/**
 * Health-check servlet for test purpose
 */
public class HealthCheckServlet extends HttpServlet{

    //TodoTuple c = null;

    Todo todo = Todo.newBuilder().setDescription("fdfd").setDone(false).build();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/plain");
        PrintWriter out = response.getWriter();
        out.println("It works");
    }
}
