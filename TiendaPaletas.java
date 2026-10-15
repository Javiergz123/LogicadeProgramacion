import java.util.Scanner;

public class TiendaPaletas {

    // Precios de las paletas
    private static final double PRECIO_FRESA = 15.0;
    private static final double PRECIO_LIMON = 12.0;
    private static final double PRECIO_COCO = 18.0;

    // Registros de ventas por día: [Día 1 / Día 2][Fresa / Limón / Coco]
    // Fresa = Índice 0, Limón = Índice 1, Coco = Índice 2
    private static int[][] ventas = new int[2][3];

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== REGISTRO INICIAL DE VENTAS ===");
        registrarVentasDia(0); // Registro Día 1
        registrarVentasDia(1); // Registro Día 2

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    mostrarResumenTotal();
                    break;
                case 2:
                    consultarDiaEspecifico();
                    break;
                case 3:
                    modificarRegistro();
                    break;
                case 4:
                    borrarRegistroTotal();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el sistema de ventas de paletas!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);
    }

    // Método para mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("==========================================");
        System.out.println("       TIENDA DE PALETAS DE HIELO        ");
        System.out.println("==========================================");
        System.out.println("1. Ver resumen total acumulado (Día 1 y Día 2)");
        System.out.println("2. Consultar detalle de un día específico");
        System.out.println("3. Modificar registro de un día");
        System.out.println("4. Borrar todos los registros de ventas");
        System.out.println("5. Salir");
        System.out.println("==========================================");
    }

    // Método para ingresar las ventas de un día
    private static void registrarVentasDia(int diaIndex) {
        System.out.println("\n--- Ingreso de ventas para el DÍA " + (diaIndex + 1) + " ---");
        ventas[diaIndex][0] = leerEntero("Paletas de Fresa ($15): ");
        ventas[diaIndex][1] = leerEntero("Paletas de Limón ($12): ");
        ventas[diaIndex][2] = leerEntero("Paletas de Coco ($18): ");
    }

    // Método para mostrar el resumen total de ambos días
    private static void mostrarResumenTotal() {
        int totalFresa = ventas[0][0] + ventas[1][0];
        int totalLimon = ventas[0][1] + ventas[1][1];
        int totalCoco = ventas[0][2] + ventas[1][2];

        int totalPaletas = totalFresa + totalLimon + totalCoco;

        double montoFresa = totalFresa * PRECIO_FRESA;
        double montoLimon = totalLimon * PRECIO_LIMON;
        double montoCoco = totalCoco * PRECIO_COCO;

        double totalDinero = montoFresa + montoLimon + montoCoco;

        System.out.println("--- RESUMEN TOTAL DE VENTAS (DÍA 1 + DÍA 2) ---");
        System.out.println("Paletas de Fresa vendidas: " + totalFresa + " (Monto: $" + montoFresa + ")");
        System.out.println("Paletas de Limón vendidas: " + totalLimon + " (Monto: $" + montoLimon + ")");
        System.out.println("Paletas de Coco vendidas:  " + totalCoco + " (Monto: $" + montoCoco + ")");
        System.out.println("----------------------------------------------");
        System.out.println("Cantidad TOTAL de paletas vendidas: " + totalPaletas);
        System.out.println("Suma TOTAL de valor recaudado:     $" + totalDinero);
    }

    // Método para consultar un día específico
    private static void consultarDiaEspecifico() {
        int dia = elegirDia();
        if (dia == -1) return;

        int diaIdx = dia - 1;
        int fresa = ventas[diaIdx][0];
        int limon = ventas[diaIdx][1];
        int coco = ventas[diaIdx][2];

        int totalPaletas = fresa + limon + coco;
        double totalDinero = (fresa * PRECIO_FRESA) + (limon * PRECIO_LIMON) + (coco * PRECIO_COCO);

        System.out.println("\n--- DETALLE DE VENTAS DEL DÍA " + dia + " ---");
        System.out.println("Fresa ($15): " + fresa + " paletas ($" + (fresa * PRECIO_FRESA) + ")");
        System.out.println("Limón ($12): " + limon + " paletas ($" + (limon * PRECIO_LIMON) + ")");
        System.out.println("Coco  ($18): " + coco + " paletas ($" + (coco * PRECIO_COCO) + ")");
        System.out.println("Total paletas vendidas en el Día " + dia + ": " + totalPaletas);
        System.out.println("Recaudación del Día " + dia + ": $" + totalDinero);
    }

    // Método para modificar los datos de un día en específico
    private static void modificarRegistro() {
        int dia = elegirDia();
        if (dia == -1) return;

        System.out.println("\nModificando el registro del DÍA " + dia + ":");
        registrarVentasDia(dia - 1);
        System.out.println("¡Registro del Día " + dia + " actualizado con éxito!");
    }

    // Método para borrar todos los registros
    private static void borrarRegistroTotal() {
        System.out.print("¿Está seguro de que desea borrar TODOS los registros? (S/N): ");
        String confirmacion = scanner.next();

        if (confirmacion.equalsIgnoreCase("S")) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    ventas[i][j] = 0;
                }
            }
            System.out.println("¡Todos los registros han sido borrados (puestos en 0)!");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    // Método auxiliar para seleccionar un día válido (1 o 2)
    private static int elegirDia() {
        int dia = leerEntero("Seleccione el día que desea consultar/modificar (1 o 2): ");
        if (dia != 1 && dia != 2) {
            System.out.println("Día inválido. Solo se permite Día 1 o Día 2.");
            return -1;
        }
        return dia;
    }

    // Método auxiliar para validar que el usuario ingrese números enteros válidos
    private static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 0) {
                    break;
                } else {
                    System.out.println("Por favor ingrese un número mayor o igual a 0.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                scanner.next(); // Limpiar entrada incorrecta
            }
        }
        return valor;
    }
}