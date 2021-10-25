package com.tec.ResultadoOperacion;

public class Convertir {
    public static void main(String[] args) {
        String operacion="5+5*10/2";
        int tam = operacion.length();
        String A[] = new String[100];
        //Array para almacenar operadores.
        String operaciones[] = new String[100];
        int pos = 0;
        int sum = 0;
        String aux = "";

        //inicializa primer operador.
        operaciones[0] = "+";
        int index_operacion = 1;
        for(int i = 0; i<tam ; i++)
        {
            if(operacion.charAt(i) == '+' || operacion.charAt(i) == '-' || operacion.charAt(i) == '*' || operacion.charAt(i) == '/' || operacion.charAt(i) == '%')
            {
                A[pos] = aux;
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

            //Determina la operación a realizar.
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
        System.out.println("=  "+sum);

    }
}
