package basic.knowledge.arithmetic;

/**
 * @author CarryJey
 * @since 2018/12/4
 * desc: 幂运算原理实现
 */
public class PowTest {

    //如果invalid = true则表明程序出错，目的是为了区分0和无效值的问题
    static boolean invalid = false;

    /**
     * @param base 底数
     * @param exponent 幂
     */
    public static double pow(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            invalid = true;
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int signal = 1;
        if (exponent < 0) {
            signal = 0;
            exponent *= -1;
        }
        double result = powWithUnsignedExponent(base, exponent);
        if (signal == 0) {
            return 1 / result;
        }
        return result;
    }

    private static boolean equal(double num1, double num2) {
        if ((num1 - num2) < 0.00000001 && (num1 - num2) > -0.00000001) {
            return true;
        }
        return false;
    }

    /**
     * 利用了跌方的方式计算，即2的8次方分为2*2 = 4 4*4 = 16 16*16 = 256这样来计算
     */
    private static double powWithUnsignedExponent(double base, int exponent) {
        if (exponent == 1) return base;
        double res = powWithUnsignedExponent(base, exponent >> 1);
        res *= res;
        //        与运算判断幂是否是奇数
        if ((exponent & 0x1) == 1) res *= base;

        return res;
    }

    public static void main(String... args) {
        double res = pow(-2, 3);
        System.out.print(res);
    }
}
