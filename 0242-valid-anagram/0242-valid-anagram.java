class Solution {
    public boolean isAnagram(String s, String t) {
     if ( s.length() != t.length() ) return false;
        int[] map = new int[26];
        for ( char i : s.toCharArray() ){
            map[i-'a']++;
        }
         for ( char i : t.toCharArray() ){
            map[i-'a']--;
        }
        for ( int i : map ){
            if ( i != 0 ) return false;
        }
        return true;
    }
}