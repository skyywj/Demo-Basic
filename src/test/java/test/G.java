package test;

/**
 * @author CarryJey
 * @since 2018/12/13
 */
public class G {
    /**
     * G题主代码
     */
    double kstest(double[] ss, int[] ys) {
        if (ss.length == 0 || ys.length == 0) {
            return 0;
        }
        //先对ss进行排序，采用快排，时间复杂度为O(nlogN)
        qsort(ss, ys, 0, ss.length - 1);
        int num_0 = 0;
        //统计全部负值
        for (int i = 0; i < ys.length; i++) {
            if (ys[i] == 0) {
                num_0++;
            }
        }
        int res = Integer.MIN_VALUE;
        int num_i0 = 0;
        //计算所有比例并选取最大差值
        for (int i = 0; i < ss.length; i++) {
            if (ys[i] == 0) {
                num_i0++;
            }
            int dis = (num_i0 / num_0) - (i - num_i0 + 1) / (ss.length - num_0);
            if (dis > res) {
                res = dis;
            }
        }
        return res;
    }
    //快排
    private static void qsort(double[] arr, int[] ys, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, ys, low, high); //将数组分为两部分
            qsort(arr, ys, low, pivot - 1); //递归排序左子数组
            qsort(arr, ys, pivot + 1, high); //递归排序右子数组
        }
    }

    //排序
    private static int partition(double[] arr, int[] ys, int low, int high) {
        double pivot = arr[low]; //枢轴记录
        int yy = ys[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high]; //交换比枢轴小的记录到左端
            ys[low] = ys[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low]; //交换比枢轴小的记录到右端
            ys[high] = ys[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        ys[low] = yy;
        //返回的是枢轴的位置
        return low;
    }

    //测试快排
    public static void main(String... args) {
        double a[] = {0.5, 1.2, 5.3, 2, 9, 3, 5};
        int b[] = {0, 1, 0, 1, 0, 1, 1};
        qsort(a, b, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " : " + b[i] + "\n");
        }
    }
}
