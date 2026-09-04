//배열을 여러개 만들 생각을 하자.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> preList = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j <= count; j++) {
                if (j == 0 || j == count) {
                    currentList.add(1);
                } else {
                    currentList.add(preList.get(j) + preList.get(j - 1));
                }
            }
            list.add(currentList);
            preList = currentList;
            count++;
        }
        return list;
    }
}
