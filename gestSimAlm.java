import java.util.Scanner;
public class gestSimAlm {

    private static articulo[] almacen;
    private static int numArticulos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        almacen = new articulo[10]; // El tamaño máximo del almacén es 10 artículos
        numArticulos = 0;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("0. Entrada automatizada (creará 4 artículos de prueba del programa)");
            System.out.println("1. Listado (Mostrará todos los datos de los artículos del almacén)");
            System.out.println("2. Alta (Creará un nuevo artículo en el almacén)");
            System.out.println("3. Baja (Dará de baja un artículo en el almacén)");
            System.out.println("4. Entrada de mercancía (Aumentará el stock de un determinado artículo)");
            System.out.println("5. Salida de mercancía (Disminuirá el stock de un determinado artículo)");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 0:
                    entradaAutomatizada();
                    break;
                case 1:
                    lista();
                    break;
                case 2:
                    alta(sc);
                    break;
                case 3:
                    baja(sc);
                    break;
                case 4:
                    entradaMercancia(sc);
                    break;
                case 5:
                    salidaMercancia(sc);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // a. Entrada automatizada: crea 4 artículos de prueba
    public static void entradaAutomatizada() {
        articulo articulo1 = new articulo("A001", "Laptop HP");
        articulo1.setPrecioCompra(500);
        articulo1.setPrecioVenta(750);
        articulo1.setStock(10);
        almacen[numArticulos++] = articulo1;

        articulo articulo2 = new articulo("A002", "Mouse Logitech");
        articulo2.setPrecioCompra(20);
        articulo2.setPrecioVenta(35);
        articulo2.setStock(50);
        almacen[numArticulos++] = articulo2;

        articulo articulo3 = new articulo("A003", "Monitor Samsung");
        articulo3.setPrecioCompra(150);
        articulo3.setPrecioVenta(250);
        articulo3.setStock(30);
        almacen[numArticulos++] = articulo3;

        articulo articulo4 = new articulo("A004", "Teclado Razer");
        articulo4.setPrecioCompra(100);
        articulo4.setPrecioVenta(150);
        articulo4.setStock(20);
        almacen[numArticulos++] = articulo4;

        System.out.println("Se han creado 4 artículos de prueba.");
    }

    // b. Lista: Muestra todos los artículos del almacén
    public static void lista() {
        if (numArticulos == 0) {
            System.out.println("No hay artículos en el almacén.");
        } else {
            System.out.println("\nListado de artículos:");
            for (int i = 0; i < numArticulos; i++) {
                System.out.println(almacen[i]);
            }
        }
    }

    // c. Alta: Crea un nuevo artículo
    public static void alta(Scanner sc) {
        if (numArticulos >= almacen.length) {
            System.out.println("No hay espacio suficiente para más artículos.");
            return;
        }

        System.out.print("Ingrese el código del artículo: ");
        String codigo = sc.nextLine();

        System.out.print("Ingrese la descripción del artículo: ");
        String descripcion = sc.nextLine();

        System.out.print("Ingrese el precio de compra: ");
        double precioCompra = sc.nextDouble();

        System.out.print("Ingrese el precio de venta: ");
        double precioVenta = sc.nextDouble();

        System.out.print("Ingrese el stock: ");
        int stock = sc.nextInt();

        articulo nuevoArticulo = new articulo(codigo, descripcion);
        nuevoArticulo.setPrecioCompra(precioCompra);
        nuevoArticulo.setPrecioVenta(precioVenta);
        nuevoArticulo.setStock(stock);

        almacen[numArticulos++] = nuevoArticulo;
        System.out.println("Nuevo artículo agregado al almacén.");
    }

    // d. Baja: Elimina un artículo del almacén
    public static void baja(Scanner sc) {
        System.out.print("Ingrese el código del artículo a dar de baja: ");
        String codigo = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < numArticulos; i++) {
            if (almacen[i].getCodigo().equals(codigo)) {
                for (int j = i; j < numArticulos - 1; j++) {
                    almacen[j] = almacen[j + 1]; // Mover los elementos hacia adelante
                }
                almacen[--numArticulos] = null; // Reducir el tamaño y limpiar la última posición
                System.out.println("Artículo dado de baja.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Artículo no encontrado.");
        }
    }

    // e. Entrada de mercancía: Aumenta el stock de un artículo
    public static void entradaMercancia(Scanner sc) {
        System.out.print("Ingrese el código del artículo al que desea aumentar el stock: ");
        String codigo = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < numArticulos; i++) {
            if (almacen[i].getCodigo().equals(codigo)) {
                System.out.print("Ingrese la cantidad a añadir: ");
                int cantidad = sc.nextInt();
                almacen[i].setStock(almacen[i].getStock() + cantidad);
                System.out.println("Stock actualizado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Artículo no encontrado.");
        }
    }

    // f. Salida de mercancía: Disminuye el stock de un artículo
    public static void salidaMercancia(Scanner sc) {
        System.out.print("Ingrese el código del artículo al que desea disminuir el stock: ");
        String codigo = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < numArticulos; i++) {
            if (almacen[i].getCodigo().equals(codigo)) {
                System.out.print("Ingrese la cantidad a retirar: ");
                int cantidad = sc.nextInt();
                if (cantidad <= almacen[i].getStock()) {
                    almacen[i].setStock(almacen[i].getStock() - cantidad);
                    System.out.println("Stock actualizado.");
                } else {
                    System.out.println("No hay suficiente stock.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Artículo no encontrado.");
        }
    }
}

