// 느낀점: 문제는 어렵지 않다 그냥 재귀함수만 구현하면 된다. StringBuilder로 가변객체를 이용해 메모리를 아낄 수 있지만,
// 문제를 풀기 위해 메모리를 크게 신경 안 써도 될 것 같아 불변객체를 사용했다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String firstLine = "\"재귀함수가 뭔가요?\"";
    static String secondLine = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String thirdLine = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String fourthLine = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String finalLine = "라고 답변하였지.";

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int recursionCount = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(fourthLine);
        recursionFunction(1,recursionCount,"____");
        System.out.println("라고 답변하였지.");
    }

    static void recursionFunction(int currentCount, int recursionCount, String dash) {
        if(currentCount==recursionCount) {
            System.out.println(dash+"\"재귀함수가 뭔가요?\"");
            System.out.println(dash+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(dash+finalLine);
            return;
        } else {
            System.out.println(dash+firstLine);
            System.out.println(dash+secondLine);
            System.out.println(dash+thirdLine);
            System.out.println(dash+fourthLine);
        }

        recursionFunction(currentCount+1,recursionCount,dash+"____");
        System.out.println(dash+finalLine);
    }
}
