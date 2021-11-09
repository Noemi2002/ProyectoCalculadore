/**
 * Esta clase se encarga de obtener los datos ingresados por el usuario para ser posteriormente guardados y analizados
 * para obtener el resultado correspondiente
 */
package com.tec.servlet;
import com.tec.ResultadoOperacion.Convertir;
import com.tec.csvfile.Registro;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


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
        Convertir evaluar = new Convertir(); //Instancia de la clase que evalua la expresion

        //Se guardan en variables lo que el cliente ingresó
        String Nombre = request.getParameter("nombre");
        String Expresion = request.getParameter("expresion");

        //Se obtiene la expresión en notación postfija y el resultado de la misma
        String Postfija = evaluar.getResultado(Expresion);
        String Resultado = evaluar.evaluarExpresion(Postfija);

        Date Fecha = new Date(); //Se obtiene la fecha
        new Registro.Regi(Nombre, Fecha, Postfija, Resultado); //Se hace el registro


        //Mostrar los resultados
        try {
            response.getWriter().println("<html>");
            response.getWriter().println("<center>");
            response.getWriter().println("<head>");
            response.getWriter().println("<h3>");
            //response.getWriter().println("<Title>Resultados</title><p>");
            response.getWriter().println("<font color=\"#000000\" size=\"4\" face=\"Comic Sans MS, Arial, MS Sans Serif\">\n" +
                    "                    Resultados</font><p>");
            response.getWriter().println("<h3>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<form>");


            response.getWriter().println("<br>Su nombre es: " + Nombre + "<p>");
            response.getWriter().println("<br>La fecha es: " + Fecha + "<p>");
            response.getWriter().println("<br>La expresión a resolver es en notación infija es: " + Expresion +"<p>");
            response.getWriter().println("<br>La expresión a resolver es en notación postfija es: " + Postfija +"<p>");
            response.getWriter().println("<br>El resultado de la expresión es: " + Resultado);
            response.getWriter().println("</form>");


            response.getWriter().println("</body>");
            response.getWriter().println("</center>");
            response.getWriter().println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
