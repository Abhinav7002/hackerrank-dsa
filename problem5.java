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

    public static void topView(Node root) {
        if (root == null) return;

        class Pair {
            Node node;
            int hd;

            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int hd = current.hd;
            Node node = current.node;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
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

        topView(root);
    }
}
