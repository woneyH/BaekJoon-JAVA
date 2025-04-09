/*
  문제 해석: 문제에서 괄호의 모양이 바르게 구성된 문자열을 VPS라고 부른다고 한다. 해당 문제는
             입력된 괄호 문자열 VPS이면 "YES"를 VPS가 아니면 "NO"를 출력하는 문제이다.
             예를 들면:
                     "(()())" → YES (올바른 괄호쌍)
                      "(()))(" → NO (닫는 괄호가 먼저 나옴 또는 짝이 안 맞음)
                      

  문제 접근법: 스택을 이용하지 않고 배열만으로도 풀 수 있을 것 같다. flag 변수들을 이용하면 풀 수 있을 것 같지만
               쉽게 푸는 방식은 스택을 이용하는 것이다. 
               
               1. 괄호 문자열을 CharAt으로 하나씩 가져온다. '(' 이면 stack에 그냥 넣는다.
            
               2. ')'이면 우선 스택이 비어있는지 확인한다. 스택이 비어있으면 VPS 조건에 안맞는 문자열로 간주한다.
               예)  "())("  -> 3번째 ')'에서 열린 괄호가 없어 쌍을 맞출 수 없으니 VPS가 아니다.
               즉, 스택이 비어있고 현재 char가 ')'이면 바로 "NO"를 반환한다.

               3. 괄호 문자열 검사가 다 끝났으면 stack에 '(' 가 남아있는지 확인한다. 만약 남아 있으면 닫힌 괄호랑 열린 괄호 개수가 안맞는거다.
               남아있는 경우 "NO"를 스택이 비어있으면 "YES"를 반환하고 다음 괄호 문자열 검사를 위해 스택을 비운다.
     
  코드 분석:  O(N*str)으므로 O(N). 

  문제 정보: 9012번: 괄호  실버4   알고리즘 분류 자료구조, 문자열, 스택
  https://www.acmicpc.net/problem/9012
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            System.out.println(checkVPS(str));
        }
    }

    static String checkVPS(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return "NO";
            }

        }
        if (stack.isEmpty()) {
            stack.clear();
            return "YES";
        } else {
            stack.clear();
            return "NO";
        }
    }
}
