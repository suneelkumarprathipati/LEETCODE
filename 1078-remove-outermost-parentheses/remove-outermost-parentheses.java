class Solution {
    public String removeOuterParentheses(String s) {
        String ret = "";
        Deque<Character> stack = new ArrayDeque<>();
        for( int i = 0 ; i < s.length()-1; i++ ){
            
            if ( s.charAt(i) == '(' ){
                
                if (!stack.isEmpty()) ret += "(";
                stack.push('(');
            }
            else {
                stack.pop();
                
                if ( !stack.isEmpty() ) ret +=")";
            }

        }
        return ret;
    }
}