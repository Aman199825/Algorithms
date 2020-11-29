class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        int n=input.length();
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            char ch=input.charAt(i);
            if(!Character.isDigit(ch))
            {
                List<Integer> l=diffWaysToCompute(input.substring(0,i));
                List<Integer> r=diffWaysToCompute(input.substring(i+1));
                for(int t1:l)
                {
                   for(int t2:r)
                   {
                       if(ch=='+')
                       {
                           res.add(t1+t2);
                       }
                       else if(ch=='-')
                       {
                           res.add(t1-t2);
                       }
                       else if(ch=='*')
                       {
                           res.add(t1*t2);
                       }
                   }
                }
            }
            
        }
        if(res.size()==0)
        {
          res.add(Integer.parseInt(input));
        }
        return res;
    }
}