package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/14 17:44:29
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 算法：快排 && 二分查找
 */
public class QuickSortAndBinaryTest {

    /**
     * 二分查找 时间复杂度O(log2n)
     */
    public static int find(List<Integer> list, int left, int right, int target) {
        int mid = (right - left + 1) / 2;
        if (list.get(mid) == target) {
            System.out.println("find target at: " + mid);
            return mid;
        } else if (target < list.get(mid)) {
            right = mid + 1;
            return find(list, left, right, target);
        } else {
            left = mid - 1;
            return find(list, left, right, target);
        }
    }

    /**
     * 快排 O(logn)
     */
    public static List<Integer> quickSort(List<Integer> list, Integer left, Integer right) {
        if (left >= right) {
            return list;
        }
        Integer l = left;
        Integer r = right;
        Integer key = list.get(left);
        while (left < right) {
            while (left < right && list.get(right) >= key) {
                right--;
            }
            list.set(left, list.get(right));
            while (left < right && list.get(left) <= key) {
                left++;
            }
            list.set(right, list.get(left));
        }
        list.set(left, key);
        list = quickSort(list, l, left - 1);
        list = quickSort(list, left + 1, r);
        return list;
    }

    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(11);
        list.add(5);
        list.add(33);
        list.add(7);
        list.add(0);
        list.add(9);

        int target = 3;
        //快排先将队列排序一下
        List<Integer> list1 = quickSort(list, 0, list.size() - 1);
        //打印排序后的序列
        int len = list.size() - 1;
        while (len >= 0) {
            System.out.println(list1.get(len));
            len--;
        }
        //再去二分查找
        find(list1, 0, list.size(), target);
    }
}
