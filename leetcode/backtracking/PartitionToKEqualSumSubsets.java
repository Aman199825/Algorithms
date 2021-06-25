class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) 
    {
       if(nums.length==0 )
           return true;
        Integer sum=Arrays.stream(nums).reduce(0,Integer::sum);
     
        int target=sum/k;
        if(sum%k!=0 || k<=0 || k > nums.length)
               return false;
        boolean [] used=new boolean[nums.length];
        return util(nums,used,k,0,0,target);
    }
    public boolean util(int [] nums,boolean [] used,int k,int pos,int currsum,int target)
    {
        if(k==1)
         return true;
        
        if(currsum==target)
            return util(nums,used,k-1,0,0,target);
        for(int i=pos;i<nums.length;i++)
        {
            if(!used[i] && currsum+nums[i]<=target)
            {
                used[i]=true;
                if(util(nums,used,k,i+1,currsum+nums[i],target))
                    return true;
            
                used[i]=false;
            }
            
        }
        return false;
    }
}