class FreqStack
{
    Map<Integer, Stack<Integer>> group;
    Map<Integer,Integer> freq;
    int maxf;
    public FreqStack()
    {
        maxf = 0;
        group = new HashMap<>();
        freq = new HashMap<>();
    }
    public void push(int x)
    {
        int f = freq.getOrDefault(x,0)+1;
        freq.put(x,f);
        if(f>maxf)
        {
            maxf = f;
        }
        if(group.containsKey(f))
        {
            group.get(f).add(x);
        }
        else
        {
            Stack<Integer> z = new Stack<>();
            z.push(x);
            group.put(f,z);
        }
    }
    public int pop()
    {
        int x = group.get(maxf).pop();
        freq.put(x,freq.get(x)-1);
        if(group.get(maxf).size()==0)
        {
            maxf--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */