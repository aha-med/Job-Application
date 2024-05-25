package programAskedInZoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortDiagnoal {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        sortDiagnoal(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    private static void sortDiagnoal(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            sortMatrix(mat, 0, i);
        }
        for (int i = 0; i < mat[0].length; i++) {
            sortMatrix(mat, i, 0);
        }
    }

    private static void sortMatrix(int[][] mat, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n, j = m; i < mat.length && j < mat[0].length; i++, j++) {
            list.add(mat[i][j]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            mat[n++][m++] = list.get(i);
        }
    }
}
