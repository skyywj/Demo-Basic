package basic.knowledge.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CarryJey @Date: 2018/10/24 21:03:53
 * desc:大数相乘 & 大数相加
 */
public class MaxNumAddAndMultiply {
    /**
     * 乘可以拆分为两步：先单个乘然后每次多增一个0，在挨个相加。
     */
    public static String multiply(String num1, String num2) {
        if (num1.length() == 1 && Integer.valueOf(num1) == 0) {
            return "0";
        }
        if (num2.length() == 1 && Integer.valueOf(num2) == 0) {
            return "0";
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int t = 0;
        int i = 0;
        String res = "";
        List<String> listResult = new ArrayList<>();
        int len = num1.length() > num2.length() ? num1.length() : num2.length();
        while (i < num2.length()) {
            int y = num2.charAt(i) - '0';
            String midResult = "";
            /**
             * 加0操作
             */
            for (int k = 0; k < i; k++) {
                midResult += String.valueOf(0);
            }
            for (int j = 0; j < num1.length(); j++) {
                int x = num1.charAt(j) - '0';
                int temp = x * y + t;
                midResult += temp % 10;
                t = temp / 10;
                if (j + 1 == num1.length() && t > 0) {
                    midResult += t;
                    t = 0;
                }
            }
            listResult.add(new StringBuilder(midResult).reverse().toString());
            i++;
        }

        /**
         * 相加操作
         */
        for (int k = 0; k < listResult.size(); k++) {
            res = add(res, listResult.get(k));
        }
        return res;
    }

    /**
     * 大数相加
     */
    public static String add(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int t = 0;
        int i = 0;
        String res = "";
        while (i < num1.length() && i < num2.length()) {
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(i) - '0';
            int sum = x + y + t;
            res += String.valueOf(sum % 10);
            t = sum / 10;
            i++;
        }

        while (i < num1.length()) {
            if (t > 0) {
                Integer r = num1.charAt(i) - '0' + t;
                t = r / 10;
                res += String.valueOf(r % 10);
            } else {
                res += num1.charAt(i) - '0';
            }
            i++;
        }

        while (i < num2.length()) {
            if (t > 0) {
                Integer r = num2.charAt(i) - '0' + t;
                t = r / 10;
                res += String.valueOf(r % 10);
            }else {
                res+=num2.charAt(i)-'0';
            }
            i++;
        }
        if (t > 0) {
            res += String.valueOf(t);
        }
        return new StringBuilder(res).reverse().toString();
    }

    public static void main(String... args) {
        String res = multiply("123456789", "98765456451");
        System.out.print(res);
    }
}
