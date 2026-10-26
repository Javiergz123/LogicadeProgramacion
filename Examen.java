import java.util.Scanner;
import java.util.ArrayList;

public class Examen {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18, 12, 25, 15};
        int[] vendidos = new int[4];

        ArrayList<String> clientes = new ArrayList<String>();

        int cantidadClientes;
        double totalGeneral = 0;

        System.out.print("Cantidad de clientes: ");
        cantidadClientes = leer.nextInt();
        leer.nextLine();

        while (cantidadClientes <= 0) {
            System.out.print("Ingrese una cantidad mayor que cero: ");
            cantidadClientes = leer.nextInt();
            leer.nextLine();
        }

        for (int i = 0; i < cantidadClientes; i++) {

            System.out.print("\nNombre del cliente: ");
            String nombre = leer.nextLine();
            clientes.add(nombre);

            double totalCompra = 0;
            char respuesta = 'S';

            while (respuesta == 'S' || respuesta == 's') {

                System.out.println("\nCATALOGO DE PRODUCTOS");

                for (int j = 0; j < 4; j++) {
                    System.out.println((j + 1) + ". " + productos[j]
                            + " - $" + precios[j]);
                }

                System.out.print("Codigo del producto (1-4): ");
                int codigo = leer.nextInt();

                while (codigo < 1 || codigo > 4) {
                    System.out.print("Codigo incorrecto. Ingrese del 1 al 4: ");
                    codigo = leer.nextInt();
                }

                int posicion = 0;

                switch (codigo) {
                    case 1:
                        posicion = 0;
                        break;
                    case 2:
                        posicion = 1;
                        break;
                    case 3:
                        posicion = 2;
                        break;
                    case 4:
                        posicion = 3;
                        break;
                }

                System.out.print("Cantidad que desea comprar: ");
                int cantidad = leer.nextInt();

                while (cantidad <= 0) {
                    System.out.print("Ingrese una cantidad mayor que cero: ");
                    cantidad = leer.nextInt();
                }

                double importe = precios[posicion] * cantidad;

                totalCompra = totalCompra + importe;
                vendidos[posicion] = vendidos[posicion] + cantidad;

                System.out.println("Importe: $" + importe);

                System.out.print("Desea comprar otro producto? (S/N): ");
                respuesta = leer.next().charAt(0);

                while (respuesta != 'S' && respuesta != 's'
                        && respuesta != 'N' && respuesta != 'n') {
                    System.out.print("Ingrese S o N: ");
                    respuesta = leer.next().charAt(0);
                }
            }

            totalGeneral = totalGeneral + totalCompra;

            System.out.println("\nRESUMEN DEL CLIENTE");
            System.out.println("Nombre: " + nombre);
            System.out.println("Total de compra: $" + totalCompra);

            leer.nextLine();
        }

        System.out.println("\n===== REPORTE FINAL =====");

        System.out.println("Clientes atendidos: " + clientes.size());

        System.out.println("\nLISTA DE CLIENTES");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }

        System.out.println("\nPRODUCTOS VENDIDOS");

        for (int i = 0; i < 4; i++) {

            double importeBruto = vendidos[i] * precios[i];

            System.out.println("Producto: " + productos[i]);
            System.out.println("Precio: $" + precios[i]);
            System.out.println("Cantidad vendida: " + vendidos[i]);
            System.out.println("Importe bruto: $" + importeBruto);
            System.out.println();
        }

        double promedio = totalGeneral / clientes.size();

        System.out.println("Total recaudado: $" + totalGeneral);
        System.out.println("Promedio de venta por cliente: $" + promedio);

        leer.close();
    }
}