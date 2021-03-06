import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class validWordSquare {
  // https://leetcode.com/problems/valid-word-square/discuss/91150/Highly-Readable-Code-in-Java
// https://leetcode.com/problems/valid-word-square/
  public static boolean validWordSquareImpl(List<String> words) {

    for (int i = 0; i < words.size(); i++) {
      if (!words.get(i).equals(getVerticalString(i, words)))
        return false;
    }
    return true;
  }

  private static String getVerticalString(int col, List<String> words) {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < words.size(); j++) {
      String colString = words.get(j);
      if (col < colString.length())
        sb.append(colString.charAt(col));
    }
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    List<String> words = Arrays.asList("abcd", "bnrt", "crmy", "dtye");
    boolean ret = validWordSquareImpl(words);
    System.out.print(ret);
  }
}
