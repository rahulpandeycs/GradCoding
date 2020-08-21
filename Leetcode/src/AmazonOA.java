package src;

import com.sun.tools.javac.util.List;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        val =val;
    }
}
public class AmazonOA {

    public static void main(String[] args) {



        // =====================getMaxUnit==============================
        /* An amazon warehouse manager needs to create a shipment to fill a truck. All of the products in
         the warehouse are in the boxes of same size. Each product is packed in some number od units per box.

         Given the number of boxes the truck can hold, write an algorithm to determine the maximum number
         of units of any mix of products that can be shipped.
         */
        int num = 3;
        ArrayList<Integer> boxes = new ArrayList<>(List.of(1, 2, 3));
        int unitSize = 3;
        ArrayList<Integer> unitsPerBox = new ArrayList<>(List.of(3, 2, 1));
        int truckSize = 3;

        System.out.println(getMaxUnit(num,boxes,unitSize,unitsPerBox,truckSize));


        num = 5;
        boxes = new ArrayList<>(List.of(1, 2, 3, 2, 1));
        unitSize = 3;
        unitsPerBox = new ArrayList<>(List.of(3, 2, 1,3,2));
        truckSize = 4;

        System.out.println(getMaxUnit(num,boxes,unitSize,unitsPerBox,truckSize));
        // ======================Done=============================



        // ======================= CALLING MIN_SQUARED Distance Robots ===============

        System.out.println("Min Distance: " + getClosestDistanceBetweenPoints(3, List.of(0,1,2),List.of(0,1,4)));

        //==============================End ==========================================


        // ========================== Amazon TurnStile ===============================
//        https://leetcode.com/discuss/interview-question/798231/Amazon-or-OA-2020-or-Turnstile

        // Given a turnStill in Amazon go Store, return a list of integers where the value at index i is the time
        // when ith customer will pass the turnStill based on given conditions.
        // Input: numCustomer: integer representing number of customers,
        // arrTime: List of integers where the value at index i is the time in seconds when the ith customer will come to turnStill
        // direction: a list of integers where the value at index i is the direction of ith customer.

        System.out.println("TurnStill(4): " +Arrays.toString(amazonTurnStill(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
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

        java.util.List<String> result = findNearestSharedCity(3, List.of("c1", "c2", "c3"), List.of(3,2,1), List.of(3,2,3),
                                                     3, List.of("c1", "c2", "c3"));
        System.out.println("Nearest Shared city: " + Arrays.toString(result.toArray()));

        // ============================================ End ===============================================



        // ============================================== Fetch Items ===============================================
        HashMap<String, PairInt> mapvalue = new HashMap<>();
        mapvalue.put("item1", new PairInt(10,15));
        mapvalue.put("item2", new PairInt(3,4));
        mapvalue.put("item3", new PairInt(17,8));


        java.util.List<String> fetchResult = fetchItemsToDisplay(3, mapvalue, 1, 0, 2, 1);
        System.out.println("Sorted result for Fetch: " + Arrays.toString(fetchResult.toArray()));

        mapvalue.put("item5", new PairInt(5,8));
        fetchResult = fetchItemsToDisplay(4, mapvalue, 1, 0, 2, 1);
        System.out.println("Sorted result for Fetch: " + Arrays.toString(fetchResult.toArray()));

        mapvalue.put("item6", new PairInt(10,33));
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

        java.util.List negativeBalanceList = calculateSmallestNegative(6,3,input);
        System.out.println("Negative list: " + Arrays.toString(negativeBalanceList.toArray()));

        // ======================================= End ===================================================


        //=========================================== Get Max profit Product ==============================
        System.out.println("The max Profit obtained is: " + maxProfitForGivenProduct(2, List.of(3l,5l), 6));

        // ===================================== End ======================================================


        // =========================================== Substrings of size K with K distinct chars===========


        System.out.println("Substrings of size 6 with 3 distinct chars: " + Arrays.toString(count("abcabc",3).toArray()));
        System.out.println("Substrings of size 6 with 3 distinct chars: " + Arrays.toString(count("abacab",3).toArray()));
        System.out.println("Substrings of size ~ with 4 distinct chars: " + Arrays.toString(count("awaglknagawunagwkwagl",4).toArray()));

        // ====================================== done =====================================================


        // ======================================= Amazon Fresh Promotion ===================================

        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
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




    }
    public static void test(String[][] codeList, String[] shoppingCart, int expect) {
        System.out.println(winPrize(codeList, shoppingCart) == expect);
    }

    static TreeNode maxNode = null;
    double max = Integer.MIN_VALUE;

    static TreeNode maximumAverageTreeNode(TreeNode root){
        if(root == null) return null;
        helperDfs(root);
        return maxNode;
    }

    static double[] helperDfs(TreeNode root) {

        if(root == null) return new double[]{0,0};

       // for(root.)
        return new double[]{0,0};
    }


//    ================================ MAX_UNIT ========================

    static long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i < num; i++){
            int currBox = boxes.get(i);
            for(int k = 0; k < currBox; k++){
                pq.add(unitsPerBox.get(i));
                if(pq.size() > truckSize) pq.poll();
            }
        }

        int count = 0;
        while(!pq.isEmpty()) {
            count += pq.poll();
        }
        return count;
    }
// =====================================================================



 // ================================ Closest point =======================
    static double getClosestDistanceBetweenPoints(int numRobots, List<Integer> positionX, List<Integer> positionY) {
        double MIN = Integer.MAX_VALUE;
        for(int i = 0; i < numRobots; i++){
            for(int j = i+1; j < numRobots; j++){
               double currDist =  distance(new int[]{positionX.get(i), positionY.get(i)}, new int[]{positionX.get(j), positionY.get(j)});
                if(MIN > currDist) {
                   MIN = currDist;
                }
            }
        }
        return MIN;
    }

    static float distance(int[] pointA, int[] pointB){
        return ((pointA[0] - pointB[0])*(pointA[0] - pointB[0]) + (pointA[1] - pointB[1])*(pointA[1] - pointB[1]));
    }

//    =============================================== End =====================


// ========================================= TurnStill =============================

    private static int[] amazonTurnStill(int numCustomers, int[] arrTime, int[] direction) {
        int[] output = new int[numCustomers];
        int previous = 1;
        int m = 0, n = 1, seconds = 0;

        while(n < numCustomers){
            if(arrTime[n] == arrTime[m]){
                if(direction[m] == previous) {
                   output[m] = seconds;
                   arrTime[n]++;
                   m = n;
                   n++;
                }else{
                    output[n] = seconds;
                    arrTime[m]++;
                    n++;
                }
            }else {
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

        for(String city: cities)
            cityMap.put(city,index++);

        for(String query: queries) {
          String closestCity = null;
          int closedDistance = 0;

          int queryX = xCoordinates.get(cityMap.get(query));
          int queryY = yCoordinates.get(cityMap.get(query));

          for(String city: cities){
              int currX = xCoordinates.get(cityMap.get(city));
              int currY = yCoordinates.get(cityMap.get(city));
              int currDistance = mahattanDistance(queryX,queryY,currX,currY);
              if(city != query && (queryX == currX || queryY == currY)){
                  if( closestCity == null || currDistance < closedDistance || ((currDistance == closedDistance) && city.compareTo(closestCity) < 0)){
                      closestCity = city;
                      closedDistance = currDistance;
                  }
              }
          }
          output.add(closestCity);
        }
        return output;
    }

    private static int mahattanDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    // ===================  End ======================================================


//    =================================== Fetch Items to display ============================
    private static class PairInt{
        int relevance;
        int price;

        PairInt(int relevance, int price){
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

    static class item{
        String itemName;
        PairInt pairs;

        item(String itemName, PairInt pairs){
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

        for( Map.Entry<String, PairInt> entry: items.entrySet()) {
            sortedItems[index++] = new item(entry.getKey(), entry.getValue());
        }

        PriorityQueue<item> sortedValue = new PriorityQueue<>((item item1, item item2)->{
            if(sortParameter == 0){
                return sortOrder == 0 ? item1.getItemName().compareTo(item2.getItemName()) :
                        item2.getItemName().compareTo(item1.getItemName());

            }else{
               int compValue = sortParameter == 1 ? item1.getPairs().getRelevance() :  item1.getPairs().getPrice();
               int compValue2 = sortParameter == 1 ? item2.getPairs().getRelevance() :  item2.getPairs().getPrice();

               return sortOrder == 0 ? compValue - compValue2 : compValue2 - compValue;
            }
        });

        for(item currItem: sortedItems){
            sortedValue.add(currItem);
        }

        int itemsToSkip = itemsPerPage*pageNumber;
        while(itemsToSkip > 0){
            sortedValue.poll();
            itemsToSkip--;
        }

        java.util.List<String> output = new ArrayList<>();
        int toBeAdded = itemsPerPage;
        while(!sortedValue.isEmpty() && toBeAdded > 0){
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

    public static class debtRecord
    {
        String borrower = "";
        String lender = "";
        int amount = 0;
        debtRecord()
        {
           // empty constructor
        }
        debtRecord(String borrower, String lender, int amount)
        {
            this.borrower = borrower;
            this.lender = lender;
            this.amount = amount;
        }
    }

    static java.util.List<String> calculateSmallestNegative(int numRows, int numCols, java.util.List<debtRecord> debts) {
        int MIN_VALUE = Integer.MAX_VALUE;

        java.util.List<String> output = new ArrayList<>();
        Map<String,Integer> balances = new HashMap<>();

        for(debtRecord record : debts) {
            balances.put(record.borrower, balances.getOrDefault(record.borrower,0) - record.amount);
            balances.put(record.lender, balances.getOrDefault(record.lender,0) + record.amount);
        }
        MIN_VALUE = balances.entrySet().stream().mapToInt(balance -> balance.getValue()).min().getAsInt();

        for(Map.Entry<String, Integer> entry: balances.entrySet()) {
            if(MIN_VALUE < 0 && entry.getValue() == MIN_VALUE)
                output.add(entry.getKey());
        }

        Collections.sort(output);
        if(output.isEmpty())
            output.add("Nobody has a negative balance");
        return output;
    }

  // ============================ End =======================================================



  // ==============================  Highest profit for given product =========================
//https://leetcode.com/discuss/interview-question/799615/Amazon-OA2-New-Grad-2021-or-Sorting-Problem
    static long maxProfitForGivenProduct(int numSuppliers, List<Long> inventory, long order) {

        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b)->(b.compareTo(a)));
        for(long value : inventory){
            maxHeap.add(value);
        }

        long profit = 0;
        while(!maxHeap.isEmpty() && order > 0) {
           long currValue = maxHeap.poll();
           profit +=currValue--;
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
        for(;index < k; index++){
            if(charCount[s.charAt(index) - 'a'] == 0){
                distinct++;
            }
            charCount[s.charAt(index) - 'a']++;
        }

        if(distinct == k)
            output.add(s.substring(index-k,index));

        while (index < s.length()) {
            if(charCount[s.charAt(index) - 'a'] == 0)
                distinct++;
            charCount[s.charAt(index) - 'a']++;
            charCount[s.charAt(index-k) - 'a']--;
            if(charCount[s.charAt(index-k) -'a'] == 0)
                distinct--;
            if(distinct == k)
                output.add(s.substring(index-k+1, index+1));
            index++;
        }
        return new ArrayList<>(output);
    }

    // ==================================================== Done =============================================

    // ========================================== Amazon Fresh Promotion =====================================

    public static int winPrize(String[][] codeList, String[] shoppingCart){

        if(codeList == null || codeList.length == 0)
            return 1;
        if(shoppingCart == null || shoppingCart.length == 0)
            return 1;

        int index1 = 0, index2 = 0;
        while( index1 < codeList.length && index2 + codeList[index1].length <= shoppingCart.length) {
            boolean match = true;
            for(int k = 0; k < codeList[index1].length; k++){
                if(!codeList[index1][k].equals("anything") && !shoppingCart[index2+k].equals(codeList[index1][k])) {
                    match = false;
                    break;
                }
            }
            if(match) {
                index2 += codeList[index1].length;
                index1++;
            } else {
                index2++;
            }
        }
        return  (index1 == codeList.length) ? 1 : 0;
    }

    // ================================================== Done ===============================================

    // ================================================= Critical connections ================================


    // ==================================================  Done ==============================================
}