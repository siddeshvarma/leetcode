class Solution {
    public int longestValidParentheses(String s) {

        int ans = 0;

        // Left to Right
        int i = 0;
        int j = 0;
        int open = 0;
        int close = 0;

        while (j < s.length()) {

            if (s.charAt(j) == '(')
                open++;
            else
                close++;

            while (open < close) {

                if (s.charAt(i) == '(')
                    open--;
                else
                    close--;

                i++;
            }

            if (open == close)
                ans = Math.max(ans, j - i + 1);

            j++;
        }

        // Right to Left
        i = s.length() - 1;
        j = s.length() - 1;
        open = 0;
        close = 0;

        while (j >= 0) {

            if (s.charAt(j) == '(')
                open++;
            else
                close++;

            while (open > close) {

                if (s.charAt(i) == '(')
                    open--;
                else
                    close--;

                i--;
            }

            if (open == close)
                ans = Math.max(ans, i - j + 1);

            j--;
        }

        return ans;
    }
}