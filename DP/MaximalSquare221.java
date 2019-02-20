class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] opt = new int[matrix[0].length];
        int resLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            int prevNumber = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = opt[j];
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    opt[j] = matrix[i][j] - '0';
                } else {
                    opt[j] = Math.min(Math.min(opt[j], opt[j - 1]), prevNumber) + 1;
                }
                resLength = Math.max(resLength, opt[j]);
                prevNumber = temp;
            }
        }
        return resLength * resLength;
    }
}

// Time:O(N * M)
// Space: O(M)