import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] switchStaus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchQuantity = Integer.parseInt(br.readLine());
        switchStaus = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());
            changeSwitch(s, switchNumber);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switchStaus.length; i++) {
            sb.append(switchStaus[i]).append(" ");
            if((i+1)%20==0 && i>0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void changeSwitch(int s, int switchNumber) {
        if (s == 1) {
            for (int i = switchNumber - 1; i < switchStaus.length; i += switchNumber) {
                switchStaus[i] = 1 - switchStaus[i];
            }
        } else {
            for (int i = switchNumber - 2, j = switchNumber; i >= 0; i--, j++) {
                if (j >= switchStaus.length || i < 0) break;

                if (switchStaus[i] == switchStaus[j]) {
                    switchStaus[i] = 1-switchStaus[i];
                    switchStaus[j] = 1-switchStaus[j];
                }else {
                    break;
                }
            }
            switchStaus[switchNumber-1] = 1 - switchStaus[switchNumber-1];
        }
    }
}
