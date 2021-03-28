class Solution
{
    private String strev(String a)
    {
        char[] b = a.toCharArray();
        int i = 0,
        j = b.length-1;
        while(i<j)
        {
            char t = b[i];
            b[i++] = b[j];
            b[j--] = t;
        }
        return new String(b);
    }
    public int minimumLengthEncoding(String[] words)
    {
        for(int i=0; i<words.length; i++)
        {
            words[i] = strev(words[i]);
        }
        Arrays.sort(words);
        int ans = 0,
        i = 0;
        while(i<words.length)
        {
            while(i+1<words.length && words[i+1].startsWith(words[i]))
            {
                i++;
            }
            ans += words[i++].length() + 1;
        }
        return ans;
    }
}