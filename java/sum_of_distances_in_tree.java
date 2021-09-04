class Solution {
    int[] ans, count;
    
    List <Set<Integer>> graph;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<Set<Integer>>();
        
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
            
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1);
        return ans;
    }

    
    public void postOrder(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                postOrder(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    public void preOrder(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + count.length - count[child];
                preOrder(child, node);
            }
    }
}