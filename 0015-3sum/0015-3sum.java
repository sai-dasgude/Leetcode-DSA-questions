class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      if(nums==null || nums.length<3){
        return new ArrayList<>();
      }
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();
      HashSet<String> unique = new HashSet<>();
      for(int i=0;i<nums.length-2;i++){
        int left = i+1;
        int right = nums.length-1;
        while(left<right){
            int sum = nums[i]+nums[left]+nums[right];
            if(sum>0){
                right--;
            }else if(sum<0){
                left++;
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb.append(nums[left]);
                sb.append(nums[right]);
                String code = sb.toString();
              if(unique.contains(code)==false){
              unique.add(code);
              ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
              }
              left++;
              right--;
            }
        }
      }
      return ans;
    }
}