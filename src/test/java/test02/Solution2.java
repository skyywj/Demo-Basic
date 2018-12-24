package test02;

import org.junit.Test;

/**
 * @author CarryJey
 * @since 2018/12/23
 */
public class Solution2 {
    /**
     * 有一个正整数对(x,y)，但是忘记他们具体是多少了，x 和 y 均不大于 n, 并且 x 除以 y >= k 求有多少个这种正整数对
     */
    /**
     * 我们会发现x从k+1到n，对k取余会存在一个规律123 123 123，余数循环，到最后一个循环可能存在不完全的循环 所以外层i-k是指每个数对k取余会产生几个循环值，n/i是指有多少个i值符合这个循环
     * if里是对不完全循环的处理
     */
    public int solution(int n, int k) {
        if (k == 0) {
            return 0;
        }
        int res = 0;
        for (int i = k + 1; i <= n; i++) {
            res += (n / i) * (i - k);
            if (n % i >= k) {
                res += n % i - k + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.print(solution(5, 2));
    }
}
