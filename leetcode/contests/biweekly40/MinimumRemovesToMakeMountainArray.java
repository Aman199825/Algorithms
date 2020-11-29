
class MinimumRemovesToMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int [] lis=new int[n];
        Arrays.fill(lis,1);
        lis[0]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && lis[i]<lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }
        int [] dis=new int[n];
        Arrays.fill(dis,1);
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(nums[i]>nums[j] && dis[i]<dis[j]+1)
                    dis[i]=dis[j]+1;
            }
        }
        Arrays.stream(lis).forEach(i->System.out.print(i+" "));
        System.out.println();
                Arrays.stream(dis).forEach(i->System.out.print(i+" "));

        int res=Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++)
        {
           // int l=i-1,r=i+1;
            //int lshiftcount=0,rshiftcount=0;
            /*while(l>0 && nums[l]>=nums[i])
            {
                l-=1;
                lshiftcount+=1;
            }
            if(nums[l]>=nums[i])
                continue;
            while(r<n-1 && nums[r]>=nums[i])
            {
                r+=1;
                rshiftcount+=1;
            }
            if(nums[r]>=nums[i])
                continue;*/
            /*int temp=lshiftcount+rshiftcount;
            temp+=(l+1-lis[l]);
            temp+=((n-r)-dis[r]);
            System.out.println(nums[i]+" "+temp);*/
            if(lis[i]>1 && dis[i]>1)
                res=Math.max(res,dis[i]+lis[i]-1);
            //res=Math.min(res,temp);
        }
        return  (n-res);
    }
}