package com.example.myproject;

import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class FindDataServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("find");
        PrintWriter out = resp.getWriter();
        List<ToDoObject> list = null;
        
        Query query = manager.newQuery(ToDoObject.class);
        
        query.setFilter("title == findTitle");
        query.setOrdering("from_date desc");
        query.declareParameters("String findTitle");
        try {
            list = (List<ToDoObject>)query.execute(param1);
        } catch(JDOObjectNotFoundException e){}
        String res = "[";
        if (list != null){
            for(ToDoObject data:list){
                res += "{id:" + data.getId() + ",title:'" + data.getTitle() + "',desc:'" +
                    data.getDesc() + "',fromDate:'" + data.getFromDate() +
                    "',toDate:'" + data.getToDate() + ",target:'" + data.getTarget() +"'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}
