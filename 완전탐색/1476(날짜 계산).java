import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitInput = input.split(" ");
        int e = Integer.parseInt(splitInput[0]);
        int s = Integer.parseInt(splitInput[1]);
        int m = Integer.parseInt(splitInput[2]);

        for(int i=1; i<=7980; i++) {
            if((e-i)%15==0 && (s-i)%28==0 && (m-i)%19==0) {
                System.out.print(i);
                break;
            }
        }
    }
}
