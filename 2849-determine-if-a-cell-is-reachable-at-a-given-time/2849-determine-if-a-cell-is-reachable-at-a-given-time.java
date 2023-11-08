class Solution {
  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    final int minStep = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
    if (minStep == 0) {
      return t != 1;
    }
    return minStep <= t;
  }
}