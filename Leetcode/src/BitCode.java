import java.util.Arrays;

public class BitCode {

  static int[] patternCode(int[] input) {
    int[] output = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      for (int j = i; j < input.length; j++) {
        output[i] += input[j];
      }
    }
    return output;
  }

  static int patternCodeWithBit(int Abit, int[] input) {

    //Assumption the value is input is between 1-32
    int res = 1;
    for (int i = Abit + 1; i < input.length; i++) {
      res = res | ((res & input[i]) << 1);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(patternCode(input)));
    System.out.println("With Bit");
    int[] input2 = new int[]{1, 2, 3, 4, 5};
    System.out.println(patternCodeWithBit(1, input2));

  }
}
