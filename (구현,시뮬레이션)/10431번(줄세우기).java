package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] testCase = new int[N][21];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 21; j++) {
                testCase[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase.length; i++) {
            sb.append(i + 1).append(" ");
            int count = 0;
            for (int j = testCase[i].length - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 1; k--) {
                    if (testCase[i][j] < testCase[i][k]) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }


        System.out.print(sb);
    }
}
