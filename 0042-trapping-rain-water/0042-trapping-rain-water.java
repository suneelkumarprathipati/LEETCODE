class Solution {
    public int trap(int[] h) {
        int leftmax = h[0];
        int rightmax = h[h.length-1];
        int l = 0 , r = h.length-1;
        int ret = 0;
        while ( l < r ){
            if ( h[l] > h[r] ){
                if ( h[r] > rightmax ){
                    rightmax = h[r];
                }
                else ret += rightmax-h[r];
                r--;
            }
            else {
                if ( h[l] > leftmax ){
                    leftmax = h[l];
                }
                else ret += leftmax-h[l];
                l++;
            }
        }
        return ret;
    }
}