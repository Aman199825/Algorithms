package sorting;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {
	static void sort(int [] arr,int low,int high)
	{
		if(low <high)
		{
		int pt=partition(arr,low,high);
		sort(arr,low,pt-1);
		sort(arr,pt+1,high);
		}
	}
static int partition(int [] arr,int low,int high)
{
	random(arr,low,high);
	int i=low-1;
	int piv=arr[high];
	for(int j=low;j<high;j++)
	{
		if(arr[j]<piv)
		{
			i++;
			int t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
	}
	i+=1;
	int t=arr[high];
	arr[high]=arr[i];
	arr[i]=arr[high];
	return i;
}
static void random(int [] arr,int low,int high)
{
	Random rnd=new Random();
	int ind=rnd.nextInt(high-low)+low;
	int t=arr[high];
	arr[high]=arr[ind];
	arr[ind]=t;
}
public static void main(String[] args) {
	  int arr[] = {10, 7, 8, 9, 1, 5};
	  sort(arr,0,arr.length-1);
	  Arrays.stream(arr).forEach(i->System.out.print(i+" "));
}
}
