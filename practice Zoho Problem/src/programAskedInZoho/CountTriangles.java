package programAskedInZoho;

import java.util.Arrays;

public class CountTriangles {

    public static int countTriangles(int[] arr) {
        int n = arr.length;
        int count = 0;

        Arrays.sort(arr);
        for (int k = 2; k < n; k++) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 7, 6};
        int result = countTriangles(arr);
        System.out.println("Number of triangles that can be formed: " + result);
    }
}
