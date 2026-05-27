
import java.util.ArrayList;
import java.util.Scanner;
import com.techlab.productos.model.Producto;
import com.techlab.productos.model.Categoria;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        precargarCategorias(categorias);
        
        boolean openMenu = true;

        while(openMenu){
            System.out.println("-- Menu --");
            System.out.println("1. Ingresar producto");
            System.out.println("2. Ver productos");
            System.out.println("3. Consultar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");

            int option = validarInt(scanner,"Ingrese una opcion: ");

           switch (option) {
            case 1:
                ingresarProducto(scanner, productos, categorias);
                break;
            case 2:
                mostrarProductos(scanner, productos);
                break;
            case 3:
                consultarProducto(scanner, productos);
                break;
            case 4:
                modificarProducto(scanner, productos);
                break;
            case 5:
                eliminarProducto(scanner, productos);
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

    //Hardcode de categorias
    public static void precargarCategorias(ArrayList<Categoria> categorias) {
        categorias.add(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
        categorias.add(new Categoria(2, "Periféricos", "Accesorios para computadora"));
        categorias.add(new Categoria(3, "Alimentos", "Productos alimenticios"));
        categorias.add(new Categoria(4, "Limpieza", "Artículos de limpieza del hogar"));
    }

    // METODO DE INGRESO PRODUCTOS
    public static void ingresarProducto(Scanner scanner, ArrayList<Producto> productos, ArrayList<Categoria> categorias){
        System.out.println("\n-- INGRESAR PRODUCTO --");
        int id = validarInt(scanner, "Ingrese el id del producto: ");

        if (buscarProductoId(productos, id) != null) {
            System.out.println("Error: ya existe un producto con ese id.");
            return;
        }

        String nombre = validarTexto(scanner, "Ingrese el nombre del producto: ");
        double precio = validarDouble(scanner, "Ingrese el precio del producto: ");

        mostrarCategorias(categorias);

        Categoria categoriaSeleccionada = pedirCategoriaExistente(scanner, categorias);

        Producto producto = new Producto(id, nombre, precio, categoriaSeleccionada);

        productos.add(producto);

        System.out.println("\nProducto ingresado correctamente.");
        System.out.println("\nPresionar una tecla para continuar...\n");
        scanner.nextLine();
    }

    // METODO DE LISTADO DE PRODUCTOS
    public static void mostrarProductos(Scanner scanner, ArrayList<Producto> productos) {

        System.out.println("\n\n-- LISTADO DE PRODUCTOS --");

        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos cargados.");
            System.out.println("\nPresionar una tecla para continuar...\n");
            scanner.nextLine();
            return;
        }

        for (Producto producto : productos) {
            // System.out.println(producto.getNombre());
            System.out.println(producto);

        }
    }

    // METODO DE CONSULTA
    public static void consultarProducto(Scanner scanner, ArrayList<Producto> productos) {

        System.out.println("\n-- CONSULTAR PRODUCTO --");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        int id = validarInt(scanner, "Ingrese el id del producto a consultar: ");

        Producto producto = buscarProductoId(productos, id);

        if (producto == null) {
            System.out.println("El producto no existe.");
        } else {
            System.out.println("producto encontrado:");
            System.out.println(producto);
        }
    }

    // METODO PARA MODIFICAR PRODUCTO
    public static void modificarProducto(Scanner scanner, ArrayList<Producto> productos) {

        System.out.println("\n--- MODIFICAR PRODUCTO ---\n");

        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        mostrarProductos(scanner, productos);

        int id = validarInt(scanner, "\nIngrese el id del producto a modificar: ");

        Producto producto = buscarProductoId(productos, id);

        if (producto == null) {
            System.out.println("\nEl producto no existe.");
            return;
        }

        String nuevoNombre = validarTexto(scanner, "Ingrese el nuevo nombre del producto: ");
        double nuevoPrecio = validarDouble(scanner, "Ingrese el nuevo precio del producto: ");

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);

        System.out.println("\nProducto modificado correctamente.");
        System.out.println("\nPresionar una tecla para continuar...\n");
            scanner.nextLine();
    }

    // METODO ELIMINAR PRODUCTO
    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> productos) {

        System.out.println("\n--- ELIMINAR PRODUCTO ---");

        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos cargados.");
            return;
        }

        mostrarProductos(scanner, productos);

        int id = validarInt(scanner, "Ingrese el id del producto a eliminar: ");

        Producto producto = buscarProductoId(productos, id);

        if (producto == null) {
            System.out.println("El producto no existe.");
            return;
        }

        productos.remove(producto);

        System.out.println("Producto eliminado correctamente.");
        System.out.println("\nPresionar una tecla para continuar...\n");
            scanner.nextLine();
    }

    /* METODOS DE VALIDACION */

    public static Producto buscarProductoId(ArrayList<Producto> productos, int id) {

        for (Producto producto : productos) {
            if (producto.getID() == id) {
                return producto;
            }
        }

        return null;
    }

    // METODOS DE CATEGORIAS
    public static void mostrarCategorias(ArrayList<Categoria> categorias) {
        System.out.println("\n-- CATEGORIAS DISPONIBLES --");

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public static Categoria buscarCategoriaId(ArrayList<Categoria> categorias, int id) {

        for (Categoria categoria : categorias) {
            if (categoria.getID() == id) {
                return categoria;
            }
        }

        return null;
    }

    //CHECKEO DE IMPUTS
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

     public static double validarDouble(Scanner scanner, String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                double value = Double.parseDouble(scanner.nextLine());

                if (value < 0) {
                    System.out.println("Error: el precio no puede ser negativo.");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero valido.");
            }
        }
    }

    public static String validarTexto(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("Error: debe ingresar un texto.");
        }
    }

     public static Categoria pedirCategoriaExistente(Scanner scanner, ArrayList<Categoria> categorias) {

        while (true) {
            int codigoCategoria = validarInt(scanner, "Ingrese el código de la categoría: ");

            Categoria categoria = buscarCategoriaId(categorias, codigoCategoria);

            if (categoria != null) {
                return categoria;
            }

            System.out.println("Error: la categoría no existe.");
        }
    }
}
