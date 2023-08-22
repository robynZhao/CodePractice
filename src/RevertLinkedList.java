public class RevertLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while(head != null) {
            if(newHead == null) {
                newHead = new ListNode(head.val);
            } else {
                newHead = new ListNode(head.val, newHead);
            }

            head = head.next;
        }

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
