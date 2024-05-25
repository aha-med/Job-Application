package programAskedInZoho;

public class UniquePath {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };
       int n= countPath(matrix,0,0);
        System.out.println(n);
    }

    private static int countPath(int[][] matrix, int r, int c) {
        if(r==matrix.length-1 && c==matrix[0].length-1){
            if(matrix[r][c]==1) return 1;
        }
        if(matrix[r][c]==0){
            return 0;
        }
        int count=0;
        if(r>=0 && r<matrix.length-1){
            count+=countPath(matrix,r+1,c);
        }
        if(c>=0 && c<matrix[0].length-1){
            count+=countPath(matrix,r,c+1);
        }
        return count;
    }
}
