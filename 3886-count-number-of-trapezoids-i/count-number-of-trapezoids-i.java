class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final int INV2 = 500_000_004;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) {
            yCount.put(p[1], yCount.getOrDefault(p[1], 0) + 1);
        }

        long totalSeg = 0; 
        long totalSq = 0;  

        for (int cnt : yCount.values()) {
            if (cnt < 2) continue;
            
            long seg = (long) cnt * (cnt - 1) / 2; 
            totalSeg = (totalSeg + seg) % MOD;
            totalSq = (totalSq + seg % MOD * (seg % MOD)) % MOD;
        }

        long totalSegMod = totalSeg % MOD;
        long ans = (totalSegMod * totalSegMod % MOD - totalSq + MOD) % MOD;
        ans = ans * INV2 % MOD;

        return (int) ans;
    }
}