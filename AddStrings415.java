class AddStrings415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; 
            i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int one = i < 0 ? 0 : num1.charAt(i) - '0';
            int two = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((one + two + carry) % 10);
            carry = (one + two + carry) / 10;
        }
        return sb.reverse().toString();
    }
}