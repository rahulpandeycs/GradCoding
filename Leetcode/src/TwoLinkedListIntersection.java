
class LinkedNode {
  int val;
  LinkedNode next;

  LinkedNode(int val){
    this.val = val;
    next = null;
  }
}

public class TwoLinkedListIntersection {

  public static LinkedNode intersectionOfLinkedList(LinkedNode list1, LinkedNode list2) {
    LinkedNode head1 = list1, head2 = list2, maxList = null, minList = null;
    int len1 = 0, len2 = 0, distanceBwTwoList = 0;

    while( head1 != null ) {
      len1++;
      head1 = head1.next;
    }

    while( head2 != null ) {
      len2++;
      head2 = head2.next;
    }

    distanceBwTwoList = Math.abs(len2 -len1);
    maxList = len2 > len1 ? list2 : list1;
    minList = len2 > len1 ? list1 : list2;

    while(distanceBwTwoList > 0) {
      maxList = maxList.next;
      distanceBwTwoList--;
    }

    while(maxList != null && minList!= null && maxList != minList) {
      maxList =maxList.next;
      minList = minList.next;
    }

    return maxList == minList ? maxList : null;
  }

  public static void main(String[] args) {
    LinkedNode head11 = new LinkedNode(1);
    LinkedNode head12 = new LinkedNode(2);
    LinkedNode head13 = new LinkedNode(3);
    LinkedNode head14 = new LinkedNode(4);
    head11.next = head12; head12.next = head13; head13.next = head14;

    LinkedNode head20 = new LinkedNode(5);
    LinkedNode head21 = new LinkedNode(6);
    LinkedNode head22 = new LinkedNode(7);
    LinkedNode head23 = new LinkedNode(8);
    head20.next = head21; head21.next = head22; head22.next = head23;

    LinkedNode merged = new LinkedNode(10);
    LinkedNode merged1 = new LinkedNode(11);
    LinkedNode merged2 = new LinkedNode(12);
    LinkedNode merged3 = new LinkedNode(13);
    merged.next = merged1; merged1.next = merged2; merged2.next = merged3;
    head23.next = merged;
    head14.next = merged;
    LinkedNode intersection = intersectionOfLinkedList(head11,head20);
    System.out.println(intersection.val);
  }
}
