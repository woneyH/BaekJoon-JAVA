// 각 재귀별 first index랑 last index에서는 한 줄 전부 '*' 로 바꿔주는게 포인트
// 각 재귀별 first index랑 last index에서는 줄의 양 끝에 '*' 로 바꿔주는게 포인트
// 재귀 파라미터는 first index+2 / last index-2 로 index값 update 각 재귀에서의 max Stars 개수도 업데이트
// 핵심 알고리즘 funtion(i) = i+(3*(i-1))

package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10994 {
    static char[][] printStars;
    static int loopCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loopCount = Integer.parseInt(br.readLine());
        printStars = new char[loopCount + (3 * (loopCount - 1))][loopCount + (3 * (loopCount - 1))];
        for (int i = 0; i < printStars.length; i++) {
            for (int j = 0; j < printStars[i].length; j++) {
                printStars[i][j] = ' ';
            }
        }
        appendStars(0, printStars[0].length - 1, printStars[0].length, loopCount);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < printStars.length; i++) {
            for (int j = 0; j < printStars[i].length; j++) {
                sb.append(printStars[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void appendStars(int startIndex, int lastIndex, int maxStars, int count) {
        for (int i = startIndex; i < lastIndex + 1; i++) {
            if ((i == startIndex || i == lastIndex)) {
                for (int j = startIndex, k = 0; k < maxStars; j++, k++) {
                    printStars[i][j] = '*';
                }
            } else {
                printStars[i][startIndex] = '*';
                printStars[i][lastIndex] = '*';
            }
        }
        if (count == 0) {
            return;
        } else {
            appendStars(startIndex + 2, lastIndex - 2, (count - 1) + (3 * ((count - 1) - 1)), count - 1);
        }
    }
}
