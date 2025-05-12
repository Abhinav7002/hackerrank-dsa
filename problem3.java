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

        SinglyLinkedList() {
            this.head = null;
        }

        public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                SinglyLinkedListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            return head;
        }

        public void printList(SinglyLinkedListNode head) {
            SinglyLinkedListNode current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedListNode head = null;
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(scanner.nextLine());
            head = list.insertNodeAtTail(head, data);
        }
        list.printList(head);
    }
}
