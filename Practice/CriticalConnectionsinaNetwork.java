/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.


!!!!!!!!!!!!!!!!!!!!IN AMAZON QUESTION PRINT JUST 1st Value and not the link !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

*/
class CriticalConnectionsinaNetwork {
   public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	List<Integer>[] graph = new ArrayList[n];
	for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
	for (int i = 0; i < connections.size(); i++) {
		List<Integer> edge = connections.get(i);
		graph[edge.get(0)].add(edge.get(1));
		graph[edge.get(1)].add(edge.get(0));
	}
	boolean[] visited = new boolean[n];
	int[] order = new int[n];
	List<List<Integer>> results = new ArrayList<>();
	int[] uuid = new int[1]; // a global unique counter that assigns traversal order to each node
	dfs(graph, -1, 0, visited, order, uuid, results);
	return results;
}

public void dfs(List<Integer>[] graph, int pre, int src, boolean[] visited, int[] order, int[] uuid, List<List<Integer>> results) {
	visited[src] = true;
	order[src] = uuid[0]++;
	int orig_order = order[src];
	for (Integer neighbour : graph[src]) {
		if (neighbour == pre) continue; // pre: guarantee no backward traversal
		if (!visited[neighbour]) dfs(graph, src, neighbour, visited, order, uuid, results);
		// order[src] keeps the earliest point that src can reach without passing src->pre
		order[src] = Math.min(order[src], order[neighbour]); // used by its predecessor to tell if pre->src is critical.
		if (orig_order < order[neighbour]) results.add(Arrays.asList(src, neighbour));
	}
}
}