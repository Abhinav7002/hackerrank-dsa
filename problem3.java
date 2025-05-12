import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {

    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data <= root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;

        while (n-- > 0) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        levelOrder(root);
    }
}
