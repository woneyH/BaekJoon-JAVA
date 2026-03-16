import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> heightValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            heightValues.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(heightValues);

        boolean[] resultMapping = null;
        Loop1:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                resultMapping = new boolean[9];
                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        resultMapping[k] = true;
                        sum += heightValues.get(k);
                    }
                }
                if (sum == 100) break Loop1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultMapping.length; i++) {
            if (resultMapping[i]) {
                sb.append(heightValues.get(i)).append("\n");
            }
        }
        System.out.print(sb);

    }
}
