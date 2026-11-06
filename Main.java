public class Main {
    public static void main(String[] args) {
        // Puntos de ejemplo del ejercicio en clase: (1, 2), (2, 3), (4, 10)
        double[] x = {1.0, 2.0, 3.0, 4.0};
        double[] y = {12.0, 15.0, 21.0, 30.0};

        // Punto intermedio a interpolar
        double xEval = 2.5;

        // 1. Calcular tabla de diferencias divididas llamando a la clase de interpolación
        double[][] tablaDiferencias = InterpolacionNewton.calcularDiferenciasDivididas(x, y);

        // 2. Imprimir la tabla
        InterpolacionNewton.imprimirTabla(x, tablaDiferencias);
        double lagrange = InterpolacionLagrange.InterpolacionLagrange(x, y, xEval);
        double newton = InterpolacionNewton.evaluarPolinomio(x, tablaDiferencias, xEval);

        // 3.Evaluamos la función original para comprobar los dos resultados.
        double referencia = xEval * xEval + xEval + 1;


        // 4. Mostrar los coeficientes (Diagonal superior)
        System.out.println("\n--- COEFICIENTES DEL POLINOMIO (a_k) ---");
        for (int k = 0; k < x.length; k++) {
            System.out.printf("a_%d = %.4f\n", k, tablaDiferencias[0][k]);
        }

        // 5. Evaluar en x = 3
        double yInterpolado = InterpolacionNewton.evaluarPolinomio(x, tablaDiferencias, xEval);

        System.out.println("\n--- RESULTADO DE LA INTERPOLACIÓN ---");
        System.out.printf("El valor estimado en x = %.2f es P(%.2f) = %.4f\n", xEval, xEval, yInterpolado);
        InterpolacionNewton.imprimirTabla(x, tablaDiferencias);
        System.out.printf("%nPunto de evaluacion: x = %.2f%n", xEval);
        System.out.printf("Lagrange: %.10f%n", lagrange);
        System.out.printf("Newton:   %.10f%n", newton);
        System.out.printf("Diferencia absoluta: %.10f%n", Math.abs(lagrange - newton));
    }
}