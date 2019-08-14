public class Solution1 implements Solution {
    @Override
    public ListNode swapPairs(ListNode head) {

        ListNode singleHead = head, doubleHead = head != null ? head.next : null;
        ListNode p1 = singleHead, p2 = doubleHead;
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            } else {
                p2.next = null;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode newHead;
        if (doubleHead != null) {
            newHead = doubleHead;
            ListNode p = newHead;
            p1 = singleHead;
            p2 = doubleHead.next;
            while (p1 != null && p2 != null) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
            if (p1 != null) {
                p.next = p1;
            } else if (p2 != null) {
                p.next = p2;
            }
        } else {
            newHead = head;
        }

        return newHead;
    }
}
