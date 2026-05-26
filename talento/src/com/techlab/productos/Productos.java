package com.techlab.productos;
import java.util.Scanner;

public class Productos {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        boolean openMenu = true;

        while(openMenu){
            System.out.println("ingresar una opcion");
            int option = scanner.nextInt();

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
                openMenu = false;
                break; 
            default:
                break;
        } 
        }


        scanner.close();
    }
}



