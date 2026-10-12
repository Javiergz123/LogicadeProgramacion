public class lista {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[10];

        // Leer los 10 números
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = teclado.nextInt();
        }

        // Inicializar el mayor y el menor con el primer número
        int mayor = numeros[0];
        int menor = numeros[0];

        int posicionMayor = 0;
        int posicionMenor = 0;

        // Recorrer el arreglo para encontrar el mayor y el menor
        for (int i = 1; i < 10; i++) {

            if (numeros[i] > mayor) {
                mayor = numeros[i];
                posicionMayor = i;
            }

            if (numeros[i] < menor) {
                menor = numeros[i];
                posicionMenor = i;
            }
        }

        // Mostrar los resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("El número mayor es: " + mayor);
        System.out.println("Su posición es: " + (posicionMayor + 1));

        System.out.println("El número menor es: " + menor);
        System.out.println("Su posición es: " + (posicionMenor + 1));

        teclado.close();
    }

}