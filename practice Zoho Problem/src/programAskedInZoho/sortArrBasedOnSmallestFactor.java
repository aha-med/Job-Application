package programAskedInZoho;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sortArrBasedOnSmallestFactor {
    public static void main(String[] args) {
        Integer[] arr = {15, 8, 12, 10, 9};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArr(Integer[] arr) {
        Arrays.sort(arr,(a,b)->{
                int f1=smallestFactor(a);
                int f2=smallestFactor(b);
             return (f1 < f2) ? -1 : ((f1== f2) ? 0 : 1);
        });
    }
    public static int smallestFactor(int num){
        if(num<=1){
            return 1;
        }
        for(int i=2;i<num;i++){
            if(num%i==0) return i;
        }
        return num;
    }
}
