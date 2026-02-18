import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");
        int x = Integer.parseInt(splitStr[0]);
        int y = Integer.parseInt(splitStr[1]);
        int w = Integer.parseInt(splitStr[2]);
        int h = Integer.parseInt(splitStr[3]);

        int xMin = Math.min(x, Math.abs(x - w));
        int yMin = Math.min(y, Math.abs(y - h));

        int sortValue = Math.min(xMin, yMin);
        System.out.println(sortValue);
    }
}
