package src.AmzOA;

import java.util.*;

public class OptimalUtilization {

    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {

        Collections.sort(a, (i,j) -> i[1] - j[1]);
        Collections.sort(b, (i,j) -> i[1] - j[1]);

        List<int[]> output = new ArrayList<>();

        int maxValue = Integer.MIN_VALUE;

        int aSize = a.size();
        int bSize = b.size();
        int start =0;
        int end =bSize-1;

        while(start < aSize && end >= 0) {
            int sum = a.get(start)[1] + b.get(end)[1];
            if(sum > target) {
                --end;
            } else {
                if(maxValue <= sum) {
                    if(maxValue < sum) {
                        maxValue = sum;
                        output.clear();
                    }
                    output.add(new int[]{a.get(start)[0], b.get(end)[0]});
                    int index = end-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
                        output.add(new int[]{a.get(start)[0], b.get(index--)[0]});
                    }
                }
                ++start;
            }
        }
        return output;
    }
}
