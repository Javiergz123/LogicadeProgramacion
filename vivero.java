import java.util.Scanner;

public class vivero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        String[] productos = {"Cactus", "Suculenta", "Maceta", "Tierra", "Fertilizante"};
        double[] precios = {45.5, 35.5, 60, 80, 95};

        // Matriz que almacena las ventas de los productos
        double[][] ventas = new double[5][6];

        // Registro de las cantidades vendidas
        for (int dia = 0; dia < dias.length; dia++) {

            System.out.println("\nDía: " + dias[dia]);

            for (int producto = 0; producto < productos.length; producto++) {

                System.out.print("Cantidad vendida de " + productos[producto] + ": ");
                int cantidad = sc.nextInt();

                ventas[producto][dia] = cantidad * precios[producto];
            }
        }

        // Presentación del reporte
        System.out.println("\n===== REPORTE DE VENTAS =====");

        System.out.printf("%-14s", "Producto");

        for (String dia : dias) {
            System.out.printf("%12s", dia);
        }

        System.out.println();

        // Mostrar los importes de cada producto
        for (int producto = 0; producto < productos.length; producto++) {

            System.out.printf("%-14s", productos[producto]);

            for (int dia = 0; dia < dias.length; dia++) {
                System.out.printf("%12.2f", ventas[producto][dia]);
            }

            System.out.println();
        }

        sc.close();
    }
}
