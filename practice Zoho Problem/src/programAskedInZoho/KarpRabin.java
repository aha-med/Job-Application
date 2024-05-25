package programAskedInZoho;

public class KarpRabin {
   static long PRIME=101;
    public static void main(String[] args) {
        String text="aproblem solving problem";
        String pattern="problem";
        searchPattern(text,pattern,pattern.length());
    }

    private static void searchPattern(String text, String pattern, int length) {
       long patHash=calculateHash(pattern);
       long textHash=calculateHash(text.substring(0,pattern.length()));
       for(int i=0;i<text.length()-pattern.length()+1;i++){
           if(patHash==textHash){
               System.out.println("pattern at index "+i);
           }
           if(i<text.length()-pattern.length()) {
               textHash = rehash(textHash, text.charAt(i), text.charAt(i + pattern.length()), pattern.length());
           }
       }
    }

    private static long rehash(long prevHash, char oldC, char newC, int pattLen) {
        long newHash=(prevHash-oldC)/PRIME;
        newHash= (long) (newHash+newC*Math.pow(PRIME,pattLen-1));
        return newHash;
    }

    static long calculateHash(String str){
        long hash=0;
        for(int i=0;i<str.length();i++){
            hash= (long) (hash + str.charAt(i) * Math.pow(PRIME,i));
        }
        return hash;
    }
}
