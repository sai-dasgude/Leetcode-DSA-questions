class Solution {
    public int climbStairs(int n) {
         int dparr[] = new int[n+1];
         for(int i=0;i<n+1;i++){
            dparr[i] = -1;
         }

         return helperfunction(0 , n , dparr);
    }

    public int helperfunction(int pos , int n , int[] dparr){
            if(pos==n) return 1;
            if(pos>n) return 0;
            if(dparr[pos]!= -1) return dparr[pos];

            int left = helperfunction(pos+1 , n , dparr);
            int right = helperfunction(pos+2 , n , dparr);
            dparr[pos] = left + right;
            return dparr[pos];
    }

    
}