package src.AmzOA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniquePoints {

    static int getUniquePoints(int[] inputArr) {
        Arrays.sort(inputArr);
        Set<Double> uniquePoints = new HashSet<>();
        for(int i=0; i < inputArr.length/2; i++) {
            uniquePoints.add((inputArr[i]+inputArr[inputArr.length-i-1])/2.0);
        }
        return uniquePoints.size();
    }

    public static void main(String[] args) {
        System.out.println(getUniquePoints(new int[]{1,1,1,1,1,1}));
        System.out.println(getUniquePoints(new int[]{1,4,1,3,5,6}));
    }
}
