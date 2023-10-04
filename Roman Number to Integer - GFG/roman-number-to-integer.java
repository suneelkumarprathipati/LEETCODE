//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        if ( s == null || s.length() == 0 ) return 0;
        int prev = 0 ;
         int ret = 0;
       for ( int i = s.length()-1 ; i >= 0 ; i-- ){
           int curr = 0;
           char c = s.charAt(i);
           switch( c ){
               case 'I': curr = 1; break;
               case 'V': curr = 5; break;
               case 'X': curr = 10; break; 
               case 'L': curr = 50; break;
               case 'C': curr = 100; break;
               case 'D': curr = 500; break;
               case 'M': curr = 1000; break;
               
           }
           if ( curr < prev ) ret -= curr;
           else ret += curr;
           prev = curr;
       }
       return ret;
    }
}