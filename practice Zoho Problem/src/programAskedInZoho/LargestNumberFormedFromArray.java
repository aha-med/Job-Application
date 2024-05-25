package programAskedInZoho;

public class LargestNumberFormedFromArray  {
    public static void main(String[] args) {
       int n = 5;
        String[] arr = {"3", "30", "34", "5", "9"};
       String result=sort(arr,n);
        System.out.println(result);
    }

    private static String sort(String[] arr, int n) {
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                if((arr[i]+arr[j]).compareTo(arr[j]+arr[i])<0){
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        String res="";
        for(String i:arr){
            res+=i;
        }
        return res;
    }
    
}
