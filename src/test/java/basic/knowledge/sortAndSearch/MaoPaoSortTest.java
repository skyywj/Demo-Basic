package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/19 17:08:15
 * desc: 冒泡排序
 * 时间复杂度O(n2)
 */
public class MaoPaoSortTest {

    private static void maopao(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {0, 9, 5, 7, 2, 6, 1, 3};
        maopao(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
