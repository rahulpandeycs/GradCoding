import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> output = new ArrayList<>();
    int rangeEle = lower;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] < rangeEle) continue;

      if (nums[j] == rangeEle) {
        rangeEle++;
        continue;
      }

      output.add("" + (rangeEle == nums[j] - 1 ? rangeEle : rangeEle + "->" + (nums[j] - 1)));
      rangeEle = nums[j] + 1;
    }

    if (rangeEle <= upper)
      output.add("" + (rangeEle == upper ? rangeEle : rangeEle + "->" + upper));
    return output;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 3, 50, 75};
    System.out.println(findMissingRanges(nums, 0, 99).toString());
  }
}
