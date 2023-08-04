class Solution {
   public boolean wordBreak(String s, List<String> wordDict) {
    return dfs(s, wordDict, 0, new int[s.length()]);
}

private boolean dfs(String s, List<String> wordDict, int index, int[] dp) {
    if(index >= s.length()) return true;
    if(dp[index] != 0) {
        return dp[index] > 0;
    }
    boolean result = false;
    for(String w: wordDict) {
        if(s.length() - index < w.length()) continue;
        boolean ok = true;
        int j = index;
        for(int i = 0; i < w.length(); i++) {
            if(w.charAt(i) != s.charAt(j++)) {
                ok = false;
                break;
            }
        }
        if(ok && dfs(s, wordDict, j, dp)) {
            result = true;
            break;
        }
    }
    dp[index] = result ? 1 : -1;
    return result;
}
}