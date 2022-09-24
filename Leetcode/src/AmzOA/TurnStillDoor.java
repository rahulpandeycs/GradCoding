package src.AmzOA;

//   Given a turnStill in Amazon go Store, return a list of integers where the value at index i is the time
//   when ith customer will pass the turnStill based on given conditions.
//   Input: numCustomer: integer representing number of customers,
//   arrTime: List of integers where the value at index i is the time in seconds when the ith customer will come to turnStill
//   direction: a list of integers where the value at index i is the direction of ith customer.

import java.util.Arrays;

public class TurnStillDoor {

        private static int[] amazonTurnStill(int numCustomers, int[] arrTime, int[] direction) {
        int[] output = new int[numCustomers];
        int previous = 1;
        int m = 0, n = 1, seconds = 0;

        while (n < numCustomers) {
            if (arrTime[n] == arrTime[m]) {
                if (direction[m] == previous) {
                    output[m] = seconds;
                    arrTime[n]++;
                    m = n;
                    n++;
                } else {
                    output[n] = seconds;
                    arrTime[m]++;
                    n++;
                }
            } else {
                output[m] = seconds;
                previous = direction[m];
                m = n;
                n++;
            }
            seconds++;
        }
        output[m] = Math.max(arrTime[m], seconds);
        return output;
    }

    public static void main(String[] args) {
        System.out.println("TurnStill(4): " + Arrays.toString(amazonTurnStill(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println("TurnStill(5): " + Arrays.toString(amazonTurnStill(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1})));
        System.out.println("TurnStill(5): " + Arrays.toString(amazonTurnStill(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1})));
    }
}
