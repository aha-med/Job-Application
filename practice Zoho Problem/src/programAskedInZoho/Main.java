package programAskedInZoho;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
     long[] a={1, 2, 3, 5, 4, 7, 10};
      long[] result=sortIt(a,a.length);
        System.out.println(Arrays.toString(result));
    }
    public static long[] sortIt(long arr[], long n)
    {
     int odd=0;
     int even=0;
     for(int i=0;i< arr.length;i++){
         if(arr[i]%2==1) odd++;
     }
        for(int i=0;i< arr.length;i++){
            if(arr[i]%2==0) even++;
        }
        long[] oddArr=new long[odd];
        long[] evenArr=new long[even];
        int m1=0;
        int m2=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                evenArr[m1++]=arr[i];
            }
            else{
                oddArr[m2++]=arr[i];
            }
        }
        for(int i=0;i<odd;i++){
            for(int j=i+1;j<odd;j++){
                if(oddArr[i]<oddArr[j]){
                  long temp=oddArr[i];
                  oddArr[i]=oddArr[j];
                  oddArr[j]=temp;
                }
            }
        }

        for(int i=0;i<even;i++){
            for(int j=i+1;j<even;j++){
                if(evenArr[i]>evenArr[j]){
                    long temp=evenArr[i];
                    evenArr[i]=evenArr[j];
                    evenArr[j]=temp;
                }
            }
        }
        long result[] =new long[arr.length];
        int index=0;
        for(long i:oddArr){
            result[index++]=i;
        }
        for (long i: evenArr){
            result[index++]=i;
        }

        return result;
    }
}