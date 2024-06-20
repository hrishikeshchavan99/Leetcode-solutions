class Solution:
    def canJump(self, nums: List[int]) -> bool:
        l = 0
        r = 0
        #print(r)
        while r < len(nums)-1:
            m = 0
            flag = False
            for i in range(l, r+1):
                m = max(m, i+nums[i])
                if flag == False and nums[i] != 0:
                    flag = True
                #print(m)
            l = r+1
            r = m
            if flag == False: 
                return False
        

        return True 
        