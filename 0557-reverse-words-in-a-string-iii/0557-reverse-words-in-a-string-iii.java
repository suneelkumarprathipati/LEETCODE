class Solution {
    public String reverseWords(String s) {
        String ret = "";
        String[] split  = s.split(" ");
        for ( int i = 0 ; i < split.length ; i++ ){
            StringBuilder temp = new StringBuilder(split[i]);
            ret+=temp.reverse().toString();
            if(i < split.length-1)
                ret+=" ";
        }
            return ret;
    }
}