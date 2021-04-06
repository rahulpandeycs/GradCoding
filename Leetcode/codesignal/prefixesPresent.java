package codesignal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class prefixesPresent {

    public static boolean isPossibleWordBreak(String s, Set<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=i-1; j >=0 ; j--){
                dp[i] = dp[j] && wordDict.contains(s.substring(j,i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] A = {"one", "two", "three"};
        String[] B = {"onetwo", "one"};

        Set<String> wordDict = new HashSet<>();
        for(String str : A){
            wordDict.add(str);
        }

        for(String bStr : B){
            if(!isPossibleWordBreak(bStr,wordDict)) {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}
