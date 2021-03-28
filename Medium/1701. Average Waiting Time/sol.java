class Solution
{
    public double averageWaitingTime(int[][] arr)
    {
        double av = 0.0;
        long t=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][0]>t)
            {
                t=arr[i][0];
            }
            t += arr[i][1];
            //System.out.println(t-arr[i][0]);
            av += t-arr[i][0];
        }
        return av/arr.length;
    }
}