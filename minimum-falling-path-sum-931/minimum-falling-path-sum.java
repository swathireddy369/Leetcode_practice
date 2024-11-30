class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int n=matrix.length;
       int m =matrix[0].length; 
       if(n == 0 || matrix == null){
            return 0;
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0;j <  m ; j++){
                     if(j == 0){
                     matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                     }else if(j == m-1){
                      matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]); 
                     }
                     else{
                      matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                     }
            }
        }
         int min=Integer.MAX_VALUE;
        for(int j=0;j< m;j++){
           min= Math.min(min,matrix[0][j]);
        }
        return min;
     
    
        
    }
}