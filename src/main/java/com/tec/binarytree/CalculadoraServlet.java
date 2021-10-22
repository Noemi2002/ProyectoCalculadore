package com.tec.binarytree;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculadoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String Nombre = request.getParameter("nombre");
        String Expresion =  request.getParameter("operacion");

        try {
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<Title>El resultado es el siguiente</title>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");


            response.getWriter().println("Su nombre es: " + Nombre);
            response.getWriter().println("<br>Su correo: " + Expresion);


            response.getWriter().println("</body>");
            response.getWriter().println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

