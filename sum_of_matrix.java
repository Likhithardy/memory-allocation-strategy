
import java.util.Scanner;

class sum_of_matrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix_1 = new int[3][3];
        int[][] matrix_2 = new int[3][3];
        int[][] matrix_sum = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter elements for [" + i + "] [" + j + "] for matrix 1");
                matrix_1[i][j] = input.nextInt();
            }
        }
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                System.out.println("Enter Elements for [" + m + "][" + n + "] For matrix 2");
                matrix_2[m][n] = input.nextInt();
            }
        }
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++) {
                matrix_sum[p][q] = matrix_1[p][q] + matrix_2[p][q];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix_sum[i][j] + " ");
            }
            System.out.println("");
        }
        input.close();
    }
}
