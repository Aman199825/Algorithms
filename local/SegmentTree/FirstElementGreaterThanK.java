package segmenttree;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstElementGreaterThanK {
	static Integer [] st=null;
	//static int inf=Integer.MAX_VALUE/2;
 	public static void main(String[] args) {
	try
	{
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             
             String [] strarr=br.readLine().trim().split("\\s+");
             Integer n=Integer.parseInt(strarr[0]),q=Integer.parseInt(strarr[1]);
             st=new Integer[4*n];
            		 
             String [] strarr2=br.readLine().trim().split("\\s+");
             int [] arr=new int[n];
             for(int i=0;i<n;i++)
             {
            	 arr[i]=Integer.parseInt(strarr2[i]);
             }
             buildTree(arr, 0, 0,n-1);
             for(int i=0;i<q;i++)
             {
            	 String [] strarr3=br.readLine().trim().split("\\s+");
            	 int qs=Integer.parseInt(strarr3[0]),qe=Integer.parseInt(strarr3[1]),x=Integer.parseInt(strarr3[2]);
            	 System.out.println(arr[getFirst(0, 0, n-1, qs, qe,x)]); 		 
            	 
             }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
 	static private void buildTree(int [] arr,int si,int ss,int se)
 	{
 		if(se==ss)
 		{
 			st[si]=arr[ss];
 			return;
 		}
 		int m=ss+(se-ss)/2;
 		buildTree(arr,2*si+1,ss,m);
 		buildTree(arr,2*si+2,m+1,se);
 		st[si]=Math.max(st[2*si+1], st[2*si+2]);
  	}
 	static private int getFirst(int si,int ss,int se,int qs,int qe,int x)
 	{
 		if(se<qs || ss>qe)
 			return -1;
 		if(ss>=qs && se<=qe)
 		{
 			if(st[si]<=x)
 				return -1;
 			while(ss!=se)
 			{
 			  int m=ss+(se-ss)/2;
 			  if(st[2*si+1]>x)
 			  {
 				  si=2*si+1;
 				  se=m;
 			  }
 			  else 
 			  {
 				  si=2*si+2;
 				  ss=m+1;
 			  }
 			}
 			return ss;
 		}
 		int m=ss+(se-ss)/2;
 		int l=getFirst(2*si+1, ss, m, qs, qe, x);
 		if(l!=-1)
 			return l;
 		int r=getFirst(2*si+2,m+1,se,qs,qe,x);
 		return r;
 	}
}
