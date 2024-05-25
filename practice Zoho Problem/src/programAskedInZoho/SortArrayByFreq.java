package programAskedInZoho;

import java.util.*;

public class SortArrayByFreq {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sortByFreq(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortByFreq(Integer[] arr) {
        // Step 1: Count frequencies of integers using HashMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr,(i,j)-> {
                    int f1 = frequencyMap.get(i);
                    int f2=frequencyMap.get(j);
                    if(f1!=f2) return f2-f1;
                    return i-j;
                }
        );

    }

}
