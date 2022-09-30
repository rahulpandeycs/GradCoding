package src.AmzOA;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        val = val;
    }
}

public class AmazonOA {

    public static class Pair {
        public char from, to;
        public int cost;

        Pair(char from, char to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        // =====================getMaxUnit==============================
        /* An amazon warehouse manager needs to create a shipment to fill a truck. All of the products in
         the warehouse are in the boxes of same size. Each product is packed in some number od units per box.

         Given the number of boxes the truck can hold, write an algorithm to determine the maximum number
         of units of any mix of products that can be shipped.
         */
        int num = 3;
        List<Integer> boxes = Arrays.asList(1, 2, 3);
        int unitSize = 3;
        List<Integer> unitsPerBox = new ArrayList<>(Arrays.asList(3, 2, 1));
        int truckSize = 3;

        System.out.println(getMaxUnit(num, boxes, unitSize, unitsPerBox, truckSize));


        num = 5;
        boxes = (ArrayList<Integer>) Arrays.asList(1, 2, 3, 2, 1);
        unitSize = 3;
        unitsPerBox = Arrays.asList(3, 2, 1, 3, 2);
        truckSize = 4;

        System.out.println(getMaxUnit(num, boxes, unitSize, unitsPerBox, truckSize));
        // ======================Done=============================


        // ======================= CALLING MIN_SQUARED Distance Robots ===============

        System.out.println("Min Distance: " + getClosestDistanceBetweenPoints(3, Arrays.asList(0, 1, 2), Arrays.asList(0, 1, 4)));


        //==============================End ==========================================


        // ========================== Amazon TurnStile ===============================
//        https://leetcode.com/discuss/interview-question/798231/Amazon-or-OA-2020-or-Turnstile

        // Given a turnStill in Amazon go Store, return a list of integers where the value at index i is the time
        // when ith customer will pass the turnStill based on given conditions.
        // Input: numCustomer: integer representing number of customers,
        // arrTime: List of integers where the value at index i is the time in seconds when the ith customer will come to turnStill
        // direction: a list of integers where the value at index i is the direction of ith customer.

        System.out.println("TurnStill(4): " + Arrays.toString(amazonTurnStill(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println("TurnStill(5): " + Arrays.toString(amazonTurnStill(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1})));


        //=================================== Nearest City Shared ======================================================
        /*
        * Amazon has Fulfillment Centers in multiple cities within a large geographic region. The cities are arranged on a group that has been divided up like an ordinary Cartesian plane. Each city is located at an integral(x,y) coordinate intersection. City names and locations are given in the form of three arrays: c,x, and y, which are aligned by the index to provide the city name (c[i]), and its coordinates, (x[i],y[i]).
          Write an algorithm to determine the name of the nearest city that shares an x or a y coordinate with the queried city. If no cities share an x or y coordinate, return none. If two cities have the same distance to the queried city, q[i], consider the one with an alphabetically smaller name (e.e 'ab' < 'aba' < 'abb') as the closest choice.
          The distance is denoted on a Euclidean plan: the difference in x plus the difference in y.

          Input : the input to the function/method consists of six arguments:
          numOfCities, an integer representing the number of cities;
          cities, a list of strings representing the names of each city[i];
          xCoordinates, a list of integers representing the X-coordinates of each city[i];
          yCoordinates, a list of integers representing the Y-coordinates of each city[i];
          numOfQueries, an integer representing the number of queries;
          queries, a list of strings representing the names of the queried cities.
          *
          * Output
          Return a list of strings representing the name of the nearest city that shares either an x or a y coordinate
          * with the queried city.
        *
        * */

        java.util.List<String> result = findNearestSharedCity(3, Arrays.asList("c1", "c2", "c3"), Arrays.asList(3, 2, 1), Arrays.asList(3, 2, 3),
                3, Arrays.asList("c1", "c2", "c3"));
        System.out.println("Nearest Shared city: " + Arrays.toString(result.toArray()));

        // ============================================ End ===============================================


        // ============================================== Fetch Items ===============================================
        HashMap<String, PairInt> mapvalue = new HashMap<>();
        mapvalue.put("item1", new PairInt(10, 15));
        mapvalue.put("item2", new PairInt(3, 4));
        mapvalue.put("item3", new PairInt(17, 8));


        java.util.List<String> fetchResult = fetchItemsToDisplay(3, mapvalue, 1, 0, 2, 1);
        System.out.println("Sorted result for Fetch: " + Arrays.toString(fetchResult.toArray()));

        mapvalue.put("item5", new PairInt(5, 8));
        fetchResult = fetchItemsToDisplay(4, mapvalue, 1, 0, 2, 1);
        System.out.println("Sorted result for Fetch: " + Arrays.toString(fetchResult.toArray()));

        mapvalue.put("item6", new PairInt(10, 33));
        fetchResult = fetchItemsToDisplay(5, mapvalue, 1, 0, 2, 1);
        System.out.println("Sorted result for Fetch: " + Arrays.toString(fetchResult.toArray()));
        // ================================================= End ==========================================


        // ============================= getNegativeBalance ============================================
        java.util.List<debtRecord> input = new ArrayList<>();
        input.add(new debtRecord("Alex", "Blake", 2));
        input.add(new debtRecord("Blake", "Alex", 2));
        input.add(new debtRecord("Casey", "Alex", 5));
        input.add(new debtRecord("Blake", "Casey", 7));
        input.add(new debtRecord("Alex", "Blake", 4));
        input.add(new debtRecord("Alex", "Casey", 4));

        java.util.List negativeBalanceList = calculateSmallestNegative(6, 3, input);
        System.out.println("Negative list: " + Arrays.toString(negativeBalanceList.toArray()));

        // ======================================= End ===================================================


        //=========================================== Get Max profit Product ==============================
        System.out.println("The max Profit obtained is: " + maxProfitForGivenProduct(2, Arrays.asList(3l, 5l), 6));

        // ===================================== End ======================================================


        // =========================================== Substrings of size K with K distinct chars===========


        System.out.println("Substrings of size 6 with 3 distinct chars: " + Arrays.toString(count("abcabc", 3).toArray()));
        System.out.println("Substrings of size 6 with 3 distinct chars: " + Arrays.toString(count("abacab", 3).toArray()));
        System.out.println("Substrings of size ~ with 4 distinct chars: " + Arrays.toString(count("awaglknagawunagwkwagl", 4).toArray()));

        // ====================================== done =====================================================


        // ======================================= Amazon Fresh Promotion ===================================

        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7 = {{"anything", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9 = {{"anything", "anything", "anything", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        // test
        test(codeList1, shoppingCart1, 1);
        test(codeList2, shoppingCart2, 0);
        test(codeList3, shoppingCart3, 0);
        test(codeList4, shoppingCart4, 0);
        test(codeList5, shoppingCart5, 1);
        test(codeList6, shoppingCart6, 1);
        test(codeList7, shoppingCart7, 1);
        test(codeList8, shoppingCart8, 1);
        test(codeList9, shoppingCart9, 1);

        // =======================================  Done   ==================================================

        // ==================================== Critical Connections ========================================
        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println("Critical connections: " + getCriticalNodes(links1, numLinks1, numRouters1));
        System.out.println("Critical connection (True ?): " + getCriticalNodes(links1, numLinks1, numRouters1).equals(Arrays.asList(2, 3, 5)));
        // ======================================== Done ====================================================

        // ========================================== Minimum Cost ==========================================
        // num = 5
        // connection =
        // 	 [[A,B,1],
        // 	 [B,C,4],
        // 	 [B,D,6],
        // 	 [D,E,5],
        // 	 [C,E,1]]

        java.util.List<Pair> inputPairList = new ArrayList<>();
        inputPairList.add(new Pair('A', 'B', 1));
        inputPairList.add(new Pair('B', 'C', 4));
        inputPairList.add(new Pair('B', 'D', 6));
        inputPairList.add(new Pair('D', 'E', 5));
        inputPairList.add(new Pair('C', 'E', 1));

//           System.out.println("Minimum cost to connect:" + minimumCost(5, inputPairList ));
        System.out.println("Minimum cost to connect:" + Arrays.toString(minimumCost(5, inputPairList).toArray()));
        // ========================================== Done ==================================================


        // ========================================= Closest pair of point ==================================
        int[] x = new int[]{2, 12, 40, 5, 12, 3};
        int[] y = new int[]{3, 30, 50, 1, 10, 4};

        System.out.println("Min distance b/w points is: " + findMinDistance(6, x, y));
        System.out.println("Min distance b/w points is 2nd: " + findMinDistance(3, new int[]{0, 1, 2}, new int[]{0, 1, 4}));
        // =========================================== Done =================================================


        // ============================================ Find Largest Association ============================

        /**
         * Example 1
         */
        java.util.List<PairString> inputA = Arrays.asList(
                new PairString("item1", "item2"),
                new PairString("item3", "item4"),
                new PairString("item4", "item5"));

        java.util.List<String> lst = largestItemAssociation(inputA);
        for (String sa : lst) System.out.print(" " + sa);
        System.out.println();

        /**
         * Testing equal sized arraylist. 1->2->3->7 4->5->6->7
         */
        java.util.List<PairString> inputA2 = Arrays.asList(
                new PairString("item1", "item2"),
                new PairString("item2", "item3"),
                new PairString("item4", "item5"),
                new PairString("item6", "item7"),
                new PairString("item5", "item6"),
                new PairString("item3", "item7"));

        java.util.List<String> lst2 = largestItemAssociation(inputA2);
        for (String sa : lst2) System.out.print(" " + sa);
        System.out.println();
        /**
         * Testing duplicates: 1->2->3->7 , 5->6
         */
        java.util.List<PairString> inputA3 = Arrays.asList(
                new PairString("item1", "item2"),
                new PairString("item1", "item3"),
                new PairString("item2", "item7"),
                new PairString("item3", "item7"),
                new PairString("item5", "item6"),
                new PairString("item3", "item7"));

        java.util.List<String> lst3 = largestItemAssociation(inputA3);
        for (String sa : lst3) System.out.print(" " + sa);
        // ============================================ Done ================================================


        /*
        * Top K Frequently Mentioned Keywords
            Find the keywords that are most frequently mentioned in a given list of text snippets. Return a list of the top k most frequently mentioned keywords, sorted in increasing order by their frequency, ingnoring case sensitivity.
            A "mention" of a keyword happens when the keyword appears at least once in a text snippet. If a keyword appears more than once in a snippet, it only counts as one "mention". Sort alphabetically if multiple keywords are mentioned the same number of times.

            Input
            k: a number
            keywords: a list of words
            snippets: a list of text snippets, each containing a single contiguous paragraph

            Output
            A list of words sorted from most frequenly mentioned to least frequently mentioned.

            Examples
            Example 1:
            Input:
            k = 2

            keywords = ["gatsby", "american", "novel"]
            snippets = [
              "Classic. Yes. The great American novel. Hmph, so I heard.",
              "Most American high school students are assigned to read this novel.",
              "The Great Gatsby is often described as a paean to the Great American Dream",
            ]
            Output: ["american", "novel"]
        * */

        System.out.println("\n\nOUTPUT FOR TOP K FREQUENTLY");
        System.out.println(topMentioned(2, new ArrayList<>(Arrays.asList("gatsby", "american", "novel")), new ArrayList<>(
                Arrays.asList( "Classic. Yes. The great American novel. Hmph, so I heard.",
                        "Most American high school students are assigned to read this novel.",
                        "The Great Gatsby is often described as a paean to the Great American Dream")
        )));





         /*
         Items in Containers
        * A librarian would like to count the number of enclosed items in a row that are between two dividers. A row is represented by a string s, each item is a *, and a divider is represented by |. A list of range tuples are given that represent each substring to consider, and the number of enclosed items for each substring must be returned in a list.

         * = ascii number 42
        | = ascii number 124
        Example 1:
        Input: s = |**|*|*, ranges = [[0, 4], [1, 6]]
        Output: [1, 2]
        Explanation:
        The first range to consider is [0, 4] which corresponds to |**|*. There are 2 items in the first enclosed part.

        For the second range, [1, 6], the substring is **|*|*, which contain only one enclosed section with one item in it.

        Both of the answers are returned in an array, ie. [2, 1].

        Example 2:
        Input: s = *|*|, ranges = [[1, 3]]
        Output: [1]
        Explanation:
        The substring from index = 1 to index = 3 is |*|. There is only one item and it is surrounded by two dividers. Therefore, the output is [1].

        Constraints:
        There are no invalid characters, and each range is non-zero in size and always increasing. The ranges provided are always within the string bounds.
         *
       * */
        List<List<Integer>> ranges = new ArrayList<>();
        ranges.add(Arrays.asList(1,3));
        ranges.add(Arrays.asList(2,12));
        System.out.println("Items in Containers: " + numberOfItems("*|*|*****|*|**", ranges));

        ranges.clear();
        ranges.add(Arrays.asList(0,3));
        System.out.println("Items in Containers: " + numberOfItems("|**|***|", ranges));













        /*
        Autoscale Policy, Utilization
        * A risk modeling system uses a scaling computing system that implements an autoscale policy depending on the current load or utilization of the computing system.

        The system starts with a number of computing instances given by instances. The system polls the instances every second to see the average utilization at that second, and performs scaling as described below. Once any action is taken, the system will stop polling for 10 seconds. During that time, the number of instances does not change.

        Average utilization > 60%: Double the number of instances if the doubled value does not exceed 2 * 10^8. This is an action. If the number of instances exceeds this limit on doubling, perform no action.

        Average utilization < 25%: Halve the number of instances if the number of instances is greater than 1 (take ceil if the number is not an integer). This is also an action. If the number of instances is 1, take no action.

        25% <= Average utilization <= 60%: No action.

        Given an array of the values of the average utilization at each second for this system, determine the number of instances at the end of the time frame.

        For example, the system starts with instances = 2, and average utilization is given as averageUtil = [25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80].

        At the first second, utilization is 25, so no action is taken.

        At the second second, averageUtil[1] = 23 < 25, so instances = 2 / 2 = 1. The next 10 seconds, averageUtil[2]..averageUtil[11], no polling is done.

        At averageUtil[11] = 76, 76 > 60 so the number of instances is doubled. There are no more readings to consider and 2 is the final answer.

        Example 1:
        Input: averageUtil=[5, 10, 80], instances = 1
        Output: 2
        Explanation:
        Here instance = 1 and averageUtil = [5, 10, 80]. At the 1st and 2nd seconds of the time period, no action will be taken because the utilization is less than 25%, the number of instance is 1. At the 3rd second, the number of instances will double to 2.

        Constraints:
        1 <= instances <= 10^5
        1 <= n <= 10^5
        1 <= averageUtil[i] <= 100
        *
        * */


        System.out.println("Autoscale policy for: 5 10 80 Inst 1 ::::" + autoScale(Arrays.asList(5, 10, 80),1));
        System.out.println("Autoscale policy for: 25 23 1 2 3 4 5 6 7 8 9 10 76 80, inst 2 ::::" + autoScale(Arrays.asList(25, 23, 1, 2 ,3, 4, 5, 6 ,7 ,8 ,9, 10, 76, 80),2));
        System.out.println("Autoscale policy for: 80 10 20 30 50 inst 100000001 ::::" + autoScale(Arrays.asList(80, 10, 20, 30, 50),100000001));







        /*
        * Given a multiset (set that allows for multiple instances of same value), partition it into two multisets A and B such that the sum of A is greater than that of B. Return A. If more than one such As exists, return the one with minimal size.

        Examples
        Example 1:
        Input:
        nums = [4, 5, 2, 3, 1, 2]

        Output:
        [4, 5]

        Explanation:
        We can divide the numbers into two subsets A = [4, 5] and B = [1, 2, 2, 3]. The sum of A is 9 which is greater than the sum of B which is 8. There are other ways to divide but A = [4, 5] is of minimal size of 2.
        *
        * */

        System.out.println("Optimize weights::::::::::"+optimizingBoxWeights(Arrays.asList(1, 2, 5, 8, 3)));



        /*
        *
        *
        * */

        System.out.println( "Storage Optimization:: " +storageOptimization(3,3, Arrays.asList(2), Arrays.asList(2)));




        /*
        *
        * https://algo.monster/problems/amazon_oa_number_of_swaps_to_sort
        * */

        System.out.println("Number of Adjacent Swaps to Sort :: " + numberOfSwapsToSort(Arrays.asList(5, 4, 1, 2)));




        /*
        *
        * https://algo.monster/problems/amazon_oa_find_all_combination_of_numbers_sum_to_target
        *
        * */

        System.out.println("Number of possible Options/Sum to target ::" +
                numberOfOptions(Arrays.asList(2, 3, 5), Arrays.asList(5), Arrays.asList(2, 3, 10), Arrays.asList(1, 2),11));




        /*
        * Count Split String Into Unique Primes
        *
        * Given a string made up of integers 0 to 9, count the number of ways to split the string into prime numbers in the range of 2 to 1000 inclusive, using up all the characters in the string.

            Each prime number, pn, must not contain leading 0s, and 2 <= pn <= 1000.

            Constraints
            The input string does not contain any leading 0s.

            Examples
            Example 1:
            Input: "31173"
            Output: 6
            Explanation:
            The string "31173" can be split into prime numbers in 6 ways:

            [3, 11, 7, 3]
            [3, 11, 73]
            [31, 17, 3]
            [31, 173]
            [311, 7, 3]
            [311, 73]
        * */
    }


    /***********************************************************************************************
     *  SOLUTIONS
     **********************************************************************************************/

    /***************************Split String Into Unique Primes****************************************/







    /*********************************************************************/



    /*******************Sum to target************************************/


    public static int numberOfOptions(List<Integer> a, List<Integer> b, List<Integer> c, List<Integer> d, int limit) {

        List<Integer> ab = new ArrayList<>();
        List<Integer> cd = new ArrayList<>();

        for(int val_a : a){
            for(int val_b : b){
                int sum = val_a + val_b;
                if(sum <= limit) ab.add(sum);
            }
        }

        for(int val_c : c){
            for(int val_d : d){
                int sum = val_c + val_d;
                if(sum <= limit) cd.add(sum);
            }
        }

        Collections.sort(ab);
        Collections.sort(cd);

        int count = 0;

        for(int abSum : ab){
            int rem = limit - abSum;
            int index = bisect_right(cd.stream().mapToInt(i->i).toArray(), rem, 0, cd.size());
            if(index < 0) index = -index +1;
            count += index;
        }

        return count;
    }

    private static int bisect_right(int[] A, int x, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (x < A[mid]) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }















    /********************End*******************************************/

















    /**********************************************************************************************/

    public static int numberOfSwapsToSort(List<Integer> nums) {  // O(nlogn)

        int[] arr = nums.stream().mapToInt(i->i).toArray();
        return mergeSortAlgo(arr, new int[arr.length], 0, arr.length-1);
    }

    // This function merges two sorted arrays and returns inversion count in the arrays.
    static int merge(int []arr, int []temp,
                     int left, int mid,
                     int right)
    {
        int inv_count = 0;

    /* i is index for left subarray*/
        int i = left;

    /* i is index for right subarray*/
        int j = mid;

    /* i is index for resultant merged subarray*/
        int k = left;

        while ((i <= mid - 1) &&
                (j <= right))
        {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
            {
                temp[k++] = arr[j++];

            /* this is tricky -- see above /
            explanation diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

    /* Copy the remaining elements of left subarray (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

    /* Copy the remaining elements of right subarray (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

    /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }

    // An auxiliary recursive function that sorts the input array and returns the number of inversions in the array.
    static int mergeSortAlgo(int []arr, int []temp,
                             int left, int right)
    {
        int mid, inversion_count = 0;
        if (right > left)
        {
            // Divide the array into two parts and call _mergeSort and countInv() or each of the parts
            mid = (right + left) / 2;

            /* Inversion count will be sum of  inversions in left-part, right-part and number of inversions in merging */
            inversion_count = mergeSortAlgo(arr, temp,
                    left, mid);

            inversion_count += mergeSortAlgo(arr, temp, mid + 1, right);

            /*Merge the two parts*/
            inversion_count += merge(arr, temp, left, mid + 1, right);
        }

        return inversion_count;
    }













    /********************************************************************/












    public static int storageOptimization(int h, int w, List<Integer> horizontalCuts, List<Integer> verticalCuts) {

        int[] hz = horizontalCuts.stream().mapToInt(i->i).toArray();
        int[] v = verticalCuts.stream().mapToInt(i->i).toArray();
        return (longestConsecutive(hz, hz.length)+1) * (longestConsecutive(v,v.length)+1);
    }

    static int longestConsecutive(int arr[], int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1))
            {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }








    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {

        Collections.sort(arr, Collections.reverseOrder());
        int totalSum = arr.stream().mapToInt(i->i).sum();

        int sum = 0;
        List<Integer> output = new ArrayList<>();

        for(int i=0; i < arr.size(); i++){
            sum += arr.get(i);
            output.add(arr.get(i));
            if(sum > totalSum/2) break;
        }
        return output;
    }

    public int[] optimizingBoxWeight(int[] nums) {

        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(arr, Collections.reverseOrder());
        int totalSum = arr.stream().mapToInt(i->i).sum();

        int sum = 0;
        List<Integer> output = new ArrayList<>();

        for(int i=0; i < arr.size(); i++){
            sum += arr.get(i);
            output.add(arr.get(i));
            if(sum > totalSum/2) break;
        }
        return output.stream().mapToInt(i->i).toArray();
    }


    public static int autoScale(List<Integer> averageUtils, int numInstances) {

        int instance = numInstances;
        for(int i=0; i < averageUtils.size(); i++){
            int currentLoad = averageUtils.get(i);
            if(currentLoad >= 25 && currentLoad <= 60) continue;
            else if(currentLoad < 25){
                if(instance == 1) continue;
                instance = (int)Math.ceil((double)instance/2.0);
                i = Math.min(i+10, averageUtils.size()-1);
            }else if(currentLoad > 60){
                if(instance*2 >  2 * Math.pow(10,8)) continue;
                instance *= 2;
                i = Math.min(i+10, averageUtils.size()-1);
            }
        }
        return instance;
    }



    public static List<Integer>     numberOfItems(String s, List<List<Integer>> ranges) {

        List<Integer> output = new ArrayList<>();
        for(List<Integer> range : ranges){
            int start = range.get(0);
            int end = range.get(1);

            boolean flag = false;
            int tempCount = 0, totalCount = 0;
            while(start <= end){
                if(s.charAt(start) == '|' && !flag){
                    flag = true;
                    start++;
                }else if(s.charAt(start) == '|' && flag){
                    flag = false;
                    totalCount += tempCount;
                    tempCount = 0;
                }else {
                    if(flag) tempCount++;
                    start++;
                }
            }
            output.add(totalCount);
        }
        return output;
    }




    public static List<String> topMentioned(int k, List<String> keywords, List<String> reviews) {

        List<String> output = new ArrayList<>();
        Map<String,Integer> mp = new HashMap<>();
        for(String review : reviews){
            String[] strArray = review.split(" ");
            for(String str : strArray){
                if(str.length() > 0) str = str.toLowerCase().split("[.]")[0];
                if(keywords.contains(str)) mp.put(str, mp.getOrDefault(str,0)+1);
            }
        }

        PriorityQueue<Map.Entry<Integer,String>> pq = new PriorityQueue<>((a,b)-> {
            if(a.getKey() != b.getKey()){
               return b.getKey()-a.getKey();
            }
            return a.getValue().compareTo(b.getValue());
        });

        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            pq.add(new AbstractMap.SimpleEntry<Integer,String>(entry.getValue(), entry.getKey()));
        }

        while(!pq.isEmpty() && k > 0){
            output.add(pq.poll().getValue());
            k--;
        }

        return output;
    }


    public static void test(String[][] codeList, String[] shoppingCart, int expect) {
        System.out.println(winPrize(codeList, shoppingCart) == expect);
    }

    static TreeNode maxNode = null;
    double max = Integer.MIN_VALUE;

    static TreeNode maximumAverageTreeNode(TreeNode root) {
        if (root == null) return null;
        helperDfs(root);
        return maxNode;
    }

    static double[] helperDfs(TreeNode root) {

        if (root == null) return new double[]{0, 0};

        // for(root.)
        return new double[]{0, 0};
    }


//    ================================ MAX_UNIT ========================

    static long getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            int currBox = boxes.get(i);
            for (int k = 0; k < currBox; k++) {
                pq.add(unitsPerBox.get(i));
                if (pq.size() > truckSize) pq.poll();
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            count += pq.poll();
        }
        return count;
    }
// =====================================================================


    // ================================ Closest point =======================
    static double getClosestDistanceBetweenPoints(int numRobots, List<Integer> positionX, List<Integer> positionY) {
        double MIN = Integer.MAX_VALUE;
        for (int i = 0; i < numRobots; i++) {
            for (int j = i + 1; j < numRobots; j++) {
                double currDist = distance(new int[]{positionX.get(i), positionY.get(i)}, new int[]{positionX.get(j), positionY.get(j)});
                if (MIN > currDist) {
                    MIN = currDist;
                }
            }
        }
        return MIN;
    }

    static float distance(int[] pointA, int[] pointB) {
        return ((pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]));
    }

//    =============================================== End =====================


// ========================================= TurnStill =============================

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

    // ============================================End =============================

    // ===================  Nearest Shared city =====================================

    private static java.util.List<String> findNearestSharedCity(int numOfCities, java.util.List<String> cities, java.util.List<Integer> xCoordinates,
                                                                java.util.List<Integer> yCoordinates, int numOfQueries, List<String> queries) {

        Map<String, Integer> cityMap = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();

        int index = 0;

        for (String city : cities)
            cityMap.put(city, index++);

        for (String query : queries) {
            String closestCity = null;
            int closedDistance = 0;

            int queryX = xCoordinates.get(cityMap.get(query));
            int queryY = yCoordinates.get(cityMap.get(query));

            for (String city : cities) {
                int currX = xCoordinates.get(cityMap.get(city));
                int currY = yCoordinates.get(cityMap.get(city));
                int currDistance = mahattanDistance(queryX, queryY, currX, currY);
                if (city != query && (queryX == currX || queryY == currY)) {
                    if (closestCity == null || currDistance < closedDistance || ((currDistance == closedDistance) && city.compareTo(closestCity) < 0)) {
                        closestCity = city;
                        closedDistance = currDistance;
                    }
                }
            }
            output.add(closestCity);
        }
        return output;
    }

    private static int mahattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    // ===================  End ======================================================


    //    =================================== Fetch Items to display ============================
    private static class PairInt {
        int relevance;
        int price;

        PairInt(int relevance, int price) {
            this.relevance = relevance;
            this.price = price;
        }

        int getRelevance() {
            return this.relevance;
        }

        int getPrice() {
            return this.price;
        }
    }

    static class item {
        String itemName;
        PairInt pairs;

        item(String itemName, PairInt pairs) {
            this.itemName = itemName;
            this.pairs = pairs;
        }

        String getItemName() {
            return this.itemName;
        }

        PairInt getPairs() {
            return this.pairs;
        }
    }

    static java.util.List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, PairInt> items, int sortParameter, int sortOrder
            , int itemsPerPage, int pageNumber) {

        item[] sortedItems = new item[numOfItems];
        int index = 0;

        for (Map.Entry<String, PairInt> entry : items.entrySet()) {
            sortedItems[index++] = new item(entry.getKey(), entry.getValue());
        }

        PriorityQueue<item> sortedValue = new PriorityQueue<>((item item1, item item2) -> {
            if (sortParameter == 0) {
                return sortOrder == 0 ? item1.getItemName().compareTo(item2.getItemName()) :
                        item2.getItemName().compareTo(item1.getItemName());

            } else {
                int compValue = sortParameter == 1 ? item1.getPairs().getRelevance() : item1.getPairs().getPrice();
                int compValue2 = sortParameter == 1 ? item2.getPairs().getRelevance() : item2.getPairs().getPrice();

                return sortOrder == 0 ? compValue - compValue2 : compValue2 - compValue;
            }
        });

        for (item currItem : sortedItems) {
            sortedValue.add(currItem);
        }

        int itemsToSkip = itemsPerPage * pageNumber;
        while (itemsToSkip > 0) {
            sortedValue.poll();
            itemsToSkip--;
        }

        java.util.List<String> output = new ArrayList<>();
        int toBeAdded = itemsPerPage;
        while (!sortedValue.isEmpty() && toBeAdded > 0) {
            output.add(sortedValue.poll().itemName);
            toBeAdded--;
        }
        return output;

        // Another code
        /*

         List<List<String>> listOfItems = new ArrayList<>();

    PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
        if(sortParameter == 0) {
            if(sortOrder == 0) {
                return a.compareTo(b);
            } else {
                return b.compareTo(a);
            }
        } else if(sortParameter == 1) {
            if(sortOrder == 0) {
                return items.get(a).relevance -items.get(b).relevance;
            } else {
                return items.get(b).relevance -items.get(a).relevance;
            }
        } else {
            if(sortOrder == 0) {
                return items.get(a).price-items.get(b).price;
            } else {
                return items.get(b).price-items.get(a).price;
            }
        }
    });

    queue.addAll(items.keySet());

    int currPage = 0;
    int currItemNumber = 0;
    listOfItems.add(new ArrayList<>());
    while (!queue.isEmpty()) {
        String temp = queue.poll();
        if(currItemNumber == itemsPerPage) {
            listOfItems.add(new ArrayList<>());
            currPage++;
            currItemNumber = 0;
        }
        listOfItems.get(currPage).add(temp);
        currItemNumber++;
    }

    if(pageNumber>=listOfItems.size()) return new ArrayList<>();

    return listOfItems.get(pageNumber);
         */

    }

//    =============================================end=======================================


    // ========================= smallest negative balance. ===================================

    public static class debtRecord {
        String borrower = "";
        String lender = "";
        int amount = 0;

        debtRecord() {
            // empty constructor
        }

        debtRecord(String borrower, String lender, int amount) {
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
        }
    }

    static java.util.List<String> calculateSmallestNegative(int numRows, int numCols, java.util.List<debtRecord> debts) {
        int MIN_VALUE = Integer.MAX_VALUE;

        java.util.List<String> output = new ArrayList<>();
        Map<String, Integer> balances = new HashMap<>();

        for (debtRecord record : debts) {
            balances.put(record.borrower, balances.getOrDefault(record.borrower, 0) - record.amount);
            balances.put(record.lender, balances.getOrDefault(record.lender, 0) + record.amount);
        }
        MIN_VALUE = balances.entrySet().stream().mapToInt(balance -> balance.getValue()).min().getAsInt();

        for (Map.Entry<String, Integer> entry : balances.entrySet()) {
            if (MIN_VALUE < 0 && entry.getValue() == MIN_VALUE)
                output.add(entry.getKey());
        }

        Collections.sort(output);
        if (output.isEmpty())
            output.add("Nobody has a negative balance");
        return output;
    }

    // ============================ End =======================================================


    // ==============================  Highest profit for given product =========================
//https://leetcode.com/discuss/interview-question/799615/Amazon-OA2-New-Grad-2021-or-Sorting-Problem
    static long maxProfitForGivenProduct(int numSuppliers, List<Long> inventory, long order) {

        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
        for (long value : inventory) {
            maxHeap.add(value);
        }

        long profit = 0;
        while (!maxHeap.isEmpty() && order > 0) {
            long currValue = maxHeap.poll();
            profit += currValue--;
            maxHeap.add(currValue);
            order--;
        }
        return profit;
    }
    // ===============================  End  ====================================================


    // ====================================== Substring of Size K with K distinct characters =================
    public static ArrayList<String> count(String s, int k) {
        int distinct = 0, index = 0;
        int[] charCount = new int[26];

        Set<String> output = new HashSet<>();

        if(s.length() < k) return new ArrayList<>(output);

        for (; index < k; index++) {
            if (charCount[s.charAt(index) - 'a'] == 0) {
                distinct++;
            }
            charCount[s.charAt(index) - 'a']++;
        }

        if (distinct == k)
            output.add(s.substring(index - k, index));

        while (index < s.length()) {
            if (charCount[s.charAt(index) - 'a'] == 0)
                distinct++;
            charCount[s.charAt(index) - 'a']++;
            charCount[s.charAt(index - k) - 'a']--;
            if (charCount[s.charAt(index - k) - 'a'] == 0)
                distinct--;
            if (distinct == k)
                output.add(s.substring(index - k + 1, index + 1));
            index++;
        }
        return new ArrayList<>(output);
    }

    // ==================================================== Done =============================================

    // ========================================== Amazon Fresh Promotion =====================================

    public static int winPrize(String[][] codeList, String[] shoppingCart) {

        if (codeList == null || codeList.length == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.length == 0)
            return 1;

        int index1 = 0, index2 = 0;
        while (index1 < codeList.length && index2 + codeList[index1].length <= shoppingCart.length) {
            boolean match = true;
            for (int k = 0; k < codeList[index1].length; k++) {
                if (!codeList[index1][k].equals("anything") && !shoppingCart[index2 + k].equals(codeList[index1][k])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                index2 += codeList[index1].length;
                index1++;
            } else {
                index2++;
            }
        }
        return (index1 == codeList.length) ? 1 : 0;
    }

    // ================================================== Done ===============================================

    // ================================================= Critical connections ================================
    static int time = 0;

    private static java.util.List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
        time = 0;
        Map<Integer, Set<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < numRouters; i++) {
            mapping.put(i, new HashSet<>());
        }
        for (int[] link : links) {
            mapping.get(link[0]).add(link[1]);
            mapping.get(link[1]).add(link[0]);
        }

        Set<Integer> resultSet = new HashSet<>();
        int[] arrLowLinks = new int[numRouters];
        int[] arrIds = new int[numRouters];
        int[] arrParent = new int[numRouters];
        Arrays.fill(arrParent, -1);
        Arrays.fill(arrIds, -1);
        for (int i = 0; i < numRouters; i++) {
            if (arrIds[i] == -1)
                dfs(mapping, arrLowLinks, arrIds, arrParent, i, resultSet);
        }
        return new ArrayList<>(resultSet);
    }

    private static void dfs(Map<Integer, Set<Integer>> mapping, int[] arrLowLinks, int[] arrIds, int[] arrParent, int current, Set<Integer> resultSet) {
        int children = 0;
        arrIds[current] = arrLowLinks[current] = ++time;
        for (int child : mapping.get(current)) {
            if (arrIds[child] == -1) {
                children++;
                arrParent[child] = current;
                dfs(mapping, arrLowLinks, arrIds, arrParent, child, resultSet);
                arrLowLinks[current] = Math.min(arrLowLinks[current], arrLowLinks[child]);
                if ((arrParent[current] == -1 && children > 1) || (arrParent[current] != -1 && arrLowLinks[child] >= arrIds[current]))
                    resultSet.add(current);
            } else if (child != arrParent[current]) {
                arrLowLinks[current] = Math.min(arrLowLinks[current], arrIds[child]);
            }
        }
    }
    // ==================================================  Done ==============================================


    // =============================================== Minimum cost to connect cities ========================
    static char[] parent;
    static int n;

    private static void union(char x, char y) {
        char px = find(x);
        char py = find(y);

        if (px != py) {
            parent[px] = py;
            n--;
        }
    }

    private static char find(char x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    public static java.util.List<String> minimumCost(int N, java.util.List<Pair> connections) {
        java.util.List<String> output = new ArrayList<>();

        parent = new char[65 + N + 1];
        n = N;

        for (char i = 'A'; i <= (65 + N); i++) {
            parent[i] = i;
        }

        Collections.sort(connections, (a, b) -> (a.cost - b.cost));

        int res = 0;
        for (Pair c : connections) {
            char x = c.from, y = c.to;
            if (find(x) != find(y)) {
//                output.add(new Pair(c.from,c.to,c.cost));
                output.add(c.from + "," + c.to + "," + c.cost);
                res += c.cost;
                union(x, y);
            }
        }

        return output;
    }

    // ==================================================== Done =============================================


    // ================================= Minimum number of distinct elements after removing m items ==========


    // ==================================================== Done =============================================

    // ================================================ Maximum Tenure Finder ================================
    static class Pair1 {
        int totalNodes, totalSum;

        Pair1(int total, int sum) {
            this.totalNodes = total;
            this.totalSum = sum;
        }
    }

    public static int maxTenureNode;
    public static Pair1 maxSum;

    public static Pair1 findHighestTenure(HashMap<Integer, ArrayList<Integer>> root, int V) {
        if (root.get(V).size() == 0) {
            return new Pair1(1, V);
        } else {
            int totalNodesCount = 1;
            int totalSum = V;
            for (int i = 0; i < root.get(V).size(); i++) {
                Pair1 temp = findHighestTenure(root, root.get(V).get(i));
                totalNodesCount += temp.totalNodes;
                totalSum += temp.totalSum;
            }

            if (totalSum * maxSum.totalNodes >= maxSum.totalSum * totalNodesCount) { // logic to avoid precision error
                maxSum.totalNodes = totalNodesCount;
                maxSum.totalSum = totalSum;
                maxTenureNode = V;
            }

            return new Pair1(totalNodesCount, totalSum);
        }
    }

    // ============================================= Done =====================================================

    // ==========================================  Closest pair of points =====================================

    private static int findMinDistance(int numRobots, int[] positionX, int[] positionY) {
        int[][] pointsInPlane = new int[numRobots][2];

        for (int i = 0; i < positionX.length; i++) {
            pointsInPlane[i] = new int[]{positionX[i], positionY[i]};
        }

        Arrays.sort(pointsInPlane, (o1, o2) -> o1[0] - o2[0]);
        return minDistance(pointsInPlane, 0, pointsInPlane.length, pointsInPlane.length);
    }

    private static int minDistance(int[][] pointsInPlane, int left, int right, int n) {

        if (n <= 3) {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (dist(pointsInPlane[i], pointsInPlane[j]) < minValue) {
                        minValue = (dist(pointsInPlane[i], pointsInPlane[j]));
                    }
                }
            }
            return minValue;
        }

        int mid = n / 2;
        int[] midPoint = pointsInPlane[mid];

        int dl = minDistance(pointsInPlane, left, mid, mid);
        int dr = minDistance(pointsInPlane, mid, right, n - mid);
        int d = Math.min(dl, dr);

        java.util.List<int[]> strip = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(pointsInPlane[i][0] - midPoint[0]) < d)
                strip.add(pointsInPlane[i]);
        }

        return Math.min(d, stripClosest(strip, strip.size(), d));
    }

    private static int dist(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    private static int stripClosest(java.util.List<int[]> strip, int size, int d) {
        int minVal = d;
        Collections.sort(strip, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < size; i++) {
            int j = i + 1;
            while (j < size && ((strip.get(j)[1] - strip.get(i)[1]) < minVal)) {
                minVal = dist(strip.get(i), strip.get(j));
                j += 1;
            }
        }
        return minVal;
    }

    // =================================================  Done  ===============================================

    // =============================================== ========================================
    public static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static java.util.List<String> largestItemAssociation(java.util.List<PairString> itemAssociation) {
        Map<String, java.util.List<String>> associationMap = new HashMap<>();
        //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
        for (PairString p : itemAssociation) {
            if (!associationMap.containsKey(p.first)) {
                associationMap.put(p.first, new ArrayList<>());
            }
            associationMap.get(p.first).add(p.second);
            if (!associationMap.containsKey(p.second)) {
                associationMap.put(p.second, new ArrayList<>());
            }
        }
        //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
        Map<Integer, java.util.List<java.util.List<String>>> sizeMap = new HashMap<>();
        int maxassoc = Integer.MIN_VALUE;
        for (String key : associationMap.keySet()) {
            Queue<String> q = new LinkedList<>();
            TreeSet<String> temp = new TreeSet<>();
            q.offer(key);
            while (!q.isEmpty()) {
                String head = q.poll();
                temp.add(head);
                java.util.List<String> tail = associationMap.get(head);
                for (String t : tail) {
                    q.offer(t);
                }
            }
            int size = temp.size();
            maxassoc = Math.max(maxassoc, size);
            if (!sizeMap.containsKey(size)) {
                sizeMap.put(size, new ArrayList<>());
            }
            sizeMap.get(size).add(new ArrayList<>(temp));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        java.util.List<java.util.List<String>> maxAssociationList = sizeMap.get(maxassoc);

        Collections.sort(maxAssociationList, new Comparator<java.util.List<String>>() {
            @Override
            public int compare(java.util.List<String> o1, java.util.List<String> o2) {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; i++) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });

        return maxAssociationList.get(0);
    }

    // ================================================= Done ================================================
}
