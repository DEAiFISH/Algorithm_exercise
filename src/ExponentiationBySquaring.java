/**
 * @description TODO
 *
 * @className ExponentiationBySquaring
 * @author DEAiFISH
 * @date 2023/9/8 12:04
 */
public class ExponentiationBySquaring {
    //递归快速幂（对大素数取模）
    private final int MOD = 1000000007;

    /**
     * @description 递归 快速幂
     *
     * @author DEAiFISH
     * @date 2023/9/8 12:05
     * @return int
     */
    public int reQuickPow(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 1) {
            return reQuickPow(a, n - 1) * a % MOD;
        } else {
            int temp = reQuickPow(a, n / 2) % MOD;
            return reQuickPow(temp, temp) % MOD;
        }
    }

    /**
     * @description 非递归 快速幂
     *
     * @author DEAiFISH
     * @date 2023/9/8 12:11
     * @return int
     */
    public int quickPow(int a, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= a;
            }
            a *= a;
            n >>= 1;
        }
        return res;
    }
}
