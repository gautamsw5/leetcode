# https://leetcode.com/problems/regular-expression-matching/discuss/1170174/Python-3-Brute-Force-to-recursive-memo-faster-than-89
# Split p into parts with * and parts without *
# Try all possible ways of matching, if still not match, return False.
class Solution:
    def isMatch(self, S: str, p: str) -> bool:
        def match(s, pat, i, j, n, m, dp):  # match s[i:], pat[j:]
            I = i
            J = j
            # match single characters
            
            while i<n and j<m and (s[i]==pat[j] or pat[j]=="."): # Match exact or match with '.'
                i += 1
                j += 1
            
            # Base cases:
            if (i,j) in dp:
                return dp[(i,j)]
            if i>=n and j>=m:
                return True
            elif i<n and j>=m:
                return False
            if len(pat[j])==1:
                return False
            
            ret = match(s, pat, i, j+1, n, m, dp)   # * -> 0 or more, try 0
            while i<n and (s[i]==pat[j][0] or pat[j][0]=="."):  # now try 1 and more (only if chars are equal)
                if ret:   # If matched, return true
                    return ret
                ret = ret or match(s, pat, i+1, j+1, n, m, dp)
                i += 1
            dp[(I,J)] = ret  # Store result for tuple (I, J)
            return ret  # Return answer at last, if not returned yet 
        s = list(S)  # Convert to list
        i = 0
        pat = []  # Store pattern in modified form into strings of length 1 or 2, 2 if it has a star next to it else 1.
        while i<len(p):
            if i+1<len(p) and p[i+1]=="*":
                pat.append(p[i]+p[i+1])
                i = i + 2
            else:
                pat.append(p[i])
                i = i + 1
        dp = {}
        return match(s, pat, 0, 0, len(s), len(pat), dp) # call the recursive match function
