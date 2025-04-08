/*
  문제 해석: 문제가 기본적으로 스택에서 필요한 메서드들을 구현한 후 입력값에 맞게 메서드을 적절히 사용하는 문제이다.
  
  문제 분석: 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N 개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
             N<=10,000 이므로 O(N log N) 이하의 시간복잡도로 풀어야 한다.
             
  문제 접근법: 입력 케이스가 문자열과 숫자를 입력받으므로 문자열은 switch 문으로 특정 문자열이면 문제에 맞게 기능을 제공하는 방식으로 문제를 접근했다.
               문자열 숫자 입력같은 경우에는 StringTokenizer로 " " 을 기준으로 잘라서 값을 대입하였다.
               
               두 가지 코드는 같은 시간복잡도이다. O(n)  스택에서의 문제에서 구현한 push, pop, size, peek, empty 메서드들은 전부 O(1) 이다.
               입력 조건 N만큼 입력받기 위한 반복문으로 최종 시간 복잡도 O(n)이다.

*/

// 문제 정보: 스택 10828 실버4 알고리즘 분류 자료구조, 구현, 스택


/*자바에서 제공하는 스택 사용 case*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(str);
            String token = st.nextToken();
            switch (token) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                        break;
                    } catch (RuntimeException r) {
                        System.out.println(-1);
                        break;
                    }
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    try {
                        System.out.println(stack.peek());
                        break;
                    } catch (RuntimeException r) {
                        System.out.println(-1);
                        break;
                    }
            }
        }
    }
}






/*직접 스택 구현 후 푼 코드*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(str);
            String token = st.nextToken();
            switch (token) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }
    }
}

class Stack {
    private int[] arr;
    private int point = 0;

    Stack(int size) {
        arr = new int[size];
    }

    public void push(int value) {
        arr[point++] = value;
    }

    public void pop() {
        if (point <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[--point]);
        }
    }

    public void top() {
        if (point <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[point - 1]);
        }
    }

    public void size() {
        System.out.println(point);
    }

    public void empty() {
        if (point <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
