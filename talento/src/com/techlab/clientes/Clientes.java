package com.techlab.clientes;
import java.util.Scanner;

public class Clientes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char value = scanner.next().charAt(0);
        

        System.out.println(value);

        scanner.close();
}
}