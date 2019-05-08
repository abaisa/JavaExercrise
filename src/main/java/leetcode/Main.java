package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abaisa on 2019/4/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] coins = new int[n+1];
        for(int i = 1; i <= n; i++) {
            coins[i] = in.nextInt();
        }

        Arrays.sort(coins);
        if(coins[1] != 1) {
            System.out.println(-1);
            return;
        }

        int sum = 1;
        int i = 1;
        int result = 0;
        while(sum < m) {
            for(; i <= n; i++) {
                if(coins[i] > sum+1) {
                    break;
                }
            }
            sum += coins[i-1];
            result++;
        }

        System.out.println(result+1);
    }
}
