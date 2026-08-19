class Solution(object):
    def mySqrt(self, x):
        ans=0
        for i in range(0,x+1):
            if i*i<=x:
                ans=i
            else:
                break
        return ans