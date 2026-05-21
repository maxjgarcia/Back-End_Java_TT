package com.backend.productos;
import java.util.Scanner;

public class Productos {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        int option = 0;

        while(option != 4){
            System.out.println("ingresar una opcion");
            option = scanner.nextInt();

           switch (option) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                break;
            default:
                break;
        } 
        }


        scanner.close();
    }
}



