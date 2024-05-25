package programAskedInZoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndStringInGrid {
   static final  int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
   static final int[] colDirections = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) {
      char[][]  grid = {{'a','b','c'},
                        {'d','r','f'},
                        {'g','h','i'}};
      String  word = "abc";
        List<int[]> res=new ArrayList<>();

      for(int i=0;i< grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==word.charAt(0)) {
                  if (search(word, grid, i, j, 0)) {
                      res.add(new int[]{i, j});
                  }
              }
          }
      }
      for(int[] a:res){
          System.out.println(Arrays.toString(a));
      }
    }
    public static boolean search(String word,char[][] grid,int row,int col,int index){
        if(word.length()==index){
            return true;
        }
        if(row<0 || col<0 || row>= grid.length || col>=grid[0].length){
            return false;
        }

        if(word.charAt(index)!=grid[row][col]) return false;
        for(int i=0;i<8;i++){
            int r=row+rowDirections[i];
            int c=col+colDirections[i];
            if(search(word,grid,r,c,index+1)){
                return true;
            }
        }
        return false;
    }
}
