//turn->1 indicates alex
//0->indicates lee
class StoneGame {
    int [][][] dp=null;
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n+1][n+1][2];
        Arrays.stream(dp).forEach(i->Arrays.stream(i).forEach(j->Arrays.fill(j,-1)));
       
      int res=util(piles,0,n-1,1);
        //  for(int i=0;i<=n;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //     {
        //         Arrays.stream(dp[i][j]).forEach(k->System.out.print(k+" "));
        //         System.out.println();
        //     }
        // }
        System.out.println(res);
        return res>=0;
       // return util(piles,0,n-1,1)>=0;
    }
    int util(int [] piles,int l,int r,int turn)
    {
        int n=piles.length;
        if(l>r)
            return 0;
        if(dp[l][r][turn]!=-1)
            return dp[l][r][turn];
        //alex turn
        int next=turn==1?0:1;
        if(turn==1)
              dp[l][r][turn]=Math.max(piles[l]+util(piles,l+1,r,next), piles[r]+util(piles,l,r-1,next));
          
        else
            dp[l][r][turn]=Math.min(-piles[l]+util(piles,l+1,r,next), -piles[r]+util(piles,l,r-1,next));
         
        return dp[l][r][turn];
    }
}