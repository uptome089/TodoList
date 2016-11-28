package com.example.myproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import java.util.*;
import javax.jdo.*;


@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("i");
        PrintWriter out = resp.getWriter();
        List<ToDoObject> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + ToDoObject.class.getName();
            try {
                list = (List<ToDoObject>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
            	ToDoObject data = (ToDoObject)manager.getObjectById(ToDoObject.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
			String res = "[";
	        if (list != null){
	            for(ToDoObject data:list){
	                res += "{id:" + data.getId() + ",title:'" + data.getTitle() + "',desc:'" +
	                    data.getDesc() + "',target:'" + data.getTarget() +
	                    "',from_date:'" + data.getFromDate() + 
	                    "',to_date:'" + data.getToDate() +
	                    "',isDone:'" + data.getIsDone() +"'},";
	            }
	        }
	        res += "]";
			out.println(res);
			manager.close();
	}
}
