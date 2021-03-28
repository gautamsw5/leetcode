class Solution
{
    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        Stack<Integer> stk = new Stack<>();
        int i = 0,
        j = 0;
        while(j<popped.length)
        {
            if(!stk.isEmpty() && stk.peek()==popped[j])
            {
                stk.pop();
                j++;
            }
            else if(i<pushed.length)
            {
                stk.push(pushed[i++]);
            }
            else
            {
                break;
            }
        }
        return j==popped.length;
    }
}