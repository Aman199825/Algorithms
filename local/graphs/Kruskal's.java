class Solution {
    public int minimumCost(int n, int[][] connections) {
       
        int [] rank=new int[n];
        int [] parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
         for(int [] arr:connections)
         {
             pq.add(new int[]{arr[0]-1,arr[1]-1,arr[2]});
         }
        int count=0,res=0;
        while(count<n-1 && !pq.isEmpty())
        {
            int [] node=pq.poll();
            if(find(node[0],parent)!=find(node[1],parent))
            {
                union(find(node[0],parent),find(node[1],parent),parent,rank);
                res+=node[2];
                count+=1;
            }
        }
        return count==n-1?res:-1;
    }
        void union(int x,int y,int [] parent,int [] rank){
        int rankX=rank[x],rankY=rank[y];
        if(rankX>rankY)
        {
           parent[y]=x;  
        }
        else if(rankY>rankX)
        {
            parent[x]=y;
        }
        else
        {
            parent[y]=x;
            rank[x]+=1;
        }
    }
    int find(int x,int [] parent)
    {
        if(parent[x]==x)
            return x;
        parent[x]=find(parent[x],parent);
        return parent[x];
    }
    int findDist(int [][] points,int i,int j){
        return Math.abs((points[i][0]-points[j][0]))+Math.abs((points[i][1]-points[j][1]));
    }
}