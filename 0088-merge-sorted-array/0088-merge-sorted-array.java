class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n-1 ;                         //index of nums2 last index
        for ( int i = m+n-1 ; j >= 0  ; i--){ // loop from last index of nums1 as i  and until 0th index of nums2
            nums1[i] = nums2[j];              //change the 0's to nums2 
            j--;                              //decrement the index of nums2
        }
        Arrays.sort(nums1);                   //finally sort the array
    }
}