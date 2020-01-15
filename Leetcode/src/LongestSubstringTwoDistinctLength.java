public class LongestSubstringTwoDistinctLength {


  public static int lengthOfLongestSubstringTwoDistinct(String s) {

    int[] map = new int[128];
    int start =0, end = 0, counter = 0, maxLen = 0;

    while(end < s.length()) {
      map[s.charAt(end)]++;
      if(map[s.charAt(end++)] == 1) counter++;

      while(counter > 2) {
             if(map[s.charAt(start)]-- == 1) counter--;
             start++;
      }
      maxLen = Math.max(maxLen, end - start);
    }
    return maxLen;
  }

  public static void main(String[] args){
     String str = "ccaabbb";
     System.out.println(lengthOfLongestSubstringTwoDistinct(str));
  }
}
