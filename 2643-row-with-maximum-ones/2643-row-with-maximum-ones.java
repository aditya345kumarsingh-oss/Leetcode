class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int totalRow = mat.length;
        int totalcol = mat[0].length;

        int maxi = -1;
        int maxOneRowIndex = -1;

        for (int row = 0; row < totalRow; row++) {

            int OneCount = 0;

            for (int col = 0; col < totalcol; col++) {

                if (mat[row][col] == 1) {
                    OneCount++;
                }
            }

            if (OneCount > maxi) {
                maxi = OneCount;
                maxOneRowIndex = row;
            }
        }

        return new int[]{maxOneRowIndex, maxi};
    }
}