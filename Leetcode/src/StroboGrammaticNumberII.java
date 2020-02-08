import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StroboGrammaticNumberII {

  //https://leetcode.com/problems/strobogrammatic-number-ii/
  //https://leetcode.com/problems/strobogrammatic-number-ii/discuss/67280/AC-clean-Java-solution

  public static List<String> findStroboGrammaticImpl(int n) {
    return findStroboGrammaticImplRecursive(n, n);
  }

  public static List<String> findStroboGrammaticImplRecursive(int currentLevel, int endLevel) {

        if(currentLevel == 0) return new ArrayList<>(Arrays.asList(""));
        if(currentLevel == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> recursiveOutput = findStroboGrammaticImplRecursive(currentLevel -2, endLevel);
        List<String> tempList = new ArrayList<>();
        for(int k = 0 ; k < recursiveOutput.size(); k++){
            String current = recursiveOutput.get(k);
            if(currentLevel != endLevel) tempList.add("0" + current + "0");
               tempList.add("1" + current + "1");
               tempList.add("6" + current + "9");
               tempList.add("8" + current + "8");
               tempList.add("9" + current + "6");
        }
        return tempList;
  }
  public static void main(String[] args) {
    int n = 4;
    List<String> ret = findStroboGrammaticImpl(n);
    String out = ret.toString();
    System.out.print(out);
    }

}
