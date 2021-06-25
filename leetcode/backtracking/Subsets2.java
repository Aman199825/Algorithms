class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        util(res,new ArrayList<>(),nums,new boolean[n],0);
        return res;
    }
    void util(List<List<Integer>> res,List<Integer> temp,int [] nums,boolean [] used,int ind)
    {
        int n=nums.length;
        if(ind>=n)
        {
           res.add(new ArrayList<>(temp));
            return;
        }
        if(used[ind])
        {
            System.out.println(temp);
           //  res.add(new ArrayList<>(temp));
            return;
        }
        if(ind>0 && !used[ind-1] && nums[ind-1]==nums[ind])
        {
                              res.add(new ArrayList<>(temp));

            return;
        }
        temp.add(nums[ind]);
        used[ind]=true;
        util(res,temp,nums,used,ind+1);
        temp.remove(temp.size()-1);
        used[ind]=false;
        util(res,temp,nums,used,ind+1);

        
    }
}