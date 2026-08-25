class Solution:
    def isPalindrome(self, x):
        ns=x[::-1]
        return ns==x
        
    def isPalindromic(self, s: str) -> bool:
        st=""
        for i in s:
            binary_string = bin(ord(i))
            st+="0"+binary_string[2:]
        return self.isPalindrome(st)
