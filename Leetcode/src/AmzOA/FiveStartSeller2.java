package src.AmzOA;

import java.util.*;

public class FiveStartSeller2 {

    static class Product{

        public int pn;
        public int pd;
        public double rating;
        public double increasing;

        Product(){}

        Product(int pn, int pd){
            this.pn = pn;
            this.pd = pd;
            this.rating = (double) pn/pd;
            this.increasing = (double) (pn +1)/(pd+1) - this.rating;
        }
    }


    public static int fiveStarReview(List<List<Integer>> ratings, int threshold){
        int count  = ratings.size();
        Queue<Product> q  = new PriorityQueue<>((a,b) -> Double.compare(b.increasing,a.increasing));

        double currPer = 0;
        for(List<Integer> list : ratings){

            int first = list.get(0);
            int second = list.get(1);

            q.offer(new Product(first,second));
            currPer += (double) first/second;
        }
        currPer /= count;

        int result = 0;
        while (currPer * 100 < threshold){
            Product temp = q.poll();
            currPer += temp.increasing/count;
            temp = new Product(temp.pn+1,temp.pd+1);
            q.offer(temp);
            result++;
        }

        return result;
    }
    public static void main(String[] args) {
         List<List<Integer>> arr = new ArrayList<>();
         arr.add(Arrays.asList(4,4));
         arr.add(Arrays.asList(1,2));
         arr.add(Arrays.asList(3,6));
         System.out.println(fiveStarReview(arr, 77));
    }
}
