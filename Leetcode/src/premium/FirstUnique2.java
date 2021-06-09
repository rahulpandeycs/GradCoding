package src.premium;

import java.util.HashSet;
import java.util.*;

public class FirstUnique2 {
    private Set<Integer> unique = new LinkedHashSet<>();
    private Set<Integer> total = new HashSet<>();

    public FirstUnique2(int[] nums) {
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        /*
        for (int v : unique) {
            return v;
        }
        return -1;
        */
        return unique.isEmpty() ? -1 : unique.iterator().next();
    }

    public void add(int value) {
        if (total.add(value)) {
            unique.add(value);
        }else {
            unique.remove(value);
        }
    }
}
