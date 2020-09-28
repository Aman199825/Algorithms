class GasStations
 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        if(n==0)
            return 0;
        //what parameters do we need ?
        int tank=0;
        
        for(int i=0;i<n;i++)
        {
            tank+=gas[i];
            int idx=i;
            int j=(i+1)%n;
          // int temp=j;         
            while(true)
            {
             //   System.out.println(" i is: "+i+" ")
               
                tank-=cost[idx];
                if(tank<0)
                    break;
               
                idx=(idx+1)%n;
                tank+=gas[j];
                    //System.out.println("i is: "+i+" j is: "+j);   
                if(j==i)
                    return i;

                  if(j==i)
                    return i;
                j=(j+1)%n;
                
            
            }
            tank=0;
            
        }
        return -1;
    }
}