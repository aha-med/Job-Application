package programAskedInZoho;

import java.util.HashMap;
import java.util.Objects;

public class NoOfCellsQueenMove {
    public static void main(String[] args) {
        int n = 8;  // Chessboard size
        int k = 1;  // Number of obstacles
        int Qposx = 4; // Queen x position
        int Qposy = 4; // Queen y position
        int obstPosx[] = { 3 };  // x position of obstacles
        int obstPosy[] = { 5 };  // y position of obstacles

        System.out.print(numberofPosition(n, k, Qposx, Qposy,
                obstPosx, obstPosy) +"\n");
    }

    private static int numberofPosition
            (int n,int k,int qposx,int qposy,int[] obstPosx,int[] obstPosy) {
        HashMap<Pair,Integer> map=new HashMap<>();
        int ans=0;
        while (k>0){
            k--;
           int x=obstPosx[k];
           int y=obstPosy[k];
           map.put(new Pair(x,y),1);
        }
        ans+=countMovesOfQueen(map,qposx-1,qposy,-1,0,n);
        ans+=countMovesOfQueen(map,qposx-1,qposy+1,-1,1,n);
        ans+=countMovesOfQueen(map,qposx,qposy+1,0,1,n);
        ans+=countMovesOfQueen(map,qposx+1,qposy+1,1,1,n);
        ans+=countMovesOfQueen(map,qposx+1,qposy,1,0,n);
        ans+=countMovesOfQueen(map,qposx+1,qposy-1,1,-1,n);
        ans+=countMovesOfQueen(map,qposx,qposy-1,0,-1,n);
        ans+=countMovesOfQueen(map,qposx-1,qposy-1,-1,-1,n);
        return ans;

    }

    private static int countMovesOfQueen(HashMap<Pair, Integer> map,
                                         int qposx, int qposy, int x, int y,int n) {
        int count=0;
        while(inRange(qposx,qposy,n) &&
                !map.containsKey(new Pair(qposx,qposy))){
          qposx+=x;
          qposy+=y;
          count++;
        }
        return count;
    }

    private static boolean inRange(int qposx, int qposy,int n) {
       return  (qposx <= n && qposx > 0 && qposy <= n && qposy > 0);
    }

    static class Pair{
        int obsX;
        int obsY;
        Pair(int obsX,int obsY){
            this.obsX=obsX;
            this.obsY=obsY;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return obsX == pair.obsX && obsY == pair.obsY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(obsX, obsY);
        }
    }
}

