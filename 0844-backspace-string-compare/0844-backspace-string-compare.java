public class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Helper function to reverse a string
        String reversedS = reverseString(s);
        String reversedT = reverseString(t);

        int i = 0; // Pointer for reversedS
        int j = 0; // Pointer for reversedT

        while (i < reversedS.length() || j < reversedT.length()) {
            // Skip backspaces in reversedS
            int backspacesS = 0;
            while (i < reversedS.length() && (reversedS.charAt(i) == '#' || backspacesS > 0)) {
                if (reversedS.charAt(i) == '#') {
                    backspacesS++;
                } else {
                    backspacesS--;
                }
                i++;
            }

            // Skip backspaces in reversedT
            int backspacesT = 0;
            while (j < reversedT.length() && (reversedT.charAt(j) == '#' || backspacesT > 0)) {
                if (reversedT.charAt(j) == '#') {
                    backspacesT++;
                } else {
                    backspacesT--;
                }
                j++;
            }

            // Compare characters
            if (i < reversedS.length() && j < reversedT.length()) {
                if (reversedS.charAt(i) != reversedT.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else if (i < reversedS.length() || j < reversedT.length()) {
                // One of the strings reached the end while the other didn't
                return false;
            }
        }

        return true;
    }

    private String reverseString(String s) {
        // Helper function to reverse a string
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }


}