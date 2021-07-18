class JumpGame2 {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n<=1)
            return 0;
        int max_reach=0,curr_reach=0,jumps=0;
        for(int i=0;i<n;i++)
        {
            if(curr_reach==n-1)
                return jumps;
            max_reach=Math.max(max_reach,i+nums[i]);
            System.out.println("max_reach: "+max_reach+" curr_reach: "+curr_reach+" jumps is: "+jumps);
            if(i==curr_reach)
            {
                jumps+=1;
                curr_reach=max_reach;
            }
        }
        return jumps;
    }
}