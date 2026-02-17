class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> time = new ArrayList<>();
         for ( int i = 0 ; i < 12 ; i++ ){
            for ( int j = 0 ; j < 60 ; j++ ){
                int t = Integer.bitCount(i)+Integer.bitCount(j);
                if (t == turnedOn ){
                 String ti = i+":"+(( j < 10) ? "0"+j : j);
                       time.add(ti);
                }
            }
          
         }
         return time;
    }
}