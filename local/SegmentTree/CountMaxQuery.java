package segmenttree;
import java.io.*;
import java.util.*;
import java.awt.Point;

public class CountMaxQuery {
	static Point [] st=null;
	//static int inf=Integer.MAX_VALUE/2;
 	public static void main(String[] args) {
	try
	{
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             
             String [] strarr=br.readLine().trim().split("\\s+");
             Integer n=Integer.parseInt(strarr[0]),q=Integer.parseInt(strarr[1]);
             st=new Point[4*n];
            		 
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
            	 int type=Integer.parseInt(strarr3[0]),qs=Integer.parseInt(strarr3[1]),qe=Integer.parseInt(strarr3[2]);
            	 if(type==1)
            	 {
            		 update(0,0,n-1,qs,qe);
            	 }
            	 else if(type==2)
            	 {
                      System.out.println(getmax(0, 0, n-1, qs, qe)); 		 
            	 }
             }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	static private void buildTree(int [] arr,int si,int ss,int se)
	{
	   if(st[si]==null)
	   {
		   st[si]=new Point(0,0);
	   }
	   if(ss==se)
	   {
		   st[si]=new Point(arr[ss],1);
		   return;
	   }
	   else
	   {
		   int m=ss+(se-ss)/2;
		   buildTree(arr,2*si+1,ss,m);
		   buildTree(arr,2*si+2,m+1,se);
		  st[si]=combine(st[2*si+1],st[2*si+2]);
	   }
	}
	//update: put an particular element at a given index
	static void update(int si,int ss,int se,int pos,int val)
	{
		if(ss==se)
		{
			st[si]=new Point(val,1);
			return;
		}
		int m=ss+(se-ss)/2;
		update(2*si+1,ss,m,pos,val);
		update(2*si+2,m+1,se,pos,val);
		st[si]=combine(st[2*si+1],st[2*si+2]);
	}
	static Point combine(Point a,Point b)
	{
		if(a.x>b.x)
			return a;
		else if(b.x>a.x)
			return b;
		a=new Point(a.x,a.y+b.y);
		return a;
	}
	static int getmax(int si,int ss,int se,int qs,int qe)
	{
		if(qs>qe)
		  return 0;
		if(qs==ss && qe==se)
		{
		   return st[si].y;	
		}
		int m=ss+(se-ss)/2;
		int l=getmax(2*si+1,ss,m,qs,Math.min(qe,m));
		int r=getmax(2*si+2,m+1,se,Math.max(qs, m+1),qe);
		return l+r;
	}
}
