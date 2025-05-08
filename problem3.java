import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            String pair = a + " " + b;
            set.add(pair);
            System.out.println(set.size());
        }

        sc.close();
    }
}
