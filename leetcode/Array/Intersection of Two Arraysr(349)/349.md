## 문제: 349. Intersection of Two Arrays 
`` 난이도: Easy ``

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000



### Topics
``Array``
``Hash Table``
``Two Pointers``
``Binary Search``
``Sorting``

---

## 접근법

Set을 활용해 unique 보장한다.
마지막 출력 부분에서 set을 Array로 변환하면서 return 한다.
nums1 배열과 num2 배열을 이중반복문을 통해 동일한 원소가 존재하면 Set에 값을 넣는다.
