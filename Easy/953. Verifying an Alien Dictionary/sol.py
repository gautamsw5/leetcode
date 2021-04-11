# https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/1149810/Python3-and-Java-solutions-Replace-characters
class Solution:
    def isAlienSorted(self, words, order: str) -> bool:
        dct = {}
        k = ord('a')
        for i in order:
            dct[i] = chr(k)
            k += 1
        prev = ""
        for w in words:
            cur = ""
            for c in w:
                cur += dct[c]      # Build the current word using the map (dct)
            if cur<prev:            # words will be sorted if current word is lexicographically greater than previous word
                return False
            prev = cur             # when you check the next word, you should know the current word as previous word
        return True
ob = Solution()
t = int(input("Enter number of test cases: "))
for i in range(t):
    n = int(input("Enter number of words: "))
    words = list(map(str,input("Enter words (space separated): ").split()))
    order = input("Enter order consisting of all characters a-z in lowercase: ")
    print(ob.isAlienSorted(words,order))
