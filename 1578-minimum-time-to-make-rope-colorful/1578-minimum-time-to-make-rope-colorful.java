
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int needed=0;
        int n=neededTime.length;
        char[] chc=colors.toCharArray();
        int cur_max=neededTime[0];
        for(int i=1;i<n;i++){
            if(chc[i-1]!=chc[i]){
                cur_max=neededTime[i];
            }else{
                needed+=Math.min(cur_max, neededTime[i]);
                cur_max=Math.max(cur_max, neededTime[i]);
            }
        }
        return needed;
    }
}