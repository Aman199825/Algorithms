class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
         int  parent[]=new int[n],rank[]=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                pq.add(new int[]{findManhattanDist(points,i,j),i,j});
            }
        }
        int count=0,res=0;
        while(count<n-1)
        {
            int [] edge=pq.poll();
            if(find(edge[1],parent)!=find(edge[2],parent))
            {
                union(edge[1],edge[2],parent,rank);
                count+=1;
                res+=edge[0];
            }
        }
        return res;
    }
    int findManhattanDist(int [][] points,int ind1,int ind2)
    {
        return Math.abs(points[ind2][0]-points[ind1][0])+Math.abs(points[ind2][1]-points[ind1][1]);
    }
    void union(int x,int y,int [] parent,int [] rank)
    {
        int rootX=find(x,parent),rootY=find(y,parent);
        if(rank[rootX]>rank[rootY])
           parent[rootY]=rootX;
        else if(rank[rootX]<rank[rootY])
            parent[rootX]=rootY;
        else
        {
            parent[rootY]=rootX;
            rank[rootX]+=1;
        }
    }
    int find(int x,int [] parent)
    {
        if(x==parent[x])
            return x;
        parent[x]=find(parent[x],parent);
        return parent[x];
    }
}
