class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Loop1: for(int i=0; i< nums.length-1; i++) {
            int sum = nums[i];
            for(int j=i+1; j< nums.length; j++) {
                sum+=nums[j];
                if(sum==target) {
                    result[0] = i;
                    result[1] = j;
                    break Loop1;
                }
                sum-=nums[j];
            }
        }
        return result;
    }
}
