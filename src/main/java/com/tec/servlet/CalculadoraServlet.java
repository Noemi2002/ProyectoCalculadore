package com.tec.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Stack;

public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Nombre = request.getParameter("nombre");
        String Expresion = request.getParameter("operacion");

        //int valor1 = Integer.parseInt(Nombre);
        //int valor2 = Integer.parseInt(Expresion);

        try {
            response.getWriter().println("<html>");
            response.getWriter().println("<center>");
            response.getWriter().println("<head>");
            response.getWriter().println("<Title>El resultado es el siguiente</title>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");


            response.getWriter().println("Su nombre es: " + Nombre);
            response.getWriter().println("<br>La expresión a resolver es: " + Expresion);
           // response.getWriter().println("<br>El resultado de la expresión es: " + operacion);



            response.getWriter().println("</body>");
            response.getWriter().println("</center>");
            response.getWriter().println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
