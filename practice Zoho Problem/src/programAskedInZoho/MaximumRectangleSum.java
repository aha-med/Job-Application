package programAskedInZoho;

public class MaximumRectangleSum {
    public static void main(String[] args) {
        int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 } };
        int result=maxRectangelSum(arr);
        System.out.println(result);
    }

    private static int maxRectangelSum(int[][] arr) {
        int r= arr.length;
        int c=arr[0].length;
        int maxSum=Integer.MIN_VALUE;
        int[] temp=new int[r];
        int maxLeft=0,maxRigtht=0,maxTop=0,maxDown=0;
        for(int left=0;left<c;left++){
            for(int i=0;i<r;i++){
                temp[i]=0;
            }
            for(int right=left;right<c;right++){
                for(int top=0;top<r;top++){
                    temp[top]+=arr[top][right];
                }
                int currMax=temp[0],maxSoFar=temp[0],currStart=0,start=0,end=0;
                for(int i=1;i<temp.length;i++){
                    if(maxSoFar<0){
                        maxSoFar=0;
                        currStart=i+1;
                    }
                    maxSoFar+=temp[i];
                    if(maxSoFar>currMax){
                        currMax=maxSoFar;
                        end=i;
                        start=currStart;
                    }
                }
                if(currMax>maxSum){
                    maxSum=currMax;
                    maxLeft=left;
                    maxRigtht=right;
                    maxTop=start;
                    maxDown=end;
                }
            }
        }
        return maxSum;
    }
}
