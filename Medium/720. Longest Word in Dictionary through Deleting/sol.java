class Solution
{
    private boolean isSub(String s1, String s2) // check if s2 if subseq of s1
    {
        int i=0,
        j=0;
        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j==s2.length();
    }
    public String findLongestWord(String s, List<String> d)
    {
        String ans = "";
        Collections.sort(d);
        for(String t:d)
        {
            if(t.length()>ans.length() && isSub(s,t))
            {
                ans = t;
            }
        }
        return ans;
    }
}