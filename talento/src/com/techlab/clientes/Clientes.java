package com.techlab.clientes;
import java.util.Scanner;

public class Clientes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean openMenu = true;

        while(openMenu){
            System.out.println("-- Menu --");
            System.out.println("1. Ingresar cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Consultar cliente");
            System.out.println("4. Modificar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");
            

            int option = validarInt(scanner,"Ingrese una opcion: ");

           switch (option) {
            case 1:
            System.out.println("opcion 1");
                break;
            case 2:
            System.out.println("opcion 2");
                break;
            case 3:
                System.out.println("opcion 3");
                break;
            case 4:
                System.out.println("opcion 4");
                break;
            case 5:
            System.out.println("opcion 5");
                break;
            case 0:
                System.out.println("\nSaliendo del sistema.");
                openMenu = false;
                break; 
            default:
                System.out.println("\nError: la opción ingresada no es válida.");
                
        } 
        }

        scanner.close();

}
  public static int validarInt(Scanner scanner, String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            return Integer.parseInt(scanner.nextLine());
         } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero entero valido.");
         }
     }
    
    }
 
}