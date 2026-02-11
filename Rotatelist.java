import java.util.*;

public class Rotatelist {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int n = 1;

        while (curr.next != null) {
            curr = curr.next;
            n++;
        }

        curr.next = head; // make circular

        k = k % n;
        int stepsToNewTail = n - k;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read list as a full line
        String line = sc.nextLine();
        String[] values = line.split(" ");

        // Create linked list
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(Integer.parseInt(values[i]));
            curr = curr.next;
        }

        int k = sc.nextInt();

        head = rotateRight(head, k);

        printList(head);
    }
}
