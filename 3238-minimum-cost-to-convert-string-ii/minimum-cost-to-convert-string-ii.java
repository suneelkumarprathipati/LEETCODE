class Solution {
    // Standard Trie Node
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int id = -1; // Unique ID for this string (-1 if not a complete word)
    }

    private int uniqueIDCounter = 0;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        // 1. Build Trie and Map Strings to Integer IDs
        TrieNode root = new TrieNode();
        for (String s : original) insert(root, s);
        for (String s : changed) insert(root, s);

        // 2. Initialize Distance Matrix (Graph)
        int numNodes = uniqueIDCounter;
        long[][] dist = new long[numNodes][numNodes];
        for (int i = 0; i < numNodes; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Fill initial costs
        for (int i = 0; i < cost.length; i++) {
            int u = getID(root, original[i]);
            int v = getID(root, changed[i]);
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        // 3. Floyd-Warshall (All-Pairs Shortest Path)
        for (int k = 0; k < numNodes; k++) {
            for (int i = 0; i < numNodes; i++) {
                if (dist[i][k] == Long.MAX_VALUE) continue;
                for (int j = 0; j < numNodes; j++) {
                    if (dist[k][j] == Long.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 4. Dynamic Programming
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE) continue;

            // Option A: Character Match (Free)
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // Option B: Trie Search for Substring Replacement
            TrieNode p1 = root; // Pointer for source
            TrieNode p2 = root; // Pointer for target
            
            // Try matching substrings starting at 'i' of various lengths
            for (int j = i; j < n; j++) {
                int charS = source.charAt(j) - 'a';
                int charT = target.charAt(j) - 'a';

                p1 = p1.next[charS];
                p2 = p2.next[charT];

                // If either path falls off the Trie, we can't match further
                if (p1 == null || p2 == null) break;

                // If both pointers point to valid word IDs, check cost
                if (p1.id != -1 && p2.id != -1) {
                    if (dist[p1.id][p2.id] != Long.MAX_VALUE) {
                        dp[j + 1] = Math.min(dp[j + 1], dp[i] + dist[p1.id][p2.id]);
                    }
                }
            }
        }

        return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
    }

    private void insert(TrieNode root, String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        if (node.id == -1) {
            node.id = uniqueIDCounter++;
        }
    }

    private int getID(TrieNode root, String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.next[c - 'a'];
        }
        return node.id;
    }
}