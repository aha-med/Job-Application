package programAskedInZoho;//Adding a digit to all the digits of a number eg digit=4, number = 2875, o/p= 612119

public class AddingIntInDigit {
    public static void main(String[] args) {
        int number=2875;
        int result=addNumber(number,4);
        System.out.println(result);
    }

    private static int addNumber(int number, int i) {
        StringBuilder sb=new StringBuilder();
        while(number!=0){
            int cur=number%10;
            sb.insert(0,String.valueOf(cur+i));
            number/=10;
        }
        return Integer.parseInt(sb.toString());
    }
}
