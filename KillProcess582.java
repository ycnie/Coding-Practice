class KillProcess582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> toKill = new LinkedList<>();
        if (pid == null || ppid == null || pid.size() == 0 || ppid.size() == 0) {
            return toKill;
        }
        Map<Integer, List<Integer>> pToC = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> curChildren = pToC.get(ppid.get(i));
            if (curChildren == null) {
                curChildren = new LinkedList<>();
            }
            curChildren.add(pid.get(i));
            pToC.put(ppid.get(i), curChildren);
        }
        toKill.add(kill);
        killAllChildren(pToC, kill, toKill);
        return toKill;
    }
    
    private void killAllChildren(Map<Integer, List<Integer>> pToC, int kill, List<Integer> toKill) {
        List<Integer> curChildren = pToC.get(kill);
        if (curChildren == null) {
            return;
        }
        for (Integer i : curChildren) {
            toKill.add(i);
            killAllChildren(pToC, i, toKill);
        }
    }
}