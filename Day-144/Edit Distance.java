class Solution {
    public int minDistance(String word1, String word2) {
              int n = word1.length();
        int m = word2.length();

        int [][] dp = new int [n + 1][m + 1];
        for(int [] d : dp)
            Arrays.fill(d, -1);

        return minDistanceTab(word1, word2, n, m, dp);
    }

    public int minDistanceTab(String word1,  String word2, int N, int M, int [][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = n == 0 ? m : n;
                    continue;
                }

                if(word1.charAt(n - 1) == word2.charAt(m - 1)){
                    dp[n][m] = dp[n - 1][m - 1];
                }
                else{
                    int replace = dp[n - 1][m - 1];;
                    int delete = dp[n - 1][m];;
                    int insert = dp[n][m - 1];;
                    dp[n][m] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
      return    dp[N][M];
    }
}
  
    