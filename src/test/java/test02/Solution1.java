package test02;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author CarryJey
 * @since 2018/12/23
 */
public class Solution1 {
    /**
     * 将二维矩阵顺时针旋转90度
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        /**
         * * 先根据对角线357转换
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][len - i - 1];
                matrix[len - j - 1][len - i - 1] = tmp;
            }
        }
        /**
         * 再根据水平中线456进行反转
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = tmp;
            }
        }
    }

    @Test
    public void test() {
        int[][] test1 =
            new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

        rotate(test1);
        Assert.assertArrayEquals(
            new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
            },
            test1);
    }
}
