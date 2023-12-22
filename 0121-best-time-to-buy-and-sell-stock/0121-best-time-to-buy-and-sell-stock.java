class Solution {
    public int maxProfit(int[] p) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
      for ( int i = 0 ; i < p.length ; i++ ){
          if ( p[i] < min ){
              min = p[i];
          }
          else if ( profit < (p[i]-min) ){
              profit = p[i]-min;
          }
      }
        return profit;
    }
}