class Solution
{
    private String inv(String s)
    {
        s=s.replace('0','a');
        s=s.replace('1','0');
        s=s.replace('a','1');
        return new String((new StringBuilder(s)).reverse());
    }
    public char findKthBit(int n, int k)
    {
        String s1 = "0";
        while(n>1)
        {   
            s1 = s1+"1"+inv(s1);
            n--;
        }
        //System.out.println(s1);
        return s1.charAt(k-1);
    }
}