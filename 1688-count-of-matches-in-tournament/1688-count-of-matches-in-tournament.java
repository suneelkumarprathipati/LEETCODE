class Solution {
    public int numberOfMatches(int n) {
        int ret = 0 ;
        while (  n > 0 ){
            if ( n == 1 ) {
                break;
            }
            if ( n % 2 == 0 ){
                ret += n/2;
                n = n/2;
            }
            else {
                ret += n/2;
                n = n/2 + 1;
            }
            System.out.println(ret);
        }
        return ret;
    }
}