class SortColors {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1,i=0;
        while(i>=0 && i<n)
        {
            if(l<=i && nums[i]==0)
            {
                nums[i]=nums[l];
                nums[l++]=0;
            }
            if(r>=i && nums[i]==2)
            {
                nums[i]=nums[r];
                nums[r--]=2;
                i--;
            }
            i++;
        }
    }
}