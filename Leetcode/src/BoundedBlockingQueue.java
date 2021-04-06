package src;

import java.util.Deque;
import java.util.LinkedList;

public class BoundedBlockingQueue {

    int size;
    Object lock;
    Deque<Integer> dq;
    public BoundedBlockingQueue(int capacity) {
         dq = new LinkedList<>();
         size = capacity;
         lock = new Object();
    }

    public void enqueue(int element) throws InterruptedException {

        synchronized (lock){
            while (dq.size() == size) lock.wait();
            dq.addLast(element);
            lock.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized (lock){
            while (dq.isEmpty()) lock.wait();
            val = dq.removeFirst();
            lock.notify();
        }
        return val;
    }

    public int size() {
        return dq.size();
    }
}
