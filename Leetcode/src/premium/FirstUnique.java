package src.premium;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

    private static final int mi = Integer.MIN_VALUE, mx = Integer.MAX_VALUE; // dummy values of head and tail.
    private static final DoublyLinkedList head = new DoublyLinkedList(mi), tail = new DoublyLinkedList(mx);

private static class DoublyLinkedList {

    public DoublyLinkedList prev, next;
    public int val;

    public DoublyLinkedList(int v) {
        val = v;
    }
}

    private final Map<Integer, DoublyLinkedList> intToNode = new HashMap<>(); // map values to nodes.

    public FirstUnique(int[] nums) {
        head.next = tail; // construct empty list: head connects tail.
        tail.prev = head; // construct empty list: tail connects head.
        for (int num : nums) { // add unique numbers to doubly linked list and all entries corresponding to numbers to HashMap.
            add(num);
        }
    }

    public int showFirstUnique() {
        return head.next == tail ? -1 : head.next.val; // return -1 if empty list; or the first unique value.
    }

    public void add(int value) {
        DoublyLinkedList node = intToNode.putIfAbsent(value, new DoublyLinkedList(value));
        if (node != null) { // HashMap intToNode already contains entry (value=node).
            remove(node); // value is NOT unique, hence remove it from the doubly linked list.
        }else { // HashMap intToNode does NOT contains key value.
            putToEnd(intToNode.get(value)); // value is unique, hence put it to the end of the doubly linked list.
        }
    }

    private boolean remove(DoublyLinkedList node) {
        if (node.prev == null || node.next == null) { // node NOT in the list.
            return false; // remove operation failed.
        }
        node.prev.next = node.next; // modify next pointer of the previous node.
        node.next.prev = node.prev; // modify previous pointer of the next node.
        node.prev = null; // cut off the previous pointer from node to list.
        node.next = null; // cut off the next pointer from node to list.
        return true; // remove operation succeeded.
    }

    private boolean putToEnd(DoublyLinkedList node) {
        if (tail == null || tail.prev == null) { // tail node error.
            return false; // operation failed.
        }
        node.next = tail; // assign the tail to the next pointer of node.
        node.prev = tail.prev; // assign the previous node of the tail to the next pointer of node.
        tail.prev = node; // modify previous pointer of the tail.
        node.prev.next = node; // modify next pointer of the previous node.
        return true; // operation succeeded.
    }
}