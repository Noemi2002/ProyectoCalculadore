/**
 * Esta clase es la encargada de transformar el valor dado por el usuario a int y luego realizar las operaciones respectivas
 */
package com.tec.ResultadoOperacion;

import com.tec.Registro;

public class Convertir {
        public static String getResultado(String operacion) {
            //String operacion="5*5+10-6";
            int tam = operacion.length();
            String A[] = new String[1000000]; //Array para guardar los operadores
            String operaciones[] = new String[1000000]; //Array para guardar los operandos
            int pos = 0;
            int sum = 0;
            String aux = "";

            operaciones[0] = "+";
            int index_operacion = 1;
            for(int i = 0; i<tam ; i++)
            {
                if(operacion.charAt(i) == '+' || operacion.charAt(i) == '-' || operacion.charAt(i) == '*' || operacion.charAt(i) == '/' || operacion.charAt(i) == '%')
                {
                    A[pos] = aux; //Aquí va guardando los números uno a uno
                    operaciones[index_operacion] = String.valueOf(operacion.charAt(i));
                    pos++;
                    index_operacion++;
                    aux = "";
                }
                else
                {
                    aux = aux + operacion.charAt(i);
                }
            }
            A[pos] = aux;
            pos++;

            for(int i = 0; i<pos ; i++)
            {

                //Obtiene el resultado
                if(operaciones[i].equals("+")){
                    sum = sum+Integer.parseInt(A[i]);
                }else if (operaciones[i].equals("-")){
                    sum=sum-Integer.parseInt(A[i]);
                }else if (operaciones[i].equals("/")){
                    sum=sum/Integer.parseInt(A[i]);
                }else if (operaciones[i].equals("*")){
                    sum= sum*Integer.parseInt(A[i]);

                }else if (operaciones[i].equals("%")){
                    sum=sum%Integer.parseInt(A[i]);
                }
            }
            //new Registro().guardarDatos(operacion, String.valueOf(sum)); //Llamada para que los datos se guarden en el archivo csv
            return String.valueOf(sum);

        }

    }