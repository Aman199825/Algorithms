class Permutations2
 {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> res=new ArrayList<>();
       int n=nums.length;
        Arrays.sort(nums);
      util(nums,res,new ArrayList<>(),new boolean[n],0); 
    return res;
    }
    void util(int [] nums,List<List<Integer>> res,List<Integer>temp,boolean [] used,int pos)
    {
        int n=nums.length;
        System.out.println(temp);
        if(temp.size()==n)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(used[i])
                continue;
            
            if(i>0 && !used[i-1] && nums[i]==nums[i-1])
            {
                continue;
            }
            temp.add(nums[i]);
            used[i]=true;
            util(nums,res,temp,used,i+1);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }        

}