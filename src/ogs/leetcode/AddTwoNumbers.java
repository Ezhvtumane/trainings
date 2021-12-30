package ogs.leetcode;

import java.util.*;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode kek = a.addTwoNumbers();
        ListNode olo = a.reverse(kek);
    }

    public ListNode addTwoNumbers() {
        //ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(9, null);
        ListNode l1 = new ListNode(9, n2);

        ListNode m3 = new ListNode(9);
        ListNode m2 = new ListNode(9, m3);
        ListNode l2 = new ListNode(9, m2);
/*
[9,9,9,9,9,9,9]
[9,9,9,9]

 */
        int buff = 0;
        ListNode buffer = null;
        ListNode l = null;
        do {
            //add npe check and sum for list with different length
            int res = l1.val + l2.val + buff;
            if (res > 10) {
                buff = 1;
                res = res%10;
            } else {
                buff = 0;
            }

            l = new ListNode(res, buffer);
            buffer = l;

            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null || l2 != null);

        return reverse(buffer);
    }

    public ListNode reverse(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode buffer = head;
            head = head.next;
            buffer.next = reversed;
            reversed = buffer;
        }
        return reversed;
    }

}


