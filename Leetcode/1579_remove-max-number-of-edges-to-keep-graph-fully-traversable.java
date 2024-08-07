/*
Alice and Bob have an undirected graph of n nodes and three types of edges:

    Type 1: Can be traversed by Alice only.
    Type 2: Can be traversed by Bob only.
    Type 3: Can be traversed by both Alice and Bob.

Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.

Constraints:

    1 <= n <= 105
    1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)
    edges[i].length == 3
    1 <= typei <= 3
    1 <= ui < vi <= n
    All tuples (typei, ui, vi) are distinct.

*/

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset != yset) {
            if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[xset] = yset;
                rank[yset]++;
            }
            return true;
        }
        return false;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        
        DSU dsu_alice = new DSU(n+1);
        DSU dsu_bob = new DSU(n+1);
        
        int removed_edge = 0, alice_edges = 0, bob_edges = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (dsu_alice.union(edge[1], edge[2])) {
                    dsu_bob.union(edge[1], edge[2]);
                    alice_edges++;
                    bob_edges++;
                } else {
                    removed_edge++;
                }
            } else if (edge[0] == 2) {
                if (dsu_bob.union(edge[1], edge[2])) {
                    bob_edges++;
                } else {
                    removed_edge++;
                }
            } else {
                if (dsu_alice.union(edge[1], edge[2])) {
                    alice_edges++;
                } else {
                    removed_edge++;
                }
            }
        }
        
        return (bob_edges == n - 1 && alice_edges == n - 1) ? removed_edge : -1;
    }
}
