/*
  문제 해석: 입력 N은 (1<=N<=1,000,000) 이다.  해당 문제는 시간복잡도가 중요한 문제인 것 같다.
             해당 문제는 O(N) 안에 풀면되는 문제인 것 같다.
             문제는 스택 1 문제와 비슷하다 하지만 입력 케이스가 모두 정수인 것 뿐이다.
             입력된 정수 값에 따라 스택 기능을 적절히 호출하면 된다.
             Java에서 제공하는 Stack을 사용했다.

  코드 분석: 작성한 코드는 O(N) 이다 입력된 N 값만큼 반복문 돌리는거 말곤 다른 건 없다.
            

  28278번: 스택 2 실버4  알고리즘 분류 자료구조, 스택
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
      
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int options = Integer.parseInt(st.nextToken());
          
            switch (options) {
                case 1: {
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                }
                case 2: {
                    try {
                        sb.append(stack.pop() + "\n");
                    } catch (RuntimeException r) {
                        sb.append(-1 + "\n");
                    }
                    break;
                }
                case 3: {
                    sb.append(stack.size() + "\n");
                    break;
                }
                case 4: {
                    if (stack.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                }
                case 5: {
                    try {
                        sb.append(stack.peek() + "\n");
                    } catch (RuntimeException r) {
                        sb.append(-1 + "\n");
                    }
                    break;
                }
            }

        }
        System.out.println(sb);
    }
}
