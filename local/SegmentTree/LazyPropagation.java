package segmenttree;
import java.io.*;
import java.util.*;
public class LazyPropagation {
	static int maxn=100001;
	static int [] st=new int[4*maxn];
	static int [] lazy=new int[4*maxn];
/*void buildTree(int si,int ss,int se)
{
	if(ss==se)
	{
		st[si]=arr[ss];
	}
}*/
	static int query(int si,int ss,int se,int qs,int qe)
	{
		if(lazy[si]!=0)
		{
			int dx=lazy[si];
			lazy[si]=0;
			st[si]=dx*(se-ss+1);
			if(ss!=se)
			{
				st[2*si+1]=dx;
				st[2*si+2]=dx;
			}
		}

		if(ss > qe || se < qs) return 0;
		
		if(ss>=qs && se>=qe)
		{
			return st[si];
		}
		int m=ss+(se-ss)/2;
		int l=query(2*si+1,ss,m,qs,qe);
		int r=query(2*si+2,m+1, se, qs, qe);
		return (l+r);
	}
	static void update(int si,int ss,int se,int qs,int qe,int val)
	{
		if(lazy[si]!=0)
		{
			int dx=lazy[si];
			lazy[si]=0;
			st[si]+=dx*(se-ss+1);
			if(ss!=se)
			{
				lazy[2*si+1]+=dx;
				lazy[2*si+2]+=dx;
			}
		}
		if(ss>qe || se<qs)
			return;
		if(ss>=qs && se<=qe)
		{
			int dx=(se-ss+1)*val;
			st[si]+=dx;
			if(ss!=se)
			{
				lazy[2*si+1]+=val;
				lazy[2*si+2]+=val;
				//return;
			}
			return;
		}
		int m=ss+(se-ss)/2;
		update(2*si+1,ss,m,qs,qe,val);
		update(2*si+2,m+1,se,qs,qe,val);
		st[si]=st[2*si+1]+st[2*si+2];
	}
public static void main(String[] args) {
	try
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String [] strarr=br.readLine().trim().split("\\s+");
         Integer n=Integer.parseInt(strarr[0]),q=Integer.parseInt(strarr[1]);
         for(int i=0;i<q;i++)
         {
        	 String []  strarr2=br.readLine().trim().split("\\s+");
        	 int type=Integer.parseInt(strarr2[0]),qs=Integer.parseInt(strarr2[1]),qe=Integer.parseInt(strarr2[2]);
        	 Integer val=null;
        	 if(type==2)
        		 val=Integer.parseInt(strarr2[3]);
        	 //0->range sum query
        	 //1->update query
        	 if(type==1)
        	 {
        		 int res=query(0,0,n-1,qs,qe);
        		 System.out.println(res);
        	 }
        	 if(type==2)
        	 {
        		 update(0,0,n-1,qs,qe,val);
        	 }
         }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
