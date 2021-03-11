package segmenttree;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class CandidateCode {
	static long [] arr=new long[20001];
    public static void main(String args[] ) throws Exception {
          try
          {
    	//Write code here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Integer n=Integer.parseInt(br.readLine());
       
        BigInteger res=BigInteger.valueOf(Long.MIN_VALUE);
        String [] strarr=br.readLine().trim().split("\\s+");
        for(int i=0;i<n;i++)
        {
            arr[i+1]=Long.parseLong(strarr[i]);
        }
        //n-=1;
        for(int i=1;i<=n;i++)
        {
        	{
        	int l=i-1,r=i;
        	BigInteger maxoverall=new BigInteger("0");
            BigInteger maxcurr=new BigInteger("0");
        	//long max=0,curr=0;
        	while(l>=1 && r<=n)
        	{
        	   BigInteger ele=BigInteger.valueOf(arr[l]).multiply(BigInteger.valueOf(arr[r]));
        	   maxcurr=maxcurr.add(ele);
        	   if(maxoverall.compareTo(maxcurr)==1)
        	   {
        		   maxoverall=maxcurr;
        	   }
        	   BigInteger tempele=maxcurr.subtract(maxoverall);
        	    if(res.compareTo(tempele)==-1)
        	    {
        	    	res=tempele;
        	    }
        	    --l;
        	    ++r;
        	}
        	}
        	{
        		int l=i-1,r=i+1;
            	BigInteger maxoverall=new BigInteger("0");
                BigInteger maxcurr=new BigInteger("0");
            	//long max=0,curr=0;
            	while(l>=1 && r<=n)
            	{
            	   BigInteger ele=BigInteger.valueOf(arr[l]).multiply(BigInteger.valueOf(arr[r]));
            	   maxcurr=maxcurr.add(ele);
            	   if(maxoverall.compareTo(maxcurr)==1)
            	   {
            		   maxoverall=maxcurr;
            	   }
            	   BigInteger tempele=maxcurr.subtract(maxoverall);  
            	    if(res.compareTo(tempele)==-1)
            	    {
            	    	res=tempele;
            	    }
            	    --l;
            	    ++r;
            	}		
        	}
        }
    	System.out.println(res);

          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
   }
   
}

