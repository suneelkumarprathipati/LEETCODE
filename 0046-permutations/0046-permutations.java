class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer>tillNow    = new ArrayList<>();
        int n = nums.length;
        recursion(ans,tillNow, nums, n);
        return ans;
    }
    
    private void recursion(List<List<Integer>> ans, List<Integer>tillNow, int[]nums, int n){
        if(tillNow.size()==n) {
            ans.add(new ArrayList<>(tillNow));
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(nums[i]==20) continue;
            int val = nums[i];
            tillNow.add(val);
            nums[i] =20;
            recursion(ans,tillNow, nums, n);
            nums[i] = val;
            tillNow.remove(tillNow.size()-1);
        }
    }
}