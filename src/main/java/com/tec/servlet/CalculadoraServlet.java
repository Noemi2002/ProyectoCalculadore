/**
 * Esta clase se encarga de obtener los datos ingresados por el usuario para ser posteriormente guardados y analizados
 * para obtener el resultado correspondiente
 */
package com.tec.servlet;
import com.tec.ResultadoOperacion.Convertir;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CalculadoraServlet extends HttpServlet {

    /**
     * Se encarga de obtener los datos y hacer las llamadas respectivas a las otras clases
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Nombre = request.getParameter("nombre");
        String Expresion = request.getParameter("expresion");
        String Resultado = new Convertir().getResultado(Expresion);
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
            response.getWriter().println("<br>El resultado de la expresión es: " + Resultado);



            response.getWriter().println("</body>");
            response.getWriter().println("</center>");
            response.getWriter().println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
