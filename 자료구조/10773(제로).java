import java.io.*;
import java.util.Stack;

/**
 *  접근법: 스택을 이용해 0이 나오면 pop()으로 스택에서 마지막에 입력된 값 지운다.
 *          참고로 제일먼저 0이 입력될 수 있으므로 i==0 && 입력값==0이면 continue

            첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)   

     문제 정보: 10773 제로 실버4 알고리즘 분류 구현,자료구조,스택
 */
public class PS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            int value = Integer.parseInt(br.readLine());
            if (i == 0 && value == 0) {
                continue;
            }
            if (value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }
        int stackSize = stack.size();
        int sum = 0;
        for (int i = 0; i < stackSize; i++) {
            sum += Integer.parseInt(String.valueOf(stack.pop()));
        }
        System.out.println(sum);
    }
}
