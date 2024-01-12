class Solution {
    public boolean halvesAreAlike(String s) {
        if ( s.length() == 1 ) return true;
        int hl = s.length()/2;
        String vowels = "AEIOUaeiou";
        int c1 = 0 , c2 = 0;
        for ( int i = 0 ; i < hl ; i++ )
        {
         if ( vowels.contains( s.charAt(i)+"")) c1++;
         if ( vowels.contains( s.charAt(i+hl)+"")) c2++;   
        }
        return c1 == c2;
    }
}