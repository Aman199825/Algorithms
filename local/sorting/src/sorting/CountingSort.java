package sorting;

import java.util.Arrays;

public class CountingSort {
  static void countingsortutil(int [] arr,int k)
  {
	  int n=arr.length;
	  int [] count=new int[k];
	  int [] res=new int[n];
	  for(int i=0;i<n;i++)
	  {
		  count[arr[i]]+=1;
	  }
	  for(int i=1;i<k;i++)
	  {
		  count[i]+=count[i-1];
	  }
	  for(int i=0;i<n;i++)
	  {
		  res[count[arr[i]]-1]=arr[i];
		  count[arr[i]]-=1;
	  }
	  for(int i=0;i<n;i++)
		  arr[i]=res[i];
	  Arrays.stream(arr).forEach(i->System.out.print(i+" "));
  }
  public static void main(String[] args) {
	int [] arr= {0,0,3,3,1,1,2,2,0,3,1,2};
	countingsortutil(arr, 4);
}
}
