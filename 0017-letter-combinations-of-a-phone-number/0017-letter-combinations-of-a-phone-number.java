class Solution {
   String[] letters={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        
        if(digits==null || digits.length()==0)
            return ans;
        
        helper(digits, ans, "", 0);
        return ans;
    }
    
    private void helper(String dig, List<String>ans, String cur, int index){
        //base case
        if(index==dig.length()){
            ans.add(cur);
            return;
        }
        //convert 1st character to integer
        int idx= Integer.parseInt(String.valueOf(dig.charAt(index)));
        String curletters= letters[idx]; //get the respective mapping
        
        for(int i=0;i<curletters.length();i++){
            String newCur= cur+ curletters.charAt(i);
            helper(dig, ans, newCur, index+1);
        }
    }
}