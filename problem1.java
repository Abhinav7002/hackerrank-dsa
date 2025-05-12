import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode current = dummy;

        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                current.next = headA;
                headA = headA.next;
            } else {
                current.next = headB;
                headB = headB.next;
            }
            current = current.next;
        }

        if (headA != null) current.next = headA;
        else current.next = headB;

        return dummy.next;
    }

    static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int t = 0; t < tests; t++) {
            int n1 = sc.nextInt();
            SinglyLinkedList list1 = new SinglyLinkedList();
            for (int i = 0; i < n1; i++) {
                list1.insertNode(sc.nextInt());
            }

            int n2 = sc.nextInt();
            SinglyLinkedList list2 = new SinglyLinkedList();
            for (int i = 0; i < n2; i++) {
                list2.insertNode(sc.nextInt());
            }

            SinglyLinkedListNode merged = mergeLists(list1.head, list2.head);
            printList(merged);
        }

        sc.close();
    }
}
