package leetcode;

/**
 * Created by abaisa on 2019/3/29.
 */
public class P32 {
    private  String a33 = "";
    public int longestValidParentheses(String s) {
        a33 = "123";
        if (s.length() < 2) return 0;
        // DP是个好思路
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == '(') dp[i] = 0;
            else {
                if (i - 1 > 0 && dp[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
                if (dp[i] > res)
                    res = dp[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        P32 p = new P32();
//        System.out.println(p.longestValidParentheses("(()"));
        int a[] = {1, 2, 3};
        int b[] = {1, 2, 3};
        a[1] = b[1] = 10;
        System.out.println(a[1] + b[1]);
    }
}