package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String testCase = br.readLine();
            String out = pickUpPassword(testCase);
            System.out.println(out);
        }

    }

    static String pickUpPassword(String testCase) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> outStack = new Stack<>();
        for (int i = 0; i < testCase.length(); i++) {
            char c = testCase.charAt(i);
            if (c == '<') {
                if (!stack.isEmpty()) outStack.push(stack.pop());
            } else if (c == '>') {
                if (!outStack.isEmpty()) stack.push(outStack.pop());
            } else if (c == '-') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        int size = outStack.size();
        for (int i = 0; i < size; i++) {
            stack.push(outStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
