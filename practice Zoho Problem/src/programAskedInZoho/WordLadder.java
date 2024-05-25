package programAskedInZoho;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> dict= new ArrayList<>(Arrays.asList("POON", "PLEE",
                "SAME", "POIE", "PLEA", "PLIE", "POIN"));
        String start = "TOON", target = "PLEA";
        Set<String> set=new HashSet<String>() ;
        int res=shortestChainLen(dict,start,target,set);
        System.out.println(res);
    }
    public static int shortestChainLen(List<String> dict,String start,
                                       String target,Set<String> set){
        if(!dict.contains(target)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(start);
        int length=0;
        while(!q.isEmpty()){
            int size=q.size();
            length++;
            for(int i=0;i<size;i++){
                String curr=q.poll();
                for(int k=0;k<curr.length();k++){
                    char[] ent=curr.toCharArray();
                    for(char ch='A';ch<='Z';ch++){
                        ent[k]=ch;
                        String s=new String(ent);
                        if(dict.contains(s) && !set.contains(s)){
                            q.add(s);
                        }
                        if(s.equals(target)){
                            return length+1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
