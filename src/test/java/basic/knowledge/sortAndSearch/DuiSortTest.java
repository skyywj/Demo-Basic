package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/19 17:38:01
 */

// 分类 -------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- O(nlogn)
// 最优时间复杂度 ---- O(nlogn)
// 平均时间复杂度 ---- O(nlogn)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 不稳定

/**
 * 堆的数据结构类似完全二叉树结构，堆排序其实就是利用堆（假设利用大顶堆（堆分为大顶堆，大根堆））。
 * 大顶堆的父节点一定要大于他的子节点
 * 步骤：
 * 1.由输入的无序数组构造一个最大堆，作为初始的无序区
 * 2.把堆顶元素（最大值）和堆尾元素互换
 * 3.把堆（无序区）的尺寸缩小1，并调用heapify(A, 0)从新的堆顶元素开始进行堆调整
 * 4.重复步骤2，直到堆的尺寸为1
 */
public class DuiSortTest {

    //交换值
    public static void Swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //堆调整
    public static void Heapify(int a[], int i, int heap_size) {
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        int max = i;
        if (left_child < heap_size && a[max] < a[left_child]) {
            max = left_child;
        }
        if (right_child < heap_size && a[max] < a[right_child]) {
            max = right_child;
        }
        if (max != i) {
            Swap(a,i,max);

            Heapify(a, max, heap_size);
        }
    }

    //构建最大堆
    public static int buildHeap(int a[]) {
        int heap_size = a.length;
        for (int i = heap_size / 2 - 1; i >= 0; i--) {
            //从每一个非叶子节点开始向下进行堆调整
            Heapify(a, i, heap_size);
        }
        return heap_size;
    }

    public static void HeapSort(int a[]) {
        //先构建最大堆
        int heap_size = buildHeap(a);
        while (heap_size > 1){
            // 将堆顶元素与堆的最后一个元素互换，并从堆中去掉最后一个元素
            // 此处交换操作很有可能把后面元素的稳定性打乱，所以堆排序是不稳定的排序算法
            Swap(a,0,--heap_size);
            // 从新的堆顶元素开始向下进行堆调整，时间复杂度O(logn)
            Heapify(a,0,heap_size);
        }

    }

    public static void main(String args[]) {

        int[] a = new int[] {4, 3, 7, 6, 1, 2, 5};
        HeapSort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "　");
        }
    }
}
