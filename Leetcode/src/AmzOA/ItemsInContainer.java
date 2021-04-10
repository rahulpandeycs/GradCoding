package src.AmzOA;

import java.util.*;
import java.util.stream.Collectors;

public class ItemsInContainer {

    //O(n)
    public static List<Integer> numberOfItems(String s,List<List<Integer>> ranges) {


        int[] prefix = new int[s.length()];
        int[] suffix = new int[s.length()];

        List<Integer> output = new ArrayList<>();

        int last = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|') last = i;
            prefix[i] = last;
        }

        if(last == -1){
            for(int i = 0; i < ranges.size(); i++) output.add(0);
            return output;
        }

        last = -1;
        for(int i = s.length()-1; i >=0; i--){
            if(s.charAt(i) == '|') last = i;
            suffix[i] = last;
        }

        int[] pre = new int[s.length()];
        int count = 0;

        for(int i=0; i < s.length(); i++){
            pre[i] = (i == 0 ? 0 : pre[i-1]) + (s.charAt(i) == '*' ? 1 : 0);
        }

        for(List<Integer> range : ranges){
            output.add(pre[prefix[range.get(1)]] - pre[suffix[range.get(0)]]);
        }
        return  output;
    }

    public static void main(String[] args) {
        List<List<Integer>> ranges = new ArrayList<>();
        ranges.add(Arrays.asList(1,3));
        ranges.add(Arrays.asList(2,12));
        System.out.println("Items in Containers: " + numberOfItems("*|*|*****|*|**", ranges));

        ranges.clear();
        ranges.add(Arrays.asList(0,3));
        System.out.println("Items in Containers: " + numberOfItems("|**|***|", ranges));
    }
}
