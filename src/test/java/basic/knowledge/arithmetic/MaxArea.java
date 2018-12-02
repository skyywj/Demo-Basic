package basic.knowledge.arithmetic;

/**
 * @author CarryJey
 * @since 2018/11/2
 * desc: 计算哪个容器可以盛最多水
 * code地址:   https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int l = i;
        int r = j;
        while (i < j) {
            int h = height[i] > height[j] ? height[j] : height[i];
            max = h * (j - i) > max ? h * (j - i) : max;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String... args) {
        int a[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxArea(a);
        System.out.print(res);
    }
}
