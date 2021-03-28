class Solution {
    public boolean searchMatrix(int[][] matrix, int x) {
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]<=x)
            {
                int l=0,
                r=matrix[i].length-1;
                while(l <= r)
                {
                    int mid = l + (r - l) / 2;
                    if(matrix[i][mid] == x)
                    {
                        return true;
                    }
                    else if (matrix[i][mid] < x)
                    {
                        l = mid + 1;
                    }
                    else
                    {
                        r = mid - 1;
                    }
                }
            }
            else
            {
                break;
            }
        }
        return false;
    }
}