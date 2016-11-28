package com.example.myproject;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditToDoDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        String target = req.getParameter("target");
        String from_date = req.getParameter("from_date");
        String to_date = req.getParameter("to_date");
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        
        ToDoObject data = (ToDoObject)manager.getObjectById(ToDoObject.class,id);
        data.setTitle(title);
        data.setDesc(desc);
        data.setTarget(target);
        data.setFromDate(from_date);
        data.setToDate(to_date);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}
