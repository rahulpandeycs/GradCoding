import java.util.HashMap;

public class StroboGrammaticNumber {

  //Question:  https://leetcode.com/problems/strobogrammatic-number/
  //Soln: https://leetcode.com/problems/strobogrammatic-number/discuss/67182/Accepted-Java-solution

  public static boolean isStrobogrammatic(String num) {

    HashMap<Character, Character> wordsMap = new HashMap<>();
    wordsMap.put('0', '0');
    wordsMap.put('1', '1');
    wordsMap.put('8', '8');
    wordsMap.put('6', '9');
    wordsMap.put('9', '6');

    int left = 0, right = num.length() - 1;
    while (left <= right) {
      if (!wordsMap.containsKey(num.charAt(left))) return false;
      else if (wordsMap.get(num.charAt(left)) != num.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String num = "808";
    boolean ret = isStrobogrammatic(num);
    System.out.print(ret);
  }
}
