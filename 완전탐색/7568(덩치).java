import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] people = new ArrayList[N];

        for (int i = 0; i < people.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(st.nextToken()));
            list.add(Integer.parseInt(st.nextToken()));
            people[i] = list;
        }

        for (int i = 0; i < people.length; i++) {
            int rankPoint = 1;
            for (int j = 0; j < people.length; j++) {
                if (i == j) continue;

                if (people[i].get(0) < people[j].get(0) && people[i].get(1) < people[j].get(1)) {
                    rankPoint++;
                }
            }
            sb.append(rankPoint).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

}




///  재귀로 푼 형식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] people = new ArrayList[N];

        for (int i = 0; i < people.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(st.nextToken()));
            list.add(Integer.parseInt(st.nextToken()));
            people[i] = list;
        }

        for (int i = 0; i < N; i++) {
            calculateRank(i, 0, 1, people);
        }
        System.out.print(sb.toString().trim());
    }

    static void calculateRank(int target, int current, int rankPoint, ArrayList<Integer>[] list) {
        if (current >= list.length) {
            sb.append(rankPoint).append(" ");
            return;
        }

        if (list[target].get(0) < list[current].get(0) && list[target].get(1) < list[current].get(1)) {
            ++rankPoint;
        }

        calculateRank(target, current + 1, rankPoint, list);
    }

}

