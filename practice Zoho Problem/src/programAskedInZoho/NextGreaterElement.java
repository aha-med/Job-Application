package programAskedInZoho;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> stack=new Stack<>();
        long[] result=new long[n];

        stack.push(arr[n-1]);
        result[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i]=stack.peek();
            }
            else{
                result[i]=-1;
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        long[] arr={1 ,3, 2 ,4};
      long[] result=  nextLargerElement(arr,arr.length);
        System.out.println(Arrays.toString(result));
    }
}
