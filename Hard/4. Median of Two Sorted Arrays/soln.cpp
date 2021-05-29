#include<bits/stdc++.h>
class Solution {
    public:
        double findMedianSortedArrays(vector<int>& a, vector<int>& b)
        {
            double ans;
            int mid,mid2;
            int n=a.size();
            int m=b.size();
            vector<int> c;
            int i=0,j=0;
            while(i<n && j<m)
            {
                if(a[i]<b[j])
                {
                    c.push_back(a[i]);
                    i++;
                }
                else
                {
                    c.push_back(b[j]);
                    j++;
                }
            }
            while(i<n)
            {
                c.push_back(a[i]);
                i++;
            }
            while(j<m)
            {
                c.push_back(b[j]);
                j++;
            }
            n=n+m;
            if(n%2==0)
            {
                mid=n/2-1;
                mid2=n/2;
                ans=(1.0*c[mid]+1.0*c[mid2])/2.0;
            }
            else
            {
                mid=n/2;
                ans=1.0*c[mid];
            }
            return ans;
        }
    };