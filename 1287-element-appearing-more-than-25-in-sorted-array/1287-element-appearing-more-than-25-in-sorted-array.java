class Solution {
    public int findSpecialInteger(int[] arr) {
        int per = (int)arr.length*(25/100);
        int count = 1, index = 0 , max = 0;
        
        for ( int i = 1 ; i < arr.length ; i++ ){
            if ( count > max && count > per && arr[i] == arr[i-1] ){
                max = count;
                index = i;
            }
            if ( arr[i] == arr[i-1]){
                count++;
            }
            else {
                count = 1;
            }
        }
        return arr[index];
    }
}