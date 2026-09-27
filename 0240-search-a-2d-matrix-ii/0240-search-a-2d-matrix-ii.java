class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow=matrix.length;
        int totalCol=matrix[0].length;

        int row=0;
        int col=totalCol-1;

        while(row < totalRow && col>= 0){
            if(matrix[row][col]==target)
            return true;
            else if(matrix[row][col]>target){
                col--;
            }
            else{
                //(matrix[row][col]<target)
                row++;
            }

        }
        return false;
        
    }
}