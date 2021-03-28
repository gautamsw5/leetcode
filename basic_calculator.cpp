#include<iostream>
#include<string.h>
#include<bits/stdc++.h>
#include<stack>
using namespace std;
int calculate(string s)
{
    int i=0,f=1,ans=0;
    int n=s.length();
    long num=0;
    i=0;
    char signprev='+';
    stack<int>a;
    while(i<n)
    {
        if(s[i]=='(')
        {
            if(i==0)
            {
                a.push(1);
            }
            else if(s[i-1]=='+' || s[i-1]=='(')
            {
                a.push(1);
            }
            else if(s[i-1]=='-' || signprev=='-')
            {
                a.push(-1);
                f=f*-1;
            }
            i++;
        }
        else if(s[i]==')')
        {
            if(!a.empty())
            {
                f=f*a.top();
                a.pop();
            }
            i++;
        }
        else if(s[i]=='+')
        {
            if(s[i+1]=='(')
            {
                i++;
                continue;
            }
            i++;
            num=0;
            while(i<n && isdigit(s[i]))
            {
                num=10*num-'0'+s[i];
                i++;
            }
            ans=ans+f*num;
            signprev='+';
        }
        else if(s[i]=='-')
        {
            if(s[i+1]=='(')
            {
                i++;
                continue;
            }
            num=0;
            i++;
            while(i<n && isdigit(s[i]))
            {
                num=10*num-s[i]+'0';
                i++;
            }
            ans=ans+f*num;
            signprev='-';
            
        }
        else if(isdigit(s[i]))
        {
            num=0;
            while(i<n && isdigit(s[i]))
            {
                num=10*num-'0'+s[i];
                i++;
            }
            ans=ans+f*num;
        }
        else
        {
            i++;
        }
    }
    return (int)ans;
}
int main()
{
    string s;
    getline(cin, s);
    int a=calculate(s);
    cout<<a;
    return 0;
}