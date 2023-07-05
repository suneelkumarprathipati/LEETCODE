class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0 ;
            List<Integer> num = new ArrayList<Integer>();
        for ( int i = 0 ; i < nums.length ; i++ ){
            if ( nums[i] == val ){
                nums[i] = 0;
            }
            else {
                num.add ( nums[i] );
            }
        }
        for ( int i = 0 ; i < num.size() ; i++ ){
          nums[i] = num.get(i);
        }
        return num.size();
    }
}