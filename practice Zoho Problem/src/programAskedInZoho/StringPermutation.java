package programAskedInZoho;

import java.util.*;

public class StringPermutation {
    public static void main(String[] args) {
        String s="ABCA";
        Set<String> l=new HashSet<>();
        permutation("",s,l,s.length());
            System.out.println(l);

    }

    private static void permutation(String actualStr,String s, Set<String> l,int n) {
        if(actualStr.length()==n){
            l.add(actualStr);
            return;
        }
        char ch=s.charAt(0);
        for(int i=0;i<=actualStr.length();i++){
            String fr=actualStr.substring(0,i);
            String back=actualStr.substring(i);
            permutation(fr+ch+back,s.substring(1),l,n);
        }
    }

}
