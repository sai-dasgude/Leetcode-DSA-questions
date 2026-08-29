class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int start = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
                if(nums[i]>pivot){
                    count++;
                }
        }
        int end = (nums.length) - count;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                ans[start] = nums[i];
                start++;
            }
            if(nums[i]>pivot){
                ans[end] = nums[i];
                end++;
            }
        }
        while(start<=((nums.length - 1) - count)){
            ans[start] = pivot;
            start++;
        }

        return ans;
    }

}