class Solution
{
public:
    int trap(vector<int>& a)
    {
        int i=0,j=0,k=0,m=0,s1=0,s=0,s2=0,n;
        n=a.size();
        if (n<=2)
            return 0;
        if (a[0]<=a[1])
        {    
            while (a[i]<=a[i+1])
            {
                //n=n-1;
                i++;
                if (n<=2)
                    return 0;
            }
        }
        if (a[n-2]>=a[n-1])
        {    
            while (n>1 && a[n-2]>=a[n-1])
            {
                n=n-1;
                if (n<=2)
                    return 0;
            }
        }
        if (n<=2)
            return 0;
        k=n-1;
        while (i<n || k>=0)
        {
            j=i+1;
            m=k-1;
            s1=0;
            s2=0;
            while (j<n && i<n)
            {
                if (a[j]<a[i])
                    s1=s1+a[i]-a[j];
                else
                {
                    s=s+s1;
                    i=j;
                    break;
                }
                j=j+1;
            }
            i=j;
            while (m>=0 && k>=0)
            {
                if (a[m]<=a[k])
                    s2=s2+a[k]-a[m];
                else
                {   
                    s=s+s2;
                    k=m;
                    break;
                }
                m=m-1;
            }
            k=m;
        }
        return s;
    }
};