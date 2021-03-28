class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        for i in range(len(words)):
            words[i] = words[i][::-1]
        words.sort()
        i = 0
        ans = 0
        while i < len(words):
            while i+1 < len(words) and words[i+1].startswith(words[i]):
                i += 1
            ans += len(words[i]) + 1
            i += 1
        return ans
