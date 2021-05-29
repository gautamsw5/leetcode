import java.util.*;
class Solution
{
    public int longestStrChain(String[] words)
    {
        int ans = 0;
        char[][] arr = new char[words.length][];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<16; i++)
            list.add(new ArrayList<>());
        for(int i=0; i<words.length; i++)
        {
            arr[i] = words[i].toCharArray();
            list.get(arr[i].length-1).add(i);
        }
        int[] max_depth = new int[words.length];
        for(int k=0; k<15; k++)
        {
            for(int a : list.get(k))
            {
                for(int b : list.get(k+1))
                {
                    int i=0, j=0;
                    while(i<arr[a].length && j<arr[b].length)
                    {
                        if(arr[a][i]==arr[b][j])
                        {
                            i++;
                            j++;
                        }
                        else
                            j++;
                    }
                    if(i==arr[a].length && j<=arr[b].length)
                        max_depth[b] = Math.max(max_depth[b], 1+max_depth[a]);
                }
            }
        }
        for(int i=0; i<words.length; i++)
            ans = Math.max(ans, max_depth[i]);
        return ans+1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++)
            words[i] = sc.next();
        Solution ob = new Solution();
        System.out.println(ob.longestStrChain(words));
        sc.close();
    }
}