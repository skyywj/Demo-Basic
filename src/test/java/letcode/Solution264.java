package letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CarryJey
 * @since 2018/12/13
 */
public class Solution264 {
    /**
     * 丑数：只包含质因数2，3，5的正整数 找出第n个丑数
     */
    //判断是否是丑数
    public static boolean uglyNumber(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        min = min < c ? min : c;
        return min;
    }
    //找出第n个丑数
    public static int nthUglyNumber2(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 1, b = 1, c = 1;
        int aa = 0, bb = 0, cc = 0;
        int num = 0;
        while (num < n) {
            list.add(min(a, b, c));
            ++num;
            while (list.get(aa) * 2 <= list.get(list.size() - 1)) {
                aa++;
            }
            a = list.get(aa) * 2;
            while (list.get(bb) * 3 <= list.get(list.size() - 1)) {
                bb++;
            }
            b = list.get(bb) * 3;
            while (list.get(cc) * 5 <= list.get(list.size() - 1)) {
                cc++;
            }
            c = list.get(cc) * 5;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String... args) {
        System.out.print(nthUglyNumber2(10));
    }
}
