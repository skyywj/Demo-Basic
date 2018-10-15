package basic.knowledge;

/**
 * @Author: CarryJey @Date: 2018/10/15 16:01:42
 * DESC:位运算符  >> << >>>
 */
public class ShiftOperatorTest {

    public static void main(String args []){
        /**
         * <<      :     左移运算符，num << 1,相当于num乘以2
         * >>      :     右移运算符，num >> 1,相当于num除以2
         * >>>    :     无符号右移，忽略符号位，空位都以0补齐
         */
        int num = 3;
        //输出二进制码
        System.out.println("num的二进制码为：" + Integer.toBinaryString(num));

        //左移一位
        System.out.println(num << 1);
        //右移一位
        System.out.println(num >> 1);
        num = -10;
        //无符号右移一位
        System.out.println(num >>>1);
    }
}
