class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String strKey = new String(array);
            List<String> curList = map.getOrDefault(strKey, new ArrayList<>());
            curList.add(s);
            map.put(strKey, curList);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
}