class UnqiueBinarySearchTrees_GapFill {
    public int numTrees(int n) {
        if(n<=2)
            return n;
        int [][] dp=new int[n][n];
        // for(int i=0;i<n;i++)
        //     dp[0][i]=1;
        for(int i=0;i<n;i++)
            dp[i][0]=1;
        dp[0][1]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=Math.min(i+1,n-1);j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[n-1][n-1];
    }
}