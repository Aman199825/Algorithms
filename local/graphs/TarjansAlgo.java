import java.util.*;
import java.io.*;
public class TarjansAlgo {
	static Integer timer=null,res=null;
	static List<Integer> [] adj=null;
	static int scc(int [][] graph)
	{
		res=0;
		timer=0;
		int n=graph.length;
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			adj[i]=new LinkedList<>();
		}
		for(int [] arr:graph)
		{
			adj[arr[0]].add(arr[1]);
			//adj[arr[1]].add(arr[0]);
		}
		Stack<Integer> stack=new Stack<>();
		int [] ids=new int[n];
		int [] low=new int[n];
		boolean [] onstack=new boolean[n];
		Arrays.fill(ids, -1);
		for(int i=0;i<n;i++)
		{
			if(ids[i]==-1)
			dfs(i,stack,ids,low,onstack);
		}
		return res;
	}
static void dfs(int src,Stack<Integer> stack,int [] ids,int [] low,boolean [] onstack)
{
	onstack[src]=true;
	stack.push(src);
	low[src]=ids[src]=timer++;
	for(int nei:adj[src])
	{
		if(ids[nei]==-1)
			dfs(nei,stack,ids,low,onstack);
		if(onstack[nei])
		{
			low[src]=Math.min(low[src], low[nei]);
		}

	}
	if(low[src]==ids[src])
	{
		while(!stack.isEmpty())
		{
			Integer node=stack.pop();
			onstack[node]=false;
			if(node==src)
			{
				res+=1;
				break;
			}
		}
	}
}
public static void main(String[] args) {
	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int n=5;
	int [][] graph=new int[n][n];
	int i=0;
	graph[i++]=new int[] {1,0};
	graph[i++]=new int[] {0,2};
	graph[i++]=new int[] {2,1};
	graph[i++]=new int[] {0,3};
	graph[i++]=new int[] {3,4};
    System.out.println(scc(graph));
}
}
