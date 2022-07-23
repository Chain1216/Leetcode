class Solution {
    public int[][] generateMatrix(int n) {
        int number_start = 1;
        int loop = 0;
        int[][] result = new int[n][n];
        int start = 0;
        int i,j;
        
        while(loop++ < n/2){    //这个里面的++ 是表示用原来的数字判定，判定成功后，立刻++
        
            
            for(j = start; j < n-loop; j++){
                result[start][j] = number_start++;
            }
            
            for(i = start; i < n-loop; i++){
                result[i][j] = number_start++;
            }
            
            for(; j >= loop; j--){
                result[i][j] = number_start++; //表示用原来的数字判定，判定后立刻++
            }
            
            for(; i >= loop; i--){
                result[i][j] = number_start++;
            }
            
            start++;
            
            
        }
        
        if(n % 2 == 1){
            result[start][start] = number_start; 
        }
        
        return result;
        
        
    }
}
