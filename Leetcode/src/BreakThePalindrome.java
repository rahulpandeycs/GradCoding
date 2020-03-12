public class BreakThePalindrome {

  //  https://leetcode.com/problems/break-a-palindrome/
  public String breakPalindrome(String palindrome) {

    char[] charArray = palindrome.toCharArray();
    int len = charArray.length;

    for (int j = 0; j < len / 2; j++) {
      if (charArray[j] != 'a') {
        charArray[j] = 'a';
        return String.valueOf(charArray);
      }
    }

    charArray[len - 1] = 'b';
    return len < 2 ? "" : String.valueOf(charArray);
  }
}
