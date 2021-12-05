//lc  question: find the duplicate element
class Solution {
    public int findDuplicate(int[] nums) {
        Integer res=null;
       for(int i=0;i<nums.length;i++)
       {
           Integer ele=Math.abs(nums[i]);
           if(nums[ele-1]<0)
               return ele;
           else
               nums[ele-1]*=-1;
       }
        return res;
    }
}