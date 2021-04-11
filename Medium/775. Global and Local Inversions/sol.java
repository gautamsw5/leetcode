// https://leetcode.com/problems/global-and-local-inversions/discuss/1143523/Java-1-ms-remove-non-intersecting-local-inversions
class GlobalLocalInv
{
    public boolean isIdealPermutation(int[] A)
    {
        for(int i=0; i<A.length-1; i++)
        {
            if(A[i]>A[i+1])
            {
                int t = A[i];
                A[i] = A[i+1];
                A[i+1] = t;
                i++;
            }
        }
        for(int i=0; i<A.length-1; i++)
        {
            if(A[i]>A[i+1])
            {
                return false;
            }
        }
        return true;
        // int c=0;
        // for(int i=0; i<A.length-1; i++)
        // if(A[i]>A[i+1]) c++;
        // for(int i=0; i<A.length; i++)
        // for(int j=i+1; j<A.length; j++)
        // if(A[i]>A[j])
        // {
        //     c--;
        //     if(c<0)
        //     {
        //         break;
        //     }
        // }
        // return c==0;
    }
}