import java.util.Scanner;

public class CalculadoraSalud {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion = 1;

        do {

            System.out.println("\n==============================");
            System.out.println("       CALCULO DEL IMC");
            System.out.println("==============================");

            System.out.print("Escribe tu peso en kg: ");
            double peso = teclado.nextDouble();

            System.out.print("Escribe tu estatura en metros: ");
            double altura = teclado.nextDouble();

            // Calculo del IMC
            double resultado = peso / (altura * altura);

            System.out.printf("\nIMC obtenido: %.2f\n", resultado);

            int tipo;

            // IF - ELSE para determinar la categoria
            if (resultado < 18.5) {
                tipo = 1;
            } else if (resultado < 25) {
                tipo = 2;
            } else if (resultado < 30) {
                tipo = 3;
            } else if (resultado < 35) {
                tipo = 4;
            } else if (resultado < 40) {
                tipo = 5;
            } else {
                tipo = 6;
            }

            // SWITCH - CASE
            System.out.println("\nResultado:");

            switch (tipo) {

                case 1:
                    System.out.println("Nivel: Bajo peso");
                    System.out.println("Recomendacion 1: Mejorar la alimentacion.");
                    System.out.println("Recomendacion 2: Consultar con un profesional de salud.");
                    break;

                case 2:
                    System.out.println("Nivel: Peso normal");
                    System.out.println("Recomendacion 1: Mantener una alimentacion balanceada.");
                    System.out.println("Recomendacion 2: Continuar realizando ejercicio.");
                    break;

                case 3:
                    System.out.println("Nivel: Sobrepeso");
                    System.out.println("Recomendacion 1: Realizar actividad fisica con frecuencia.");
                    System.out.println("Recomendacion 2: Reducir alimentos con exceso de azucar.");
                    break;

                case 4:
                    System.out.println("Nivel: Obesidad tipo 1");
                    System.out.println("Recomendacion 1: Consultar a un profesional de salud.");
                    System.out.println("Recomendacion 2: Comenzar actividad fisica de manera gradual.");
                    break;

                case 5:
                    System.out.println("Nivel: Obesidad tipo 2");
                    System.out.println("Recomendacion 1: Buscar orientacion profesional.");
                    System.out.println("Recomendacion 2: Establecer cambios progresivos en la alimentacion.");
                    break;

                case 6:
                    System.out.println("Nivel: Obesidad tipo 3");
                    System.out.println("Recomendacion 1: Solicitar una valoracion profesional.");
                    System.out.println("Recomendacion 2: Seguir un plan de alimentacion y actividad fisica supervisado.");
                    break;

                default:
                    System.out.println("No se pudo determinar el nivel.");
                    break;
            }

            System.out.println("\n------------------------------");
            System.out.print("¿Quieres realizar otro calculo?");
            System.out.println("\n1. Si");
            System.out.println("2. No");
            System.out.print("Selecciona una opcion: ");

            opcion = teclado.nextInt();

        } while (opcion == 1);

        System.out.println("\nPrograma finalizado.");
        teclado.close();
    }
}