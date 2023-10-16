class Solution {
    public int maxProfit(int[] Arr) {
        int n=Arr.length;
        int k=2;
        int dp[][][]=new int[n+1][2][k+1];
        for(int ind = n-1; ind>=0; ind--)
        {
         for(int buy = 0; buy<=1; buy++)
         {
            for(int cap=1; cap<=2; cap++)
            {
                
                if(buy==0){
                    dp[ind][buy][cap] = Math.max(0+dp[ind+1][0][cap], 
                                -Arr[ind] + dp[ind+1][1][cap]);
                 }
    
                if(buy==1){
                    dp[ind][buy][cap] = Math.max(0+dp[ind+1][1][cap],
                                Arr[ind] + dp[ind+1][0][cap-1]);
                }
            }
        }
    }
    
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=1;j++){
        //         for(int l=0;l<=k;l++){
        //             System.out.print(dp[i][j][l]+" ");
        //         }
        //     }
        // }
        return dp[0][0][k];
    }
}
