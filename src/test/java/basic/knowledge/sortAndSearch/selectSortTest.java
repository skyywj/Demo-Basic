package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/19 17:12:45
 * desc: 选择排序：每次选择最小的放入链表 时间复杂度O(n2)
 */
public class selectSortTest {
    private static void selectSort(int[] a) {
        int key=-1,value,temp;
        for(int i = 0;i<a.length;i++){
            value = a[i];
            for(int j = i + 1;j<a.length;j++){
                //选择剩余的数字中最小的值
                if(a[j] < value){
                    value = a[j];
                    key = j;
                }
            }
            if(key != -1){
                //交换两个位置的数字
                a[key] = a[i];
                a[i] = value;
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {0, 9, 5, 7, 2, 6, 1, 3};
        selectSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
