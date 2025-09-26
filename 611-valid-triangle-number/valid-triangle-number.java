import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] sides) {
        Arrays.sort(sides);
        int totalTriangles = 0;

        // Fix the largest side
        for (int longest = sides.length - 1; longest >= 2; longest--) {
            int left = 0;
            int right = longest - 1;

            while (left < right) {
                if (sides[left] + sides[right] > sides[longest]) {
                    // all pairs between left..right-1 with right are valid
                    totalTriangles += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return totalTriangles;
    }

}