class JumpGame1 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n<=1)
             return true;
        int max_reach=nums[0],curr_reach=nums[0],jumps=1;
         for(int i=1;i<n;i++)
         {
             max_reach=Math.max(max_reach,i+nums[i]);
             if(curr_reach==i)
             {
                 curr_reach=max_reach;
                 jumps+=1;
             }
         }
        System.out.println(curr_reach);
        return curr_reach>=n-1;
    }
}