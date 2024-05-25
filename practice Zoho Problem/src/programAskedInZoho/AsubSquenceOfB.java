package programAskedInZoho;

public class AsubSquenceOfB {
    public static void main(String[] args) {
        String A = "geefg";
        String B = "geeksforgeeks";
        System.out.println(isSubsequence(A,B));
    }

    private static boolean isSubsequence(String a, String b) {
        int j=0;
        for(int i=0;i<b.length();i++){
            if(a.charAt(j)==b.charAt(i)){
                j++;
                if(j==a.length()) return true;
            }
        }
        return false;
    }
}
