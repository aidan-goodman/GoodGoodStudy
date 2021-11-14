package quickhand;

/**
 * Created by Aidan on 2021/10/8 16:17
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class CircularLinkedList {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = d;

        // 判断是否有环
        System.out.println(hasCycle(a));

        // 寻找环的入口
        ListNode index = detectCycle(a);
        if (index != null) {
            System.out.println(index.val);
        } else {
            System.out.println("null");
        }
    }

    // 判断是否有环
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 判断环的入口
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}