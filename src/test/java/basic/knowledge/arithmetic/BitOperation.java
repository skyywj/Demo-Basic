package basic.knowledge.arithmetic;

/**
 * 位运算相关算法
 * @author CarryJey
 * @since 2018/11/10
 */
public class BitOperation {
    /**
     * 所有数都有两个相同的值，只有一个数只有一个
     * 找出这个一个数
     * 解：使用异或（相同的数会两两相消）
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

    /**
     * 判断是否是2的幂数
     * 解：使用与运算，与完等于0即是
     * 1：1； 2：10； 4：100； 8：1000；16：10000
     */
    public static boolean dubleNumber(int num) {
        return num > 0 && (num & (num - 1)) == 0 ? true : false;
    }

    /**
     * 判断是否是4的幂数(其他的也可以这么搞)
     * num&(num-1) 判断一个数是否为2的幂数
     * 4的幂级数为1,4,16，即0001，0100,10000，也就是1出现在1,3,5,7。。。。位置上
     * 重点是：0x55555555在32位系统里表示0b01010101010101010101010101010101
     */
    public static boolean fourNumber(int num){
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0 ? true : false;
    }

    /**
     * 找众数：个数超过n/2的数
     */
    public static int majorityElement(int[] nums) {
        int num = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                num++;
            } else {
                num--;
                if (num <= 0) {
                    target = nums[i];
                    num = 0;
                }
            }
        }
        return target;
    }

    public static void main(String... args) {
        int a[] = {4, 1, 2,2, 2, 1, 1};
        System.out.print(0x55);
    }
}
