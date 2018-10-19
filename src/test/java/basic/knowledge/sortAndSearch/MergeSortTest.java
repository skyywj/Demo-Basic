package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/15 16:42:10
 * DESC:归并排序
 * 时间复杂度:O（nlogn）
 */
public class MergeSortTest {
    /**
     * 对两有序表进行合并 排序
     *
     * @param s 第一个有序表的起始位置
     * @param m 第二个有序表的起始位置
     * @param t 第二个有序表的结束位置
     */
    private static void merge(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        //将排好序的队列加入已有队列
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    public static void mergeSort(int[] a, int s, int len) {
        int size = a.length;
        //len << 1 等价于 len * 2
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        //　归并到只剩一个有序集合的时候结束算法
        if (mid == 0)
            return;
        //　进行一趟归并排序
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge(a, s, s + len, (len << 1) + s - 1);
        }
        //　将剩下的数和倒数一个有序集合归并
        if (c != 0)
            merge(a, size - c - 2 * len, size - c, size - 1);
        //  递归执行下一趟归并排序，1 2 4 8 16...进行归并，直到mid = 0
        mergeSort(a, 0, 2 * len);
    }

    public static void main(String[] args) {
        int[] a = new int[] {4, 3, 6, 1, 2, 5};
        mergeSort(a, 0, 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }
}
