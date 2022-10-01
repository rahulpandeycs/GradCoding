package src.AmzOA;

import java.util.HashMap;
import java.util.Map;

public class KeyPadClickCount {

    static int getMinKeyPadCount(String inputString){
        int keyCount = 0;
        int clickCount = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : inputString.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> item : countMap.entrySet()){
            int factor = Math.floorDiv(keyCount ,9) +1;
            clickCount += factor * item.getValue();
            keyCount+=1;
        }
        return clickCount;
    }

    public static void main(String[] args) {
        System.out.println(getMinKeyPadCount("abcghdiefjoba"));
        System.out.println(getMinKeyPadCount("abacadefghibj"));
    }
}
