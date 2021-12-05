class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
       int l=0,r=nums.length-1,n=nums.length;
        if(n==1)
            return nums[0];
        while(l<r)
        {
            int m=l+(r-l)/2;
            if(m%2==1)
            {
                if( m-1>=0 && nums[m]!=nums[m-1])
                {
                    r=m;
                }
                else
                    l=m+1;
            }
            else
            {
                if(m+1<n && nums[m]!=nums[m+1])
                    r=m;
                else
                    l=m+1;
            }
        }
        return nums[l];
    }
}