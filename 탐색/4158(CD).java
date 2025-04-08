/*
  문제 해석: 문제에서 상근이와 선영이의 CD의 수는  N, M으로 입력받는다. N, M은 최대 크기가 백만이다.
             N<=10^6  O(N) 또는 O(N log N)에 맞게 알고리즘을 짜야할 것 같다.
             하지만 사실 N+M= 2,000,000 이므로 최대한 O(N log N)이하로 문제를 풀어야 한다.
             

  문제 접근법: 3번 제출해서 계속 틀렸었다. 문제는 0 0 입력을 받기전에는 계속 입력을 받아야한다. 이점을 고려해서 문제를 풀어야한다.
               무한 반복문을 통해 0 0 입력전까지 계속 N, M 입력을 받는다. 입력받을 때 마다 새로운 배열을 생성한다.
               두 사람의 CD 번호가 같은게 몇 개인지 출력하면 되는 문제이다. 또 문제에서 알아서 오름차순으로 입력해주니 정렬 알고리즘을 구현할 필요가 없다.
               같은 번호 CD를 찾기 위해 이분 탐색 알고리즘을 사용한다. O(log n) 

   최종적으로 해당 코드는 입력 N 이분 탐색 log M   O(N log M)이다.

   4158번:CD 문제 실버5 알고리즘 분류 자료구조,이분탐색,두 포인터, 해시를 사용한 집합과 맵
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[] arrA = new int[N];
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(br.readLine());
            }

            int[] arrB = new int[M];
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(search(arrA, arrB));
        }

    }

    public static int search(int[] arrA, int[] arrB) {
        int count = 0;
        for (int i = 0; i < arrA.length; i++) {
            int key = arrA[i];
            int left = 0;
            int right = arrB.length - 1;
            while (left <= right) {
                int center = (left + right) / 2;
                if (key < arrB[center]) {
                    right = center - 1;
                } else if (key > arrB[center]) {
                    left = center + 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
