package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/15 16:42:10
 * DESC:归并排序
 * 时间复杂度:O（nlogn）
 */
public class MergeSortTest {

    public static void merge(int a[], int l, int r) {
        if (a == null) return;
        if (l < r) {
            int mid = (l + r) / 2;
            //左边进行递归排序
            merge(a, l, mid);
            //右边进行递归排序
            merge(a, mid + 1, r);
            //对排好序的分区进行合并
            mergeArray(a, l, mid, r);
        }
    }

    private static void mergeArray(int[] a, int l, int mid, int r) {
        if (a == null) return;
        int i = l;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }
        //将合并好的temp并入原来的数组
        System.arraycopy(temp, 0, a, l, temp.length);
    }

    public static void main(String... args) {
        int[] a = new int[] {4, 3, 6, 1, 2, 5};
        merge(a, 0, a.length - 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }
}
