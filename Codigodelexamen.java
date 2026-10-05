```java
import java.util.Scanner;

public class EvaluacionDeUnPrestamo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Declaración de variables
        String nombre;
        double ingresoMensual, montoSolicitado;
        int meses;
        double montoMaximo, porcentajeInteres, interesMensual;
        double pagoMensual, montoTotal;

        // Entrada de datos
        System.out.print("Nombre del solicitante: ");
        nombre = entrada.nextLine();

        System.out.print("Ingreso mensual: ");
        ingresoMensual = entrada.nextDouble();

        System.out.print("Monto solicitado: ");
        montoSolicitado = entrada.nextDouble();

        System.out.print("Numero de meses para pagar: ");
        meses = entrada.nextInt();

        // Calcular el monto máximo del préstamo
        montoMaximo = ingresoMensual * 3;

        // Evaluar si el préstamo puede ser aprobado
        if (montoSolicitado <= montoMaximo) {

            // Determinar el porcentaje de interés
            if (meses <= 12) {
                porcentajeInteres = 0.03;
            } else if (meses <= 24) {
                porcentajeInteres = 0.05;
            } else {
                porcentajeInteres = 0.07;
            }

            // Calcular intereses y pagos
            interesMensual = montoSolicitado * porcentajeInteres;
            montoTotal = montoSolicitado + (interesMensual * meses);
            pagoMensual = montoTotal / meses;

            // Mostrar resultados
            System.out.println();
            System.out.println("PRESTAMO APROBADO");
            System.out.println("Nombre del solicitante: " + nombre);
            System.out.println("Monto solicitado: $" + montoSolicitado);
            System.out.println("Porcentaje de interes mensual: "
                    + (porcentajeInteres * 100) + "%");
            System.out.println("Numero de mensualidades: " + meses);
            System.out.println("Pago mensual: $" + pagoMensual);
            System.out.println("Monto total a pagar: $" + montoTotal);

        } else {

            // Mostrar mensaje de préstamo rechazado
            System.out.println();
            System.out.println("PRESTAMO RECHAZADO");
            System.out.println("El monto maximo que puede solicitar es: $"
                    + montoMaximo);
        }

        entrada.close();
    }
}
```
