import java.io.*;
import java.util.*;

public class Solution {

    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();

    void pushCharacter(char ch) {
        stack.push(ch);
    }
    void enqueueCharacter(char ch) {
        queue.add(ch);
    }
    char popCharacter() {
        return stack.pop();
    }
    char dequeueCharacter() {
        return queue.remove();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Solution obj = new Solution();

        for (char c : s.toCharArray()) {
            obj.pushCharacter(c);
            obj.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (obj.popCharacter() != obj.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("The word, " + s + ", is " +
                (isPalindrome ? "a palindrome." : "not a palindrome."));
    }
}
