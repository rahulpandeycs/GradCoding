package src;

import java.util.Arrays;

public class CheckRotatedArray {
    static boolean isRotated(int[] arr, int[] check){
        if(arr.length < check.length)
            return false;

        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == check[j]) {
                j++;
            } else
                j = 0;
            if (j == check.length)
                return true;
        }
        return j==check.length;
    }
    public static void main(String[] args) {
//        int[] input = new int[]{1, 2, 3, 4};
//        int[] check = new int[]{3, 2, 1, 4};

        int[] input = new int[]{1, 2, 3, 4};
        int[] check = new int[]{3, 4, 1, 2};
        int[] doubleInput  = new int[input.length*2];
        int k =0;

        for(int i =0; i < doubleInput.length; i++){
            if(k == input.length)
               k=0;
            doubleInput[i] = input[k++];
        }
        System.out.println(Arrays.toString(doubleInput));
        System.out.println(isRotated(doubleInput,check));
    }
}
