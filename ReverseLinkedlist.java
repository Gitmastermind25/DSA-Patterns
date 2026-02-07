import java.util.*;

public class ReverseLinkedlist {

    // ListNode inside same class
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Reverse Linked List function
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        String[] arr = sc.nextLine().split(" ");

        // Build list
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (String s : arr) {
            temp.next = new ListNode(Integer.parseInt(s));
            temp = temp.next;
        }

        ListNode head = dummy.next;

        // Reverse
        head = reverseList(head);

        // Output
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
