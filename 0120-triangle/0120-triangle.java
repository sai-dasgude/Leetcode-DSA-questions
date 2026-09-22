class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size()-1;
        if(rows==0){
            return triangle.get(0).get(0);
        }else{

        for(int i=1;i<=rows;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                int previndex = Integer.MAX_VALUE;
                if(j>0){
                    previndex = triangle.get(i-1).get(j-1);
                }int currindex = Integer.MAX_VALUE;
                if(j<=i-1){
                    currindex = triangle.get(i-1).get(j);
                }

                triangle.get(i).set(j , triangle.get(i).get(j)+Math.min(previndex , currindex));
                System.out.println(triangle.get(i).get(j));
            }
        }

        int min = triangle.get(rows).get(0);
        for(int i=0;i<=rows;i++){
            min = Math.min(min , triangle.get(rows).get(i));
        }

        return min;
        }
          }
}