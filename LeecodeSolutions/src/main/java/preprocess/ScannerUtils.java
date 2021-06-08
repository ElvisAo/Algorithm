package preprocess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerUtils {
    public static int[][] scanner2dMatrixInteger(int row, int col, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int[][] r = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                r[i][j] = scanner.nextInt();
            }
        }
        return r;
    }
}
