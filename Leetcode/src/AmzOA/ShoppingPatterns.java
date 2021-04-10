package src.AmzOA;

import java.util.*;

public class ShoppingPatterns {

    public static int shoppingPatterns(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {

        HashMap<Integer, List<Integer>> grph = new HashMap<>();
        for(int i = 0; i < productsFrom.size(); i++) {
            grph.putIfAbsent(productsFrom.get(i), new ArrayList<>());
            grph.putIfAbsent(productsTo.get(i), new ArrayList<>());
            grph.get(productsFrom.get(i)).add(productsTo.get(i));
            grph.get(productsTo.get(i)).add(productsFrom.get(i));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, List<Integer>> entry : grph.entrySet()){
            if(entry.getValue().size() >= 2){
                int count = entry.getValue().size() - 2;

                pq.add(count);
            }
        }

        int sum = 0, k = 3;
        while(!pq.isEmpty() && k > 0){
            System.out.println("PQ: " + pq.peek());
            sum += pq.poll();
            k--;
        }
        return sum == 0 ? -1 : sum;
    }

    public static void main(String[] args) {
        System.out.println(shoppingPatterns(6 , Arrays.asList(1, 2, 2, 3, 4, 5), Arrays.asList(2, 4, 5, 5, 5, 6)));
        System.out.println(shoppingPatterns(5 , Arrays.asList(1, 1, 2, 2, 3, 4), Arrays.asList(2, 3, 3, 4, 4, 5)));
        System.out.println(shoppingPatterns(4 , Arrays.asList(1,2,3,4,1), Arrays.asList(2,3,4,1,3)));

        //products_nodes=4, products_from=[1,2,3,4,1], products_to=[2,3,4,1,3]
        // 1 - 2, 4, 3
        // 2 - 1, 3
        // 3 - 3, 4, 1
        // 4 - 3, 1
    }
}
