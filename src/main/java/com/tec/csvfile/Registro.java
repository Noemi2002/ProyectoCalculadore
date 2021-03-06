/**
 * Esta clase se encarga de guardar en un archivo .csv un registros de las expresiones y sus resultados
 */
package com.tec.csvfile;

import java.io.*;
import java.util.*;



public class Registro {

    public static class Regi {
        public Regi(String nombre, Date fecha, String postfija, String resultado) {
            try (PrintWriter writer = new PrintWriter(new File(
                    "C:\\Users\\cmont\\Documents\\TEC\\Semestre 2\\Datos 1\\CSV\\test.csv"))) {

                StringBuilder sb = new StringBuilder();


                sb.append(nombre);
                sb.append(',');
                sb.append(fecha);
                sb.append(',');
                sb.append(postfija);
                sb.append(',');
                sb.append(resultado);
                sb.append('\n');


                writer.write(sb.toString());

                System.out.println("done!");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



