class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
            int n=tokens.length,res=0;
           Stack<String> stack=new Stack<>();
      //  boolean flag=false;
        for(String str:tokens)
        {
            if(str.length()>1)
                stack.push(str);
            else
            {
                char ch=str.charAt(0);
                if(!Character.isDigit(ch))
                {
                   
                    int r=Integer.parseInt(stack.pop()),l=Integer.parseInt(stack.pop());
                    int ele=0;
                    if(ch=='/')
                    {
                        ele=l/r;
                    }
                    else if(ch=='+')
                    {
                        ele=l+r;
                    }
                    else if(ch=='-')
                    {
                        ele=l-r;
                    }
                    else if(ch=='*')
                    {
                        ele=l*r;
                    }
                    stack.push(String.valueOf(ele));
                }
                else
                {
                    stack.push(str);
                }
            }
        }
        while(!stack.isEmpty())
        {
            res+=Integer.parseInt(stack.pop());
        }
        return res;
    }
}