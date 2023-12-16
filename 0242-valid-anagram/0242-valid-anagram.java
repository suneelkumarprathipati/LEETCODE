class Solution {
    public boolean isAnagram(String s, String t) {
        s=s.toLowerCase();
        t=t.toLowerCase();
        char[] sc=s.toCharArray();
        char[] tc=t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc,tc);
    }
}