package src.premium;

import java.util.concurrent.atomic.AtomicIntegerArray;

class HitCounter {
    int[] hits;
    int[] time;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        time = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(time[index] != timestamp){
           time[index] = timestamp;
           hits[index] = 1;
        }else
            hits[index]++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int result=0;
        for(int i=0; i < 300; i++){
            if(timestamp - time[i] < 300)
                result+=hits[i];
        }
        return result;
    }
}

class HitCounter2 {
    AtomicIntegerArray hits;
    AtomicIntegerArray  time;
    /** Initialize your data structure here. */
    public HitCounter2() {
        hits = new AtomicIntegerArray(300);
        time = new AtomicIntegerArray(300);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(time.get(index) != timestamp){
            time.set(index, timestamp);
            hits.set(index, 1);
        }else
            hits.incrementAndGet(index);//add one
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int result=0;
        for(int i=0; i < 300; i++){
            if(timestamp - time.get(i) < 300)
                result+=hits.get(i);
        }
        return result;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
