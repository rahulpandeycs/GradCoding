public class minimumDeletionToMakePalindrome {

  // https://leetcode.com/discuss/interview-question/371677/Google-or-Onsite-or-Min-Deletions-to-Make-Palindrome/334446

  // If all characters are allowed and all deletions are counted
  //https://leetcode.com/problems/remove-palindromic-subsequences/

  public int removePalindromeSub(String s) {
    int count = 0;

    int[][] dpArray = new int[s.length() + 1][s.length() + 1];

    for (int k = s.length() - 1; k >= 0; k--) {
      dpArray[k][k] = 1;
      for (int l = k + 1; l < s.length(); l++) {
        if (s.charAt(k) == s.charAt(l)) {
          dpArray[k][l] = dpArray[k + 1][l - 1] + 2;
        } else {
          dpArray[k][l] = Math.max(dpArray[k + 1][l], dpArray[k][l - 1]);
        }
      }
    }

    if (s.length() > 0)
      if (s.length() - dpArray[0][s.length() - 1] < s.length())
        count = s.length() - dpArray[0][s.length() - 1] + 1;
      else
        count = s.length() - dpArray[0][s.length() - 1];

    return count;
  }
}
