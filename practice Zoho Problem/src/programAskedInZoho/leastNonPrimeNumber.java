package programAskedInZoho;

import java.util.Arrays;

public class leastNonPrimeNumber {
    public static void main(String[] args) {
        int[] a={5, 4, 10};
        int[] b={3 ,4 ,7};
        int res[]=new int[a.length];
        for(int i=0;i<a.length;i++) {
            res[i]=findNonPrime(a[i],b[i]);
        }
        System.out.println(Arrays.toString(res));
    }

    private static int findNonPrime(int a, int b) {
        for(int i=4;i<1000;i++){
            if(!isPrime(i) && (a+i)%b==0){
                return i;
            }
        }
        return -1;
    }
    public static boolean isPrime(int num){
        if(num<=1){
            return true;
        }
        for(int i=2;i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
