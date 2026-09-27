class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalrow=matrix.length;
        int totalcol=matrix[0].length;

        int n=totalrow * totalcol;
        //1d array
        int s=0;
        int e=n-1;
        
        //binary search
        while(s<=e){
            int mid= s+(e-s)/2;
            //coverting 1d to 2d array
            int rowindex= mid/totalcol;
            int colindex= mid%totalcol;

            if(matrix[rowindex][colindex]==target){
                return true;
            }
            else if (matrix[rowindex][colindex]>target){
                //move left
                e=mid-1;
            }
            else{
                //move right
                s=mid+1;
            }
        }
        return false;
        
    }
}