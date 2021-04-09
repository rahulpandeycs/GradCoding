package src.AmzOA;

import java.util.*;

public class PrimeAirRoute {

    //Time Complexity : 0(nlogn)
    //Space Complexity : O(n)

    /*
    *   This problem is a variant of closest pair sum. You'll be given two arrays
        arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
        arr2 = { { 1, 5000 }, {2, 3000} }
        the first element of every pair represents id and the second value represents the value.
        and a target x = 5000
        Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be close to the target.

        Output for the above example:
        { {1, 2} } // Note that the output should be in id's
    * */
    public static void main(String[] args) {
        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int arr2[][] = { { 1, 5000 }, {2, 3000} };


        List<int[]> re = getClosestPairs(arr1, arr2, 7500);

        for(int[] r : re)
        {
            System.out.println(r[0] + " " + r[1]);
        }


        System.out.println("Second output:");
        arr1 = new int[][]{{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}};
        arr2 = new int[][]{{1, 2000}, {2, 3000}, {3, 4000},{4, 5000}};

        re = getClosestPairs(arr1, arr2, 10000);

        for(int[] r : re)
        {
            System.out.println(r[0] + " " + r[1]);
        }
    }


    private  static List<int[]> getClosestPairs(int[][] A, int[][] B, int target)
    {

        TreeMap<Integer, List<Integer>> valueToIdMap = new TreeMap<>();
        List<int[]> output = new ArrayList<>();

        int currClosestTarget = 0;

  /*
       Loop through the first Array and insert the values into the map with 'value' (A[1]) as key and id (A[0]) add to the list as value.
  */
        for(int[] ele_a  : A)
        {
            int currentTarget = ele_a[1], id = ele_a[0];
            valueToIdMap.putIfAbsent(currentTarget, new ArrayList<>());
            valueToIdMap.get(currentTarget).add(id);
        }


        for(int[] ele_B : B)
        {
            int remainingTarget = target - ele_B[1];  // We will find the remaining target by the value from the value of B.
            // For example if target = 5000, b[1] = 3000, then remainingTarget = 2000

            if(remainingTarget < 0) continue;

            if(valueToIdMap.containsKey(remainingTarget)) // That means we find the closest target == currentTarget
            {
                if(currClosestTarget != target)
                {
                    currClosestTarget = target;
                    output = new ArrayList<>();
                }

                for(int id : valueToIdMap.get(remainingTarget) )
                {

                    output.add(new int[] {id, ele_B[0]});
                }

            }

            else
            {
                Integer floor = valueToIdMap.floorKey(remainingTarget);  // Check if we have any least value which is less than remainingTarget.

                if(floor == null) continue;

                int currentTarget = ele_B[1] + floor;

                if(  currentTarget >= currClosestTarget )
                {
                    if(currentTarget != currClosestTarget)
                    {
                        currClosestTarget = currentTarget;
                        output = new ArrayList<>();
                    }

                    for(int id : valueToIdMap.get(floor) )
                    {
                        output.add(new int[] {id, ele_B[0]});
                    }
                }

            }
        }


        return output;
    }
}
