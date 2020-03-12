//
//public class Node {
//  int val;
//  Node prev;
//  Node next;
//  Node(int x) { val = x; }
//}
//
//  Remove the element for a given key from a doubly linkedList.
//        Key = Integer; }
//
//
//public Node removeKey(int key, Node head){
//
//
//        Node dummyNode = new Node(0);
//        dummyNode.next = head;
//
//        if(head == null) return null;
//
//        while( head !=null){
//        if(head.val == key){
//        Node nextNode = currentNode.next;
//
//        if(head.prev != null){
//        head.prev.next = nextNode;
//        }
//
//        if(nextNode != null){
//        nextNode.prev = head.prev;
//        }
//        }
//
//        head = head.next;
//        }
//        return dummyNode.next;
//        }
//
//        Test cases:
//        [2,3] 2
//        [1,7,9,40, 44] 44
//        [0, 7 , 98]  0
//        [1,2,7, 9 ,43] 7
//        [1, 4, 6, 9] 10
//        [1, 4, 4, 4, 9, 20 ,1000] 4
//        [-1, -30, 22, 41] -1
//        [33, 44, 54, Integer.MAX_VALUE, 99] INTEGER.MAX_VALUE
//        [-1, -3, -4, -5]  -5
//        []
//
//
//        void testRemoveKeyValidInput(){ // Node: [1,2,4,7,9, -10, 1000]
//        Node[] input = new Node[]{1, 2, 4, 7, 9, -10};
//        Node head = removeKey(9);
//        Node temp = head;
//        Node[] output = new Node[];
//        int count =0;
//
//        while(temp!=null){
//        Node[count++] = temp;
//        temp = temp.next;
//        }
//
//        Node[] expected = new Node[] {1, 2, 4, 7, -10};
//        assertEquals(expected, output);
//        }
//
//        void testRemoveKeyValidInput(){ // Node: [-1,2,-4,7,-9, -10, 1000]
//
//        Node head = removeKey(-9);
//        Node temp = head;
//        while(temp!=null){
//        assertFalse(temp.val == -9);
//        temp= temp.next;
//        }
//        }
//
//
//        void testRemoveKeyValidInput(){ // Node: [-1,2,-4,7,INTEGER.MAX_VALUE, -10, 1000]
//
//        Node head = removeKey(Integer.MAX_VALUE);
//        Node temp = head;
//        while(temp!=null){
//        assertFalse(temp.val == Integer.MAX_VALUE);
//        temp= temp.next;
//        }
//        }
//
//
//        void testRemoveKeyValidInput(){ // Node: [1,2,4,7,9,9,9,-10, 1000]
//        // int[] expect = [1,2,4,7,9,9,-10, 1000]
//        Node foundReference = null;
//        Node temp = head;
//        while(temp!=null){
//        if(temp.val == 9){
//        foundReference = temp;
//        }
//        temp= temp.next;
//        }
//
//
//        Node head = removeKey(9);
//        Node temp1 = head;
//        while(temp1!=null){
//        assertFalse(temp == foundReference);
//        temp= temp.next;
//        }
//        }
//
