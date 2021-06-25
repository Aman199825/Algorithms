class GenerateParentheses
 {
    public List<String> generateParenthesis(int n) 
    {
      List<String> res=new ArrayList<>();
       util( res,n,n,"");
        return res;
    }
     public static void util(List<String> res,int left,int right,String current)
     {
         if(left==0 && right==0)
         {
               res.add(current);
               return;
             }
         if(left > 0)
         {
             util(res,left-1,right,current+"(");
         }
         if(left < right)
         {
             util(res,left,right-1,current+")");
         }
     }
}