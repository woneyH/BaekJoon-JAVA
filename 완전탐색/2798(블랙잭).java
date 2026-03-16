import java.io.*;

public class Main {
    static int maxSum = 0;
    static int goalCardSum = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLineInput = br.readLine();
        String[] cardQuantityAndKeyCard = firstLineInput.split(" ");
        int cardCount = Integer.parseInt(cardQuantityAndKeyCard[0]);
        goalCardSum = Integer.parseInt(cardQuantityAndKeyCard[1]);

        String secondLineInput = br.readLine();

        String[] cards = secondLineInput.split(" ");
        updateMaxSum(0,0,0,cards);
        System.out.print(maxSum);
    }

    static void updateMaxSum(int start, int count, int sum, String[] cards) {
        if(count==3) {
            if(sum>maxSum && sum<=goalCardSum) {
                maxSum = sum;
            }
            return;
        }

        for(int i=start; i<cards.length; i++) {
            updateMaxSum(i+1,count+1,sum+Integer.parseInt(cards[i]),cards);
        }
    }
}
