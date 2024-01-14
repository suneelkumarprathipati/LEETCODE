class Solution {
    public boolean closeStrings(String w1, String w2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for ( int i = 0 ; i < w1.length() ; i++ ){
            f1[w1.charAt(i)-'a']++;
        }
          for ( int i = 0 ; i < w2.length() ; i++ ){
            f2[w2.charAt(i)-'a']++;
        }
          for ( int i = 0 ; i < 26 ; i++ ){
            if ( f1[i] > 0 && f2[i] == 0 || f1[i] == 0 && f2[i] > 0 ) return false;
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for ( int i = 0 ; i < 26 ; i++ ){
            if ( f1[i] != f2[i] ) return false;
        }
        return true;
    }
}