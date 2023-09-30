//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] temp = new int[row][col];
        for ( int i = 0 ; i < row ; i++ ){
            for ( int j = 0 ; j < col ; j++ ){
                if ( matrix[i][j] == 1 ){
                    rowcol(temp,i,j,row,col);
                }
            }
        }
             for ( int i = 0 ; i < row ; i++ ){
            for ( int j = 0 ; j < col ; j++ ){
                matrix[i][j] = temp[i][j];
            }
             }
            
        
    }
    static void rowcol(int[][] temp , int i , int j , int row , int col ){
        for ( int k = 0 ; k < row ; k++ ){
            temp[k][j] =1;
        }
        for ( int k = 0 ; k < col ; k++ ){
            temp[i][k] =1;
        }
        
    }
}