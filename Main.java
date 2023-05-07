/*@author   Alanís Mercado Alexis Yael
 @author    Frías Campos Ashly Daniela
 @author    Leyva Morales Kevin Tairi
 @author    Pineda Ruiz Carlos Alberto
 */
public class Main {
    public static void main(String[] args) {
        double[][] matriz = {{2, 3, 1},
                {4, 4, -4},
                {2, -3, -1}};

        int n = matriz.length;

        // Agregar la matriz identidad a la derecha de la matriz original
        double[][] aumentada = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aumentada[i][j] = matriz[i][j];
            }
            aumentada[i][i + n] = 1;
        }

        // Hacer ceros debajo de la diagonal en la matriz original
        for (int i = 0; i < n; i++) {
            // Dividir la fila actual por el elemento diagonal
            double divisor = aumentada[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aumentada[i][j] /= divisor;
            }

            // Hacer ceros en las demás filas debajo de la diagonal
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aumentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aumentada[k][j] -= factor * aumentada[i][j];
                    }
                }
            }
        }

        // Extraer la matriz inversa de la parte derecha de la matriz aumentada
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = aumentada[i][j + n];
            }
        }

        // Imprimir la matriz inversa resultante
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f\t", inversa[i][j]);
            }
            System.out.println();
        }
    }
}

