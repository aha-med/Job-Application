package programAskedInZoho;

public class RemoveChars {
    public static void main(String[] args) {
        String a="computer";
        String b="cat";
        String result=removeChars(a,b);
        System.out.println(result);
    }

    private static String removeChars(String a, String b) {
        String res="";
        for(int i=0;i<a.length();i++){
            boolean isPresent=false;
            for(int j=0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    isPresent=true;
                }
            }
            if(!isPresent){
                res=res+a.charAt(i);
            }
        }
        return res;
    }
}
