/**
 * Esta clase se encarga de guardar en un archivo .csv un registros de las expresiones y sus resultados
 */
package com.tec.csvfile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

public class Registro {

    public static class Regi {
        public Regi(String nombre, Date fecha, String expresion) {

            try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\cmont\\Documents\\TEC\\Semestre 2\\Datos 1\\CSV\\test.csv"))) {

                StringBuilder sb = new StringBuilder();
                sb.append(nombre);
                sb.append(',');
                sb.append(fecha);
                sb.append(',');
                sb.append(expresion);
                sb.append('\n');

                writer.write(sb.toString());

                System.out.println("done!");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


