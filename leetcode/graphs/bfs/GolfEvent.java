class GolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
       PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int res=0;
        int [] start=new int[2];
        for(int i=0;i<forest.size();i++)
        {
            for(int j=0;j<forest.get(0).size();j++)
            {
                if(forest.get(i).get(j)>1)
                    pq.add(new int[]{i,j,forest.get(i).get(j)});
            }
        }
        while(!pq.isEmpty())
        {
            int [] next=pq.poll();
            int currSteps=bfs(forest,start,next);
            if(currSteps<0)
                return -1;
            res+=currSteps;
            start[0]=next[0];
            start[1]=next[1];
        }
        return res;
    }
    int bfs(List<List<Integer>> forest,int [] start,int [] dest)
    {
        int n=forest.size(),m=forest.get(0).size();
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        boolean [][] visited=new boolean[n][m];
        visited[start[0]][start[1]]=true;
        int [] xdir={1,-1,0,0};
        int [] ydir={0,0,1,-1};
        int steps=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            int [] curr=q.poll();
            //visited[curr[0]][curr[1]]=true;
            if(curr[0]==dest[0] && curr[1]==dest[1])
                return steps;
            for(int k=0;k<4;k++)
            {
                int x1=curr[0]+xdir[k],y1=curr[1]+ydir[k];
                if(isValid(forest,x1,y1) && !visited[x1][y1])
                {
                    q.add(new int[]{x1,y1});
                    visited[x1][y1]=true;
                }
            }
            }
            steps+=1;
        }
        return -1;
    }
    boolean isValid(List<List<Integer>> forest,int x,int y)
    {
        return (x>=0 && x<forest.size() && y>=0 && y<forest.get(0).size() && forest.get(x).get(y)>0);
    }
}