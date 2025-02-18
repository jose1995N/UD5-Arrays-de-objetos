import java.util.Scanner;


class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    // Método para mostrar información del autor
    public String mostrarDatos() {
        return "Autor: " + nombre + " | Nacionalidad: " + nacionalidad;
    }
}

// Clase Libro
class Libro {
    private String codigo;
    private String titulo;
    private Autor autor;

    // Constructor
    public Libro(String codigo, String titulo, Autor autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Métodos getter
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    // Método para mostrar información del libro
    public String mostrarDatos() {
        return "Código: " + codigo + " | Título: " + titulo + " | " + autor.mostrarDatos();
    }
}

// Clase Biblioteca
class Biblioteca {
    private Libro[] libros;
    private Autor[] autores;
    private int contadorLibros;
    private int contadorAutores;

    // Constructor
    public Biblioteca(int capacidadLibros, int capacidadAutores) {
        libros = new Libro[capacidadLibros];
        autores = new Autor[capacidadAutores];
        contadorLibros = 0;
        contadorAutores = 0;
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        if (contadorLibros < libros.length) {
            libros[contadorLibros++] = libro;
        } else {
            System.out.println("No se pueden agregar más libros.");
        }
    }

    // Método para agregar un autor
    public void agregarAutor(Autor autor) {
        if (contadorAutores < autores.length) {
            autores[contadorAutores++] = autor;
        } else {
            System.out.println("No se pueden agregar más autores.");
        }
    }

    // Método para obtener el array de autores
    public Autor[] getAutores() {
        return autores;
    }

    // Método para mostrar todos los libros
    public void mostrarLibros() {
        System.out.println("\nListado de libros:");
        for (int i = 0; i < contadorLibros; i++) {
            System.out.println(libros[i].mostrarDatos());
        }
    }

    // Método para mostrar todos los autores
    public void mostrarAutores() {
        System.out.println("\nListado de autores:");
        for (int i = 0; i < contadorAutores; i++) {
            System.out.println(autores[i].mostrarDatos());
        }
    }
}

// Clase principal con el método main
public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca(10, 5);

        // Ingresar autores
        System.out.println("Ingrese el número de autores que desea agregar:");
        int numAutores = scanner.nextInt();
        scanner.nextLine();  // Consumir la línea pendiente

        for (int i = 0; i < numAutores; i++) {
            System.out.println("\nIngrese los datos del autor #" + (i + 1) + ":");
            System.out.print("Nombre del autor: ");
            String nombreAutor = scanner.nextLine();
            System.out.print("Nacionalidad del autor: ");
            String nacionalidadAutor = scanner.nextLine();

            Autor autor = new Autor(nombreAutor, nacionalidadAutor);
            biblioteca.agregarAutor(autor);
        }

        // Ingresar libros
        System.out.println("\nIngrese el número de libros que desea agregar:");
        int numLibros = scanner.nextInt();
        scanner.nextLine();  // Consumir la línea pendiente

        for (int i = 0; i < numLibros; i++) {
            System.out.println("\nIngrese los datos del libro #" + (i + 1) + ":");
            System.out.print("Código del libro: ");
            String codigoLibro = scanner.nextLine();
            System.out.print("Título del libro: ");
            String tituloLibro = scanner.nextLine();
            System.out.print("Ingrese el índice del autor (0 para el primer autor, 1 para el segundo, etc.): ");
            int indiceAutor = scanner.nextInt();
            scanner.nextLine();  // Consumir la línea pendiente

            Autor[] autores = biblioteca.getAutores();  // Obtener los autores desde el método
            if (indiceAutor >= 0 && indiceAutor < autores.length) {
                Autor autorLibro = autores[indiceAutor];
                Libro libro = new Libro(codigoLibro, tituloLibro, autorLibro);
                biblioteca.agregarLibro(libro);
            } else {
                System.out.println("Índice de autor inválido.");
            }
        }

        // Mostrar los datos ingresados
        biblioteca.mostrarAutores();
        biblioteca.mostrarLibros();

        scanner.close();
    }
}

