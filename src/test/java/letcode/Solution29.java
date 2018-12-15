package letcode;

/**
 * @author CarryJey
 * @since 2018/12/12
 */
public class Solution29 {
    /**
     * 模拟除法运算，不用/，两个标志位，被除数*2，直到找到，cnt记录有多少个被除数。递归两遍基本就可以求完了。
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }
        int res = 0;
        while (divisor <= dividend) {
            int tmp = divisor;
            int cnt = 1;
            while (tmp <= dividend) {
                tmp <<= 1;
                cnt <<= 1;
            }
            dividend -= (tmp >> 1);
            res += cnt >> 1;
        }
        return flag ? res : -res;
    }

    public static void main(String... args) {
        int a = -10;
        System.out.print(divide(-2147483647, -1) + "\n");
        System.out.print(Integer.MIN_VALUE);
    }
}
