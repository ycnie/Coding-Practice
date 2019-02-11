class BrickWall554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.get(0) == null) {
            return 0;
        }
        Map<Integer, Integer> optCut = new HashMap<>();
        Set<Integer> curCutable = new HashSet<>();
        for (int row = 0; row < wall.size(); row++) {
            getCutable(wall.get(row), curCutable);
            for (Integer i : curCutable) {
                optCut.put(i, optCut.getOrDefault(i, 0) + 1);
            }
        }
        int maxNotCut = 0;
        for (Map.Entry<Integer, Integer> e : optCut.entrySet()) {
            maxNotCut = Math.max(e.getValue(), maxNotCut);
        }
        return wall.size() - maxNotCut;
        
    }
    
    private void getCutable(List<Integer> ls, Set<Integer> curCutable) {
        curCutable.clear();
        int sum = 0;
        for (int i = 0; i < ls.size() - 1; i++) {
            sum += ls.get(i);
            curCutable.add(sum);
        }
    }
}

// A better way exists is that we do not need the HashSet to store all possible cutable Index.
// We just need to sum up bricks of the current row when iterating.