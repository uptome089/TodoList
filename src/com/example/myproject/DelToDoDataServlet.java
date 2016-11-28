package com.example.myproject;

import java.io.IOException;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class DelToDoDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        ToDoObject data = (ToDoObject)manager.getObjectById(ToDoObject.class,id);
        manager.deletePersistent(data);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}
