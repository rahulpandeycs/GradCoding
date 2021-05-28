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

        for(int i=0; i < s.length(); i++){
            pre[i] = (i == 0 ? 0 : pre[i-1]) + (s.charAt(i) == '*' ? 1 : 0);
        }

        for(List<Integer> range : ranges){
            output.add(pre[prefix[range.get(1)]] - pre[suffix[range.get(0)]]);
        }
        return  output;
    }


    public static List<Integer> numberOfItems3(String s, List<List<Integer>> ranges) {

         List<Integer> output = new ArrayList<>();
         List<String> store = new ArrayList<>();
         int count =0;

         for(char ch : s.toCharArray()){
             if(ch == '|'){
                 store.add(count+"");
                 count++;
             }else store.add("*");
         }

         System.out.println(s);
         System.out.println(store);

         int start = 0;
         int end = 0;

         for(int i=0; i < ranges.size(); i++){

             start = ranges.get(i).get(0);
             end = ranges.get(i).get(1);

             while(start < end && start < s.length() && store.get(start).equals("*")) start++;
             while(start < end && end >= 0 && store.get(end).equals("*")) end--;

             if(start >= s.length() || end < 0) output.add(0);
             else {
                 String star = "*";
                 if(store.get(end).equals(star) || store.get(start).equals(star)){
                     output.add(0);
                 } else {
                     output.add((end-start) - (Integer.valueOf(store.get(end)) - Integer.valueOf(store.get(start))));
                 }
             }
         }
         return output;
    }


    public static List<Integer> numberOfItems2(String s, List<List<Integer>> ranges) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0 ;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '|') {
                map.put(i, count);
            } else {
                count++;
            }
        } // O(s.length())

        System.out.println(s);
        System.out.println(map);

        List<Integer> result  = new ArrayList<>();

        for(List<Integer> range: ranges) {
            result.add(noOfItems(range.get(0), range.get(1), map));
        }  // Time: O(ranges.size() * log(map.size())) => O(n log n) + O(n), Space: O(n) for map
        return result;
    }

    static int noOfItems(int s, int e, TreeMap<Integer, Integer> map) {
        if(map.floorEntry(e) == null || map.ceilingEntry(s) == null) {
            return 0;
        }
        return map.floorEntry(e).getValue() - map.ceilingEntry(s).getValue();
    }

    public static void main(String[] args) {
        List<List<Integer>> ranges = new ArrayList<>();
        ranges.add(Arrays.asList(1,3));
        ranges.add(Arrays.asList(2,12));
        System.out.println("Items in Containers: " + numberOfItems2("*|*|*****|*|**", ranges));

        ranges.clear();
        ranges.add(Arrays.asList(0,3));
        System.out.println("Items in Containers: " + numberOfItems2("|**|***|", ranges));

        ranges.clear();
        ranges.add(Arrays.asList(1,3));
        System.out.println("Items in Containers: " + numberOfItems2("*|*|", ranges));

        ranges.clear();
        ranges.add(Arrays.asList(0,4));
        ranges.add(Arrays.asList(0,5));
        System.out.println("Items in Containers: " + numberOfItems2("|**|*|*", ranges));


        ranges.clear();
        ranges.add(Arrays.asList(0,4));
        ranges.add(Arrays.asList(0,25));
        System.out.println("Items in Containers: " + numberOfItems2("**|********************|***|*******|*|*", ranges));
    }
}
