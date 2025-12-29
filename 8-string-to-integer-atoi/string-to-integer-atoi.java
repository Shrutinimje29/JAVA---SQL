class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index >= n) {
            return 0;
        }
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (sign == 1){
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && digit > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + digit;
            index++;
        }
        return result * sign;
    }
}