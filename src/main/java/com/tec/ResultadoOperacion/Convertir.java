/**
 * Esta clase es la encargada de transformar el valor dado por el usuario a int y luego realizar las operaciones respectivas
 */
package com.tec.ResultadoOperacion;

import java.util.Stack;

public class Convertir{

    public static String getResultado(String exp){
        final String ops = "-+/*^";

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (String token : exp.split("\\s")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

// check for operator
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);

                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            }
            else if (c == '(') {
                s.push(-2); // -2 stands for '('
            }
            else if (c == ')') {
// until '(' on stack, pop operators.
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            }
            else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append(' ');
        String evaluacion;
        return sb.toString();
        //System.out.println(sb.toString());

    }


    public static String evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Double> stack=new Stack<>();
        char vacio = ' ';
        int i = 0;
        int index = 1;
        String num = "";


        // Scan all characters one by one
        while (i < exp.length()) {
            boolean prueba = false;
            char c = exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.

            if (c == vacio) {
                i += 1;
            } else {
                if (Character.isDigit(c)) {
                    num = String.valueOf(c);
                    while (index < exp.length() && exp.charAt(index) != vacio) {
                        num += exp.charAt(index);
                        index += 1;
                        prueba = true;

                    }
                    if (!prueba){
                        index += 1;
                    }
                    stack.push(Double.valueOf(num));
                    //num = "";



                    //  If the scanned character is an operator, pop two
                    // elements from stack apply the operator
                }else {
                    double val1 = stack.pop();
                    double val2 = stack.pop();

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
        return String.valueOf(stack.pop());
    }


    // Driver method
   /* public static void main(String[] args)
    {
        String exp = "12 + 24 * ( 4 ^ 3 - 9 ) / ( 3 + 5 * 17 ) - 23 ";//"2 + 3 * 1 - 9";
        //"12+24*(4^3-9)/(3+5*17)-23";

        // String exp="231*+9-";
        double result = new Test().infixToPostfix(exp);
        System.out.println(result);





    }*/
}