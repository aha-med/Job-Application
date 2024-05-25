package programAskedInZoho;

import java.util.HashMap;
import java.util.Map;

public class BinaryToHexa {

    public static void main(String[] args) {
    String bin="1111001010010100001.010110110011011";
     String result=convertToHexa(bin);
        System.out.println(result);
    }
    public static String convertToHexa(String bin){
        int l=bin.length();
        int dot=bin.indexOf(".");
        int left_length=dot!=-1?l:dot;
        for(int i=1;i<=(4-left_length%4)%4;i++){
            bin="0"+bin;
        }
        if(dot!=-1){
            int right_length=l-left_length-1;
            for(int i=1;i<=(4-right_length%4)%4;i++){
                bin=bin + "0";
            }
        }
        HashMap<String,Character> binary_hexa=new HashMap<>();
        createMap(binary_hexa);
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(true){
          sb.append(binary_hexa.get(bin.substring(i,i+4)));
            i=i+4;
            if(bin.length()==i) break;
          if(bin.charAt(i)=='.'){
              sb.append('.');
              i++;
          }


        }
        return sb.toString();
    }
    static void createMap(Map<String, Character> um)
    {
        um.put("0000", '0');
        um.put("0001", '1');
        um.put("0010", '2');
        um.put("0011", '3');
        um.put("0100", '4');
        um.put("0101", '5');
        um.put("0110", '6');
        um.put("0111", '7');
        um.put("1000", '8');
        um.put("1001", '9');
        um.put("1010", 'A');
        um.put("1011", 'B');
        um.put("1100", 'C');
        um.put("1101", 'D');
        um.put("1110", 'E');
        um.put("1111", 'F');
    }
}
