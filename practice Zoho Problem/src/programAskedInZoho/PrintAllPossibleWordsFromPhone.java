package programAskedInZoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllPossibleWordsFromPhone {
   static Character[][] l;

    public static void main(String[] args) {
        int[] numbers={2,3,4};
       List<String> list=printWords(numbers);
       for(String s:list){
           System.out.println(s);
       }
    }

    private static List<String>  printWords(int[] numbers) {
        generateCharacterWithNumbers();
      return   printWords(numbers,numbers.length,0,"");
    }

    private static List<String>  printWords(int[] numbers, int length, int index,
                                            String s) {
        if(index== numbers.length){
            return new ArrayList<>(
                    Collections.singleton(s));
        }
        List<String> stringList=new ArrayList<>();
        for(int i=0;i<l[numbers[index]].length;i++){
            String sCopy=s;
            sCopy = sCopy.concat(
                    l[numbers[index]][i]
                            .toString());
            stringList.addAll(printWords(numbers,length,index+1,sCopy));
        }
        return stringList;
    }

    private static void generateCharacterWithNumbers() {
        l=new Character[10][4];
        l[0]=new Character[]{'\0'};
        l[1]=new Character[]{'\0'};
        l[2]=new Character[]{'a','b','c'};
        l[3]=new Character[]{'d','e','f'};
        l[4]=new Character[]{'g','h','i'};
        l[5]=new Character[]{'j','k','l'};
        l[6]=new Character[]{'m','n','o'};
        l[7]=new Character[]{'p','q','r','s'};
        l[8]=new Character[]{'t','u','v'};
        l[9]=new Character[]{'w','x','y','z'};
    }
}
