class Alternate {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<Integer> [] reds=new ArrayList[n];
        List<Integer> [] blues=new ArrayList[n];
        for(int [] arr:red_edges)
        {
            if(reds[arr[0]]==null)
                reds[arr[0]]=new ArrayList<>();
            reds[arr[0]].add(arr[1]);
        }
        for(int [] arr:blue_edges)
        {
            if(blues[arr[0]]==null)
                blues[arr[0]]=new ArrayList<>();
            blues[arr[0]].add(arr[1]);
        }
        Queue<Edge> q=new LinkedList<>();
        Set<String>seen =new HashSet<>();
        int [] res=new int[n];
        Arrays.fill(res,-1);
        q.add(new Edge(0,"root"));
        int moves=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
              Edge curr=q.poll();
                int currv=curr.vertex;
              String id=currv+" "+curr.clr;
              if(seen.contains(id))
              {
                  System.out.println("blah");
                  continue;
              }
                seen.add(id);
                //check for red
                if(res[currv]==-1)
                    res[currv]=moves;
                if(curr.clr.equals("blue") || curr.clr.equals("root"))
                {
                    if(reds[currv]!=null)
                        for(int child:reds[currv])
                            q.add(new Edge(child,"red"));
                }
                if(curr.clr.equals("red") || curr.clr.equals("root"))
                {
                    if(blues[currv]!=null)
                        for(int child:blues[currv])
                            q.add(new Edge(child,"blue"));
                }
            }
            moves+=1;
        }
        return res;
    }
}
class Edge
{
    int vertex;
    String clr;
    Edge(int vertex,String clr)
    {
        this.vertex=vertex;
        this.clr=clr;
    }
}