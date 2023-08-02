//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // Check if the starting cell (0, 0) is reachable
        if (A[0][0] == 0) {
            return -1;
        }

        // Create a boolean array to track visited cells
        boolean[][] visited = new boolean[N][M];
        
        // Create a queue to perform BFS, store {x, y, steps}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // Enqueue starting cell
        
        // Define possible movements: down, up, right, left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // BFS loop
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // Dequeue a cell
            int x = cell[0]; // Current x-coordinate
            int y = cell[1]; // Current y-coordinate
            int steps = cell[2]; // Steps taken to reach this cell

            // Check if the current cell is the destination (X, Y)
            if (x == X && y == Y) {
                return steps; // Return the steps taken
            }

            // Explore neighboring cells
            for (int[] dir : directions) {
                int newX = x + dir[0]; // New x-coordinate after movement
                int newY = y + dir[1]; // New y-coordinate after movement
                
                // Check if the new cell is within bounds, contains 1, and is unvisited
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && A[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1}); // Enqueue the new cell
                    visited[newX][newY] = true; // Mark the new cell as visited
                }
            }
        }
        
        // Destination is not reachable
        return -1;
    }
}