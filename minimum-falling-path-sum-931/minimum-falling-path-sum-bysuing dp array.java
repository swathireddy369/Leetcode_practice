class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows= matrix.length;
        int columns=matrix[0].length;
        int[][] dp = new int[rows][columns];
        if(rows == 0 || matrix == null){
            return 0;
        }
        for(int j=0;j < columns ; j++){
           dp[rows-1][j] = matrix[rows-1][j];
        }
        for(int i = rows-2; i >= 0; i--){
            for(int j = 0;j < columns ; j++){
                     if(j == 0){
                     dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                     }else if(j == columns-1){
                      dp[i][j]= matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]); 
                     }
                     else{
                      dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                     }
            }
        }
       int min=Integer.MAX_VALUE;
        for(int j=0;j<columns;j++){
           min= Math.min(min,dp[0][j]);
        }
        return min;
     
    
        
    }
}