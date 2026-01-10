/*
    Problem Statement:
    -----------------
    We are given two strings s1 and s2.
    We are allowed to delete characters from either string.

    The cost of deleting a character is its ASCII value.

    Our goal is to make the two strings equal with the
    MINIMUM possible total ASCII deletion cost.

    ---------------------------------------------------

    Key Observation:
    ----------------
    Instead of directly thinking about deletions, it is easier
    to think about what we KEEP.

    If we keep a common subsequence in both strings:
        - That subsequence is NOT deleted from either string.
        - Everything else is deleted.

    Let:
        cost1 = total ASCII sum of s1
        cost2 = total ASCII sum of s2
        keep  = ASCII sum of a common subsequence kept in both

    Then:
        total deletion cost
        = (cost1 - keep) + (cost2 - keep)
        = cost1 + cost2 - 2 * keep

    So the problem reduces to:
    --------------------------------
    Find a common subsequence of s1 and s2
    whose ASCII sum is MAXIMUM.

    ---------------------------------------------------

    DP Definition:
    --------------
    Let:
        dp[i][j] = maximum ASCII sum of a common subsequence
                    between s1[i..n-1] and s2[j..m-1]

    dp[i][j] answers:
        "What is the best ASCII value we can keep
            if we start from index i in s1 and j in s2?"

    ---------------------------------------------------

    Base Case:
    ----------
    If either string is exhausted:
        dp[n][*] = 0
        dp[*][m] = 0

    This is correct because no common subsequence is possible.

    ---------------------------------------------------

    Transition:
    -----------
    At position (i, j):

    1) If characters match:
            s1[i] == s2[j]

        Then we KEEP this character in the subsequence.
        Its ASCII value contributes to the total.

            dp[i][j] = ASCII(s1[i]) + dp[i+1][j+1]

    2) If characters do NOT match:
            s1[i] != s2[j]

        We have two choices:
        - Skip s1[i]
        - Skip s2[j]

        We take the better of the two:

            dp[i][j] = max(dp[i+1][j], dp[i][j+1])

    ---------------------------------------------------

    Order of Computation:
    ---------------------
    We fill the DP table bottom-up, starting from the end
    of both strings and moving backward.

    ---------------------------------------------------

    Final Answer:
    -------------
    dp[0][0] gives the maximum ASCII sum of a common subsequence
    that can be kept in both strings.

    Using the formula derived earlier:

        minimum delete sum
        = cost1 + cost2 - 2 * dp[0][0]

    ---------------------------------------------------

    Complexity Analysis:
    --------------------
    Time Complexity:
        O(n * m), where
        n = length of s1
        m = length of s2

    Space Complexity:
        O(n * m) for the DP table

    This solution is optimal and efficient.
*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        char[] a = s1.toCharArray() ;
        int n = a.length ;
        int cost1 = 0 ;
        for(char c : a) cost1 += c ;

        char[] b = s2.toCharArray() ;
        int m = b.length ;
        int cost2 = 0 ;
        for(char c : b) cost2 += c ;

        int[][] dp = new int[n+1][m+1] ;

        for(int i = n - 1 ; i >= 0 ; i --)
        {
            for(int j = m - 1 ; j >= 0 ; j --)
            {
                if(a[i] == b[j])
                {
                    dp[i][j] = a[i] + dp[i+1][j+1] ;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]) ;
                }
            }
        }

        return cost1 + cost2 - 2 * dp[0][0] ;
    }

}