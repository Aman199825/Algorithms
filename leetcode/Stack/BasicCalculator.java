class Solution {
    public int calculate(String s) {
        long num=0;
        int pow=0;
        s=s.replaceAll(" ","");
        Stack<Object> stack=new Stack<>();
        int n=s.length();
        for(int i=n-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
               num=num+(long)Math.pow(10,pow)*(long)(ch-'0'); 
                pow+=1;
            }
            else 
            {
                if(pow!=0)
                {
                    stack.push(num);
                    pow=0;
                    num=0;
                }
                if(ch=='(')
                {
                   long res=util(stack);
                    stack.pop();
                    stack.push(res);
                }
                else
                    stack.push(ch);
            }
        }
        if(pow!=0)
        {
            System.out.println(num);
            stack.push(num);
        }
        return (int)util(stack);
    }
    long util(Stack<Object> stack)
    {
        long res=0;
        if(!stack.isEmpty())
        {
            res=(long)stack.pop();
        }
        while(!stack.isEmpty() && (char)stack.peek()!=')')
        {
            char op=(char)stack.pop();
            if(op=='+')
            {
                res+=(long)stack.pop();
            }
            else if(op=='-')
            {
                res-=(long)stack.pop();
            }
        }
        return res;
    }
}