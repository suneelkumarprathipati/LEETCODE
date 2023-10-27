class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0 ) return s;
        int max = 0 ; 
        String temp = "";
        for ( int i = 0 ; i < s.length() ; i++ ){
            for ( int j = i+1 ; j <= s.length() ; j++ ){
                if ( palindrome(s.substring( i , j ))){
                    if ( (j-i) > max ){
                        temp = s.substring( i , j );
                        max = j-i;
                    }
                }
            }
        }
        return temp;
    }
    static boolean palindrome( String t ){
        int i = 0 , j = t.length()-1;
        while ( i <= j ){
            if ( t.charAt(i) != t.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}