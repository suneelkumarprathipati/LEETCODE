class Solution {
    public int nearestValidPoint(int x, int y, int[][] p) {
        int min = Integer.MAX_VALUE;
        int ret = -1;
        for ( int i = 0 ; i < p.length ; i++ ){
            if ( x == p[i][0] || y == p[i][1]){
            int man = Math.abs(x-p[i][0])+Math.abs(y-p[i][1]);
            if ( man < min ){
                min = man;
                ret = i;
            }
            }
        }
        return ret;
    }
}