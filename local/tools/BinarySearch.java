
public class BinarySearch {
	//upperbound returns last element greater or equal to a given element
  static int upperbound(int [] arr,int low,int high,int ele)
  {
	  while(low<high)
	  {
		  int mid=low+(high-low)/2;
		  if(arr[mid]<=ele)
		  {
			  low=mid+1;
		  }
		  else
	        high=mid;
	  }
	  return low;
  }
  static int lowerbound(int [] arr,int low,int high,int ele)
  {
	  while(low<high)
	  {
		int mid=low+(high-low)/2;
		if(arr[mid]<ele)
			low=mid+1;
		else 
			high=mid;
	  }
	  return low;
  }
  public static void main(String[] args) {
	int [] arr= {1,2,3,4,6};
	System.out.println(upperbound(arr,0,arr.length,0));
	System.out.println(lowerbound(arr,0,arr.length,5));
}
}
