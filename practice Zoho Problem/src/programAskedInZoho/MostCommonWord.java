package programAskedInZoho;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned={"hit"};
       paragraph= paragraph.toLowerCase().replaceAll("[^A-Za-z]"," ");
        String[] word=paragraph.split(" ");
      String   words[]=Arrays.stream(word).map(String::trim).toArray(String[]::new);
        HashMap<String,Integer> map=new HashMap<>();
        for(String a:words) {
            if (!a.equals("")) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        List<String> li=new ArrayList<>(map.keySet());
        Collections.sort(li,(a,b)-> {
            int a1=map.get(a);
            int b1=map.get(b);
            if(b1!=a1){
                return Integer.compare(b1,a1);
            }
            return a.compareTo(b);
        });
        System.out.println(li);
       List<String > a=Arrays.asList(banned);
       for(String s:li){
           if(!a.contains(s)){
               System.out.println(s);
           }
       }
    }
}
