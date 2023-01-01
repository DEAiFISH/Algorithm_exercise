import java.math.BigInteger;
import java.util.Scanner;

/**
 * 视屏：https://www.bilibili.com/video/BV1GA411Q79k/
 */
public class 斐波那契数列的矩阵快速幂求法 {
    static BigInteger p2;//其实就是p,请不要误解。
    static boolean f;//标记能否在矩阵乘法中队p求余。
    static BigInteger fm2;//求S(n)时加速用的，当然也可以不用，在n远小于m时使用会更加慢

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger n = scan.nextBigInteger();
        BigInteger m = scan.nextBigInteger();
        p2 = scan.nextBigInteger();
        n = n.add(BigInteger.valueOf(2));
        BigInteger sum;
        if (n.compareTo(m) <= 0) {//情况1：n + 2<= m，答案=(f(n+2)-1)%p，此时在算f(n)时可以随时对p求余。

            f = true;
            sum = fib(n).subtract(BigInteger.ONE);

            System.out.println(sum.mod(p2));

        } else {//情况2:n + 2 > m，答案=(f(n+2)-1)%f(m)%p，中间隔有f(m)，此时在算f(n)时不能够对p求余。

            f = false;
            BigInteger fm = fib(m);
            fm2 = fm;
            sum = fib(n).subtract(BigInteger.ONE);
            System.out.println(sum.mod(fm).mod(p2));
        }
    }

    /**
     * 快速幂法求斐波那契数列第n项。
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
            return BigInteger.valueOf(1);
        }
        BigInteger[][] arr1 = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}};
        BigInteger[][] arr2 = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] ans = multiply(arr1, pow2(arr2, n.subtract(BigInteger.TWO)));
        return ans[0][0];
    }

    /**
     * 求矩阵t的p次幂
     *
     * @param t 矩阵
     * @param p p次幂
     * @return 矩阵
     */
    public static BigInteger[][] pow2(BigInteger[][] t, BigInteger p) {
        BigInteger[][] res = new BigInteger[t.length][t.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = i == j ? BigInteger.ONE : BigInteger.ZERO;
            }
        }
        for (; !p.equals(BigInteger.ZERO); p = p.divide(BigInteger.valueOf(2))) {
            if (p.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                res = multiply(res, t);
            }
            t = multiply(t, t);
        }
        return res;
    }

    /**
     * 矩阵乘法
     *
     * @param target  乘数
     * @param target2 被乘数
     * @return 矩阵
     */
    public static BigInteger[][] multiply(BigInteger[][] target, BigInteger[][] target2) {
        BigInteger[][] res = new BigInteger[target.length][target2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = BigInteger.ZERO;
            }
        }
        int r1 = 0, c1;
        int c2;//r2是等于c1的
        for (; r1 < res.length; r1++) {
            for (c2 = 0; c2 < target2[0].length; c2++) {
                for (c1 = 0; c1 < target[0].length; c1++) {
                    if (f) {
                        res[r1][c2] = res[r1][c2].add(target[r1][c1].multiply(target2[c1][c2]).mod(p2)).mod(p2);
                    } else {
                        if (fm2 != null) {
                            res[r1][c2] = res[r1][c2].add(target[r1][c1].multiply(target2[c1][c2]).mod(fm2).mod(fm2));
                        } else {
                            res[r1][c2] = res[r1][c2].add(target[r1][c1].multiply(target2[c1][c2]));
                        }
                    }
                }

            }
        }
        return res;
    }
}
