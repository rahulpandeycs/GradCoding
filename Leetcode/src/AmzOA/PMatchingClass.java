package src.AmzOA;

import java.util.Arrays;

public class PMatchingClass {
    static int getPMatchingScore (String user1, String user2, int p){
        int count = 0;
        if(user1.length() < user2.length()) return 0;
        int[] charCountMap = new int[26];
        for(int i=0; i < user2.length(); i++){  //O(len(user2)) => O(m)
            charCountMap[user2.charAt(i)-'a'] += 1;
        }

        for(int startIndex = 0; startIndex < user1.length() - p; startIndex++){
            int currStringPointer = startIndex;
            int[] currentCharCountMap = new int[26];
            while(currStringPointer < user1.length()){
                currentCharCountMap[user1.charAt(currStringPointer) -'a']+=1;
                currStringPointer+=p;
                if(Arrays.equals(currentCharCountMap, charCountMap)){
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getPMatchingScore("acaccaa", "aac", 2));
        System.out.println(getPMatchingScore("acbbca", "acb", 2));
        System.out.println(getPMatchingScore("ab", "aac", 2));
    }
}
