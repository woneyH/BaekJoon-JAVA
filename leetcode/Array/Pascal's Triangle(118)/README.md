## 문제

---

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30


## 접근법

---

문제에서 1개의 배열로만 해결하려고 하지말자. 다양한 방식으로 생각하기

정답을 반환만 하고 연산 결과를 계속 누적해서 저장하는 배열 하나와  전에 연산했었던 배열(히스토리용) 하나를 이용한다.

