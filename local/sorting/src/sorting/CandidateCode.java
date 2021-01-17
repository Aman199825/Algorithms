package sorting;


import java.io.*;
import java.util.*;
class Element
{
	String val;
	Element(String val)
	{
		this.val=val;
	}
	
	@Override
	public int hashCode() {
		return this.val.length();
	}
	
}
	public class CandidateCode {
	    static List<Integer> list=null;
	    static Set<Element> set=null;
	    public static void main(String args[] ) throws Exception {

	    	//Write code here
	       try
	       {
	            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            String [] strarr=br.readLine().trim().split("\\s+");
	            list=new ArrayList<>();
	            long v=Long.parseLong(strarr[0]),m=Long.parseLong(strarr[1]),mx=Long.parseLong(strarr[2]);
	            int ind=0;
	            for(long i=m;i<=mx;i++)
	            {
	                set=new HashSet<>();
	               
	                util("",i,"");
	                list.add(ind++, set.size());
	            }
               //list.forEach(i->System.out.print(i+" "));
	            long mod=1000000007,res=0;
	            for(int i=0;i<list.size();i++)
	            {
	            	res=(res+binomial(list.get(i),v))%mod;
	            }
	            System.out.println(res);
	       }  
	       catch(Exception e)
	       {
	           e.printStackTrace();
	       }
	   }
	    static void util(String str,long size,String prev)
	    {
	    	if(str.length()==size)
	    	{
	    		set.add(new Element(str));
	    		return;
	    	}
	    	if(!prev.equals("R"))
	    	{
	    		if(!set.contains(new Element(str+"R")))
	    		util(str+"R",size,"R");
	    	}
	    	if(!set.contains(new Element(str+"L")))
	        util(str+"L",size,"L");	  
	    }
	    static long binomial(long n, long k) 
	    { 
	        long res = 1; 

	        if (k > n - k) 
	            k = n - k; 
	  
	        for (long i = 0; i < k; ++i) { 
	            res *= (n - i); 
	            res /= (i + 1); 
	        } 
	  
	        return res; 
	    }
	}



