import java.io.*;
import java.util.*;

public class Solution {

    static class MyQueue {
        Stack<Integer> stackNewest = new Stack<>();
        Stack<Integer> stackOldest = new Stack<>();

        public void enqueue(int value) {
            stackNewest.push(value);
        }

        public void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public int dequeue() {
            shiftStacks();
            return stackOldest.pop();
        }

        public int peek() {
            shiftStacks();
            return stackOldest.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        MyQueue queue = new MyQueue();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }

        scanner.close();
    }
}
