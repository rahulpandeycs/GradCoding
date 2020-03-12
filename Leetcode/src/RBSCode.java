import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RBSCode {

  static int[] findDuplicates(int[] input) {
    int bit = 1, count = 0;
    List<Integer> output = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      if ((bit & (1 << (input[i]))) == 0) {
        output.add(input[i]);
        bit |= 1 << input[i];
      }
    }
    return output.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3, 5, 4, 1, 5, 2, 6, 11, 9, 22, 3, 11, 22};
    System.out.println(Arrays.toString(findDuplicates(input)));
  }
}
