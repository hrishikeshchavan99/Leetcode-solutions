# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        start = 1
        end = n
        k = 2
        mid = k//2
        if k%2:
            mid = mid+1 
        
        while k > 1:
            if isBadVersion(mid):
                end = mid
            else:
                start = mid
            k = end - start
            mid = k//2
            if k%2:
                mid = mid+1
            mid += start
        return int(mid)
                
                