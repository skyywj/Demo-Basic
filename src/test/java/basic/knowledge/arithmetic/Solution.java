package basic.knowledge.arithmetic;

/**
 * @author CarryJey
 * @since 2018/11/7
 */
public class Solution {

    /**
     * 二分查找目标值
     *
     * @param nums 数组
     * @param target 目标值
     * @return
     */
    public static int binaryFind(int[] nums, int target, int l, int r) {
        int mid;
        while (l < r) {
            mid = (l + r + 1) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = (l + r + 1) / 2;
            } else {
                l = (l + r + 1) / 2;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int n) {
        //有转折点
        int l_end = n - 1;
        int r_start = n;
        //无转折点
        if (n == nums.length - 1) {
            l_end = 0;
            if (target >= nums[0] && target <= nums[n]) {
                return binaryFind(nums, target, 0, n);
            } else {
                return -1;
            }
        }
        //有转折点
        if (target >= nums[0] && target <= nums[l_end]) {
            return binaryFind(nums, target, 0, l_end);
        } else if (target >= nums[r_start] && target <= nums[nums.length - 1]) {
            return binaryFind(nums, target, r_start, nums.length - 1);
        }else {
            return -1;
        }
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int l = 0;
        int r = len - 1;
        //如果顺序正确
        if (nums[l] < nums[r]) {
            return binarySearch(nums, target, r);
        } else if (nums[l] == nums[r]) {
            return target == nums[l] ? 0 : -1;
        } else {
            //先二分找转折点
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[l] > nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            l = l - 1;
            //再去二分寻找目标值
            return binarySearch(nums, target, l);
        }
    }

    public static void main(String... args) {
        int a[] = {1, 3};
        int res = search(a, 1);
        System.out.print(res + "\n");
    }
}
