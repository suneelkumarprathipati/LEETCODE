//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
       int res = 0; 
       for ( int i = 0 ; i < nums.length;i++){
           res^=nums[i];
       }
       res=res&(~(res-1));
       int res1=0,res2=0;
       for(int i=0;i<nums.length;i++){
           if((res&nums[i])==0){
               res1^=nums[i];
           }
           else{
               res2^=nums[i];
           }
       }
       int temp1=res1,temp2=res2;
       res1=Math.min(temp1,temp2);
       res2=Math.max(temp1,temp2);
       int arr[] = {res1,res2};
       return arr;
    }
}