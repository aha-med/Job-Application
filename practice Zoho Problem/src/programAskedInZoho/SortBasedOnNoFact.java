package programAskedInZoho;

import java.util.Arrays;
import java.util.HashMap;

public class SortBasedOnNoFact {
    public static void main(String[] args) {
        Integer[] arr={104, 210, 315, 166, 441, 180};
        sortArrBasedOnFactor(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrBasedOnFactor(Integer[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,countFactor(i));
        }
        Arrays.sort(arr,(a,b)-> {
                    int f1 = map.get(a);
                    int f2 = map.get(b);
                    if(f1!=f2){
                        return f2-f1;
                    }
                    return 0;
                }
        );
    }

    private static Integer countFactor(int num) {
        int count=0;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                count++;
            }
        }
        return count;
    }
}
