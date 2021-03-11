//support two type of query
//add a particular value to a index(point update)
//get the sum in a range
package segmenttree;
import java.io.*;
import java.util.*;
public class RangeSumQuery {
	static int [] st=null;
	public static void main(String[] args) {
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Integer n=Integer.parseInt(br.readLine());
		String [] strarr=br.readLine().trim().split("\\s+");
		int [] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(strarr[i]);
		st=new int[4*n];
		buildTree(arr,0,0,n-1);
		Integer q=Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++)
		{
			String [] strarr2=br.readLine().trim().split("\\s+");
			int type=Integer.parseInt(strarr2[0]),qs=Integer.parseInt(strarr2[1]),qe=Integer.parseInt(strarr2[2]);
			if(type==1)
			{
                update(0, 0, n-1, qs, qe);
			}
			else if(type==2)
			{
				int res=sumquery(0, 0, n-1, qs, qe);
				System.out.println(res);
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
		if(ss==se)
		{
			st[si]=arr[ss];
			return ;
		}
		int m=ss+(se-ss)/2;
		buildTree(arr,2*si+1,ss,m);
		buildTree(arr,2*si+2,m+1,se);
		st[si]=st[2*si+1]+st[2*si+2];
		
	}
	static int sumquery(int si,int ss,int se,int qs,int qe)
	{
		if(ss>qe || se<qs)
			return 0;
		if(ss>=qs && se<=qe)
			return st[si];
		int m=ss+(se-ss)/2;
		int l=sumquery(2*si+1, ss, m, qs, qe);
		int r=sumquery(2*si+2, m+1, se, qs, qe);
		return l+r;
	}
	static void update(int si,int ss,int se,int pos,int val)
	{
		if(ss!=se)
		{
			st[si]+=val;
			return;
		}
		int m=ss+(se-ss)/2;
		if(pos<=m)
			update(2*si+1,ss,m,pos,val);
		else
			update(2*si+2,m+1,se,pos,val);
	}
}
