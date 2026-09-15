class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] skipfirst = new int[n-1];
        int[] skiplast = new int[n-1];
        int skipfirstindex = 0;
        int skiplastindex = 0;

        for(int i=0;i<n;i++){
            if(i!=0){
                skipfirst[skipfirstindex] = nums[i];
                skipfirstindex++;
            }

            if(i!=n- 1){
                skiplast[skiplastindex] = nums[i];
                skiplastindex++;

            }
        }

        return Math.max(helperfunction(skipfirst) , helperfunction(skiplast));
    }

    public int helperfunction(int[] arr){
        
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length;i++){
          int take = arr[i];
          if(i>1) take+= prev2;

          int notake = 0 + prev1;

          int curr = Math.max(take , notake);

          prev2 = prev1;
          prev1 = curr;
        }
        return prev1;
    }
}