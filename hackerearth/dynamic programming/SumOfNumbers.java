import java.io.*;
import java.util.*;
public class SumOfNumbers {
public static void main(String[] args) {
	try
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Integer T=Integer.parseInt(br.readLine());
	while(T-->0)
	{
		Integer n=Integer.parseInt(br.readLine());
		String [] strarr=br.readLine().trim().split("\\s+");
		Integer sum=Integer.parseInt(br.readLine());
		int [] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(strarr[i]);
		if(util(arr,sum))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
static boolean util(int [] arr,int sum)
{
	int n=arr.length;
	int tot=1<<n;
	for(int mask=0;mask<tot;mask++)
	{
		int temp=0;
		for(int j=0;j<n;j++)
		{
			int ele=1<<j;
			if((ele&mask)!=0)
			{
				temp+=arr[j];
			}
			if(temp==sum)
				return true;
		}
		if(temp==sum)
			return true;
	}
	return false;
}
}
