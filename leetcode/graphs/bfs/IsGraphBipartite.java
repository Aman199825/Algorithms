class IsGraphBiPartite {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int [] color=new int[n];
        for(int i=0;i<n;i++)
        {
            if(color[i]==0)
            {
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=1;
                while(!q.isEmpty())
                {
                    Integer node=q.poll();
                    for(int nei:graph[node])
                    {
                        if(color[nei]!=0)
                        {
                            if(color[nei]+color[node]!=0)
                                return false;
                        }
                        else
                        {
                            color[nei]= -color[node];
                            q.add(nei);
                        }
                    }
                }
            }
        }
        return true;
    }
}