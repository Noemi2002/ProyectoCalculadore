/**
 * Esta clase es la encargada de transformar el valor dado por el usuario a int y luego realizar las operaciones respectivas
 */
package com.tec.ResultadoOperacion;

import java.util.Stack;

public class Convertir {

    /**
     * Transforma la expresion de infija a postfija
     * @param exp
     * @return String
     */
    public static String getResultado(String exp) {

        final String ops = "-+/*^%";
        StringBuilder sb = new StringBuilder(); //Para ir concatenando varios String
        Stack<Integer> stack = new Stack<>(); // donde de van a ir guardado los datos

        for (String token : exp.split("\\s")) { //seleciona el primer elemento
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c); //Verifica que no sea un operador por medio de índices

// check for operator
            if (idx != -1) {
                //Si es un operador, lo añade al stack
                if (stack.isEmpty()) { //Si está vacía
                    stack.push(idx);
                } else {
                    while (!stack.isEmpty()) { //Si no está vacía
                        int prec2 = stack.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^')) { //Si se cumple alguno de estos se sabe que la operación tiene prioridad por lo cual la inserta
                            sb.append(ops.charAt(stack.pop())).append(' ');
                        }else break;
                    }
                    stack.push(idx);
                }
            } else if (c == '(') { //Evalua si hay parentesis
                stack.push(-2); // -2 equivale al '('
            } else if (c == ')') { //Evalua si hay parentesis
                while (stack.peek() != -2)
                    sb.append(ops.charAt(stack.pop())).append(' ');
                stack.pop();
            } else {
                sb.append(token).append(' '); //Añade el valor que tiene token, o el número al stack
            }
        }
        while (!stack.isEmpty())
            sb.append(ops.charAt(stack.pop())).append(' ');
        return sb.toString(); //Retorna la expresion en notación postfija
    }


    /**
     * Resuelve la expresión postfija
     * @param exp
     * @return String
     */
    public static String evaluarExpresion(String exp) {
        //create a stack
        Stack<Double> stack = new Stack<>(); //Se crea el stack
        char vacio = ' '; //Un espacio vacío por los espacios
        //Dos índices
        int i = 0;
        int index = 1;
        String num = ""; //String vacío en  el que se va a ir guadando los números


        // Revisa todos los caracteres, uno a uno
        while (i < exp.length()) {
            boolean prueba = false;
            char c = exp.charAt(i); //Primer dígito del elemento de la expresion postfija

            //Si hay espacio en blanco ignórelo
            if (c == vacio) {
                i += 1;

            } else {
                if (Character.isDigit(c)) { //Indcica si es número u operador
                    num = String.valueOf(c); //Lo guarda en una variable String
                    while (index < exp.length() && exp.charAt(index) != vacio) { //Si el número es de más dígitos los añade al String del número
                        num += exp.charAt(index);
                        index += 1;
                        prueba = true;

                    }
                    if (!prueba) { //El index siempre debe ser mayor a i
                        index += 1;
                    }
                    stack.push(Double.valueOf(num)); //Añade el número al stack

                    //Si el c es un operador en lugar de número
                } else {
                    //Obtiene los dos primero valores del stack
                    double val1 = stack.pop();
                    double val2 = stack.pop();

                    //Revisa cuál es el valor de c y realiza la operación respetiva
                    switch (c) {
                        case '+':
                            stack.push(val2 + val1);
                            index += 1;
                            break;

                        case '-':
                            stack.push(val2 - val1);
                            index += 1;
                            break;

                        case '/':
                            stack.push(val2 / val1);
                            index += 1;
                            break;

                        case '*':
                            stack.push(val2 * val1);
                            index += 1;
                            break;

                        case '%':
                            stack.push(val2 % val1);
                            index += 1;
                            break;

                        case '^':
                            stack.push(Math.pow(val2, val1));
                            index += 1;
                            break;
                    }
                }
                i += 2;

            }
            index += 1;

        }
        return String.valueOf(stack.pop()); //Retorna el resultado
    }


    //Casos de prueba
    //12 + 24 * ( 4 ^ 3 - 9 ) / ( 3 + 5 * 17 ) - 23
    //2 + 3 * 1 - 9
    //2 + 3 * 1 - 9
}
