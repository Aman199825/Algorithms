
import java.io.*;
import java.util.*;
public class RSMQ {
	static int inf=Integer.MAX_VALUE/3;
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
		int qs=Integer.parseInt(strarr2[0]),qe=Integer.parseInt(strarr2[1]);
		int res=minquery(0, 0, n-1, qs, qe);
		System.out.println(res);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
static int buildTree(int [] arr,int si,int ss,int se)
{
	//System.out.println("ss is: "+ss+" si is: "+si);

	if(ss==se)
	{
		st[si]=arr[ss];
		return arr[ss];
	}
	int mid=ss+(se-ss)/2;
	int l=buildTree(arr,2*si+1,ss,mid);
	int r=buildTree(arr,2*si+2,mid+1,se);
	
	st[si]=Math.min(l,r);
	return st[si];
}
static int minquery(int si,int ss,int se,int qs,int qe)
{
	//no overlap
	if(qs>se || qe<ss)
		return inf;
	//complete overlap
	if(qs<=ss && qe>=se)
		return st[si];
	int mid=ss+(se-ss)/2;
	int l=minquery(2*si+1,ss,mid,qs,qe);
	int r=minquery(2*si+2,mid+1,se,qs,qe);
	return Math.min(l,r);
}
}
