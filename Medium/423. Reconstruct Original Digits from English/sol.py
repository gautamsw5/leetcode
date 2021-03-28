# https://leetcode.com/problems/reconstruct-original-digits-from-english/discuss/1131133/Python3-remove-in-order-0248613579
class Solution:
    def originalDigits(self, s: str) -> str:
        arr = ["zero","one","two","three","four","five","six","seven","eight","nine"]
        dct = {0:"z", 2:"w", 4:"u", 8:"g", 6:"x", 1:"o", 3:"t", 5:"f", 7:"s", 9:"e"}
        keys = [0,2,4,8,6,1,3,5,7,9]
        freq = [0]*26
        for i in s:
            freq[ord(i)-ord('a')] += 1
        frr = [0]*10
        for i in keys:
            mn = len(s)
            for x in arr[i]:
                mn = min(mn,freq[ord(x)-ord('a')])
            if i==3 or i==7:
                mn = min(mn,freq[ord('e')-ord('a')]//2)
            elif i==9:
                mn = min(mn,freq[ord('n')-ord('a')]//2)
            frr[i] += mn
            for x in arr[i]:
                freq[ord(x)-ord('a')] -= mn
        ret = ""
        for i in range(10):
            ret += str(i)*frr[i]
        return ret
ob = Solution()
t = int(input())
for x in range(t):
    s = input()
    print(ob.originalDigits(s))
