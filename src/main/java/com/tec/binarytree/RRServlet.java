package com.tec.binarytree;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RRServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        PrintWriter pw= res.getWriter();
        res.setContentType("text/html");
        String user=req.getParameter("operacion");
        //String pass=req.getParameter("userPassword");
       // pw.println("Your operation is: ") ;
        //new RepuestaCliente(user);
        pw.println(user);
        pw.close();
    }
}