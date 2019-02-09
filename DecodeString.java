class DecodeString394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a' ||
                s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                sb.append(s.charAt(i++));
                continue;
            }
            int count = 0;
            while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                count = count * 10 + (s.charAt(i++) - '0');
            }
            int start = ++i;
            int leftBrackets = 1;
            int rightBrackets = 0;
            while (i < s.length() && leftBrackets != rightBrackets) {
                if (s.charAt(i) == '[') {
                    leftBrackets++;
                } else if (s.charAt(i) == ']') {
                    rightBrackets++;
                }
                i++;
            }
            String subString = decodeString(s.substring(start, i - 1));
            while (count > 0) {
                sb.append(subString);
                count--;
            }
        }
        return sb.toString();
    }
}