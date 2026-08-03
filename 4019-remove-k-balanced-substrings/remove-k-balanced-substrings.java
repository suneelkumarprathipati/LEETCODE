class Solution {
    public String removeSubstring(String s, int k) {
        Stack<int[]> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek()[0] == c) {
                // Same character, increment count
                st.peek()[1]++;
            } else {
                // Different character, push new entry
                st.push(new int[]{c, 1});
            }
            
            // Check if the last two groups form a k-balanced substring
            int n = st.size();
            if (n >= 2 && st.get(n-2)[0] == '(' && st.get(n-2)[1] >= k &&
                st.get(n-1)[0] == ')' && st.get(n-1)[1] == k) {
                
                // Remove k opening parentheses
                st.get(n-2)[1] -= k;
                
                // Remove the closing parentheses group
                st.pop();
                
                // Remove the opening parentheses group if its count is now 0
                if (st.peek()[1] == 0) {
                    st.pop();
                }
            }
        }
        
        // Reconstruct the result string from remaining groups
        StringBuilder result = new StringBuilder();
        for (int[] pair : st) {
            char c = (char) pair[0];
            int count = pair[1];
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}