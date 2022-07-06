class LCS {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n<=1)
            return n;
        Set<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int res=1;
        for(int i:nums)
        {
            if(!set.contains(i-1))
            {
                res=Math.max(res,util(set,i));
            }
        }
        return res;
    }
    //find consecutive sequence starting from a particular number
    int util(Set<Integer>set,int ele)
    {
        int len=1;
        while(set.contains(ele+1))
        {
            len+=1;
            ele+=1;
        }
        return len;
    }
}