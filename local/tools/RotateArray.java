class RotateArray {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    void reverse(int [] nums,int l,int r)
    {
        while(l<r)
        {
            int t=nums[l];
            nums[l]=nums[r];
            nums[r]=t;
            l+=1;
            r-=1;
        }
    }
}