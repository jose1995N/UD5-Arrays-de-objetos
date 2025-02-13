public class pruebaArticulo {
    public static void main(String[] args) {
        articulo[] arrayArticulo = new articulo[3];
        arrayArticulo[0] = new articulo("T001", "Teclado Logitech K860");
        arrayArticulo[1] = new articulo("T002", "Mouse inalámbrico Razer");
        arrayArticulo[2] = new articulo("T003", "Auriculares Sony WH-1000XM4");

        
        arrayArticulo[0].setPrecioCompra(100);
        arrayArticulo[0].setPrecioVenta(150);
        arrayArticulo[0].setStock(20);

        arrayArticulo[1].setPrecioCompra(50);
        arrayArticulo[1].setPrecioVenta(80);
        arrayArticulo[1].setStock(15);

        arrayArticulo[2].setPrecioCompra(250);
        arrayArticulo[2].setPrecioVenta(350);
        arrayArticulo[2].setStock(10);

        
        for (articulo articulo : arrayArticulo) {
            articulo.mostrarArticulo();
            System.out.println("--------------------");
        }
    }
}
