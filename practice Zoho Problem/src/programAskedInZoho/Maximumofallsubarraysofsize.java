package programAskedInZoho;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
public class Maximumofallsubarraysofsize {
    public static void main(String[] args) {
      int  N = 9, K = 3;
       int[] arr = {1 ,2 ,3 ,1, 4, 5, 2, 3, 6};
       int[] result=maxOfAllSubArr(arr,N,K);
        System.out.println(Arrays.toString(result));
    }

    private static int[] maxOfAllSubArr(int[] arr, int n, int k) {
        Deque<Integer> q=new LinkedList<>();
        int[] result=new int[n-k+1];

        for(int i=0;i<n;i++){
           while(!q.isEmpty() && q.peekFirst()<i-k+1){
               q.pollFirst();
           }
           while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
               q.pollLast();
           }
           q.offerLast(i);
           if(i>=k-1){
               result[i-k+1]=arr[q.peekFirst()];
           }
        }
        return result;
    }
}
