class AllPathFromSourceToTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        findAllPath(graph, 0, temp, res);
        return res;
    }
    
    private void findAllPath(int[][] graph, int curNode, 
                             List<Integer> temp, List<List<Integer>> res) {
        if (curNode == graph.length - 1) {
            temp.add(curNode);
            res.add(new ArrayList(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(curNode);
        for (int i = 0; i < graph[curNode].length; i++) {
            findAllPath(graph, graph[curNode][i], temp, res);
        }
        temp.remove(temp.size() - 1);
    }
}