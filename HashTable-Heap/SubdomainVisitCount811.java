class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            countDomains(cpdomains[i], map);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(e.getValue()));
            sb.append(" ");
            sb.append(e.getKey());
            res.add(sb.toString());
        }
        return res;
    }
    
    private void countDomains(String s, Map<String, Integer> map) {
        int count = 0;
        int index = 0;
        while (Character.isDigit(s.charAt(index))) {
            count = count * 10 + (s.charAt(index++) - '0');
        }
        index++; // skip the white space
        String curSubString = s.substring(index, s.length());
        map.put(curSubString, map.getOrDefault(curSubString, 0) + count);
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '.') {
                String substring = s.substring(index + 1, s.length());
                map.put(substring, map.getOrDefault(substring, 0) + count);
            }
            index++;
        }
    }
}