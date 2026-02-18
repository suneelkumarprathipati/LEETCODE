class Solution {
    public boolean hasAlternatingBits(int n) {
        String t = Integer.toBinaryString(n);
        System.out.println(t);
        if (t.contains("11") || t.contains("00")) return false;
        return true;
    }
}