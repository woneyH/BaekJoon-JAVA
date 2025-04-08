/*
  문제 해석: N과 M은 500,000 미만의 입력이다. O(N log M) 이하로 플어야 한다.
            입력된 카드 번호 값은 음수이든 양수이든 상관없다 정렬도 안된 상태이다.

  문제 접근법: 우선 입력 받은 카드 번호들을 java에서 제공하는 sort()로 오름차순한다. 그 후 이분 탐색 알고리즘에 적용한다.
               상근이가 가지고 있는 숫자 카드라면 1을 아니면 0을 출력한다.

               해당 코드는 배열 정렬 O(N log N) 이진 탐색 O(log N) 
               전체 합 O(N log N + M log N)

  10815:숫자 카드 실버5 알고리즘 분류 자료 구조, 정렬, 이분 탐색

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//접근법: 가지고 있는 카드만 정렬 그리고 찾고자하는 카드를 key값으로
//       이진검색을 한다. 최종 O(n log n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫 번째 가지고 있는 카드 입력
        int N = Integer.parseInt(br.readLine());
        int[] haveCard = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            haveCard[i] = Integer.parseInt(st.nextToken());
        }

        //두 번째 찾고자하는 카드 입력
        int M = Integer.parseInt(br.readLine());
        int[] searchCards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            searchCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(haveCard);
        for (int i = 0; i < M; i++) {
            int find = binarySearch(haveCard, searchCards[i]);
            if (find == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int center = (left + right) / 2;
            if (arr[center] < key) {
                left = center + 1;
            } else if (arr[center] > key) {
                right = center - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
