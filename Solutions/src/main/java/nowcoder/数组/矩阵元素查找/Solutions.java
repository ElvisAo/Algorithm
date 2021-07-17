/**
 * @author Everett
 * @date 6/27/2021 11:42 PM
 */
package nowcoder.数组.矩阵元素查找;

public class Solutions {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(new Solutions().findElement(mat, 2, 3, 6));
    }

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int[] r = new int[2];
        for (int i = 0; i < n; ) {
            for (int j = m - 1; j >= 0; ) {
                if (mat[i][j] == x) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                } else if (mat[i][j] > x) j--;
                else if (mat[i][j] < x) i++;
            }
        }
        return r;
    }
}
