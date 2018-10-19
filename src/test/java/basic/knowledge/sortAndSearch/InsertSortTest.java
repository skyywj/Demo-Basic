package basic.knowledge.sortAndSearch;

/**
 * @Author: CarryJey @Date: 2018/10/16 14:31:28
 */

/**
 * 分类：直接插入排序，二分插入排序（又称折半插入排序），链表插入排序，希尔排序（又称缩小增量排序）。属于稳定排序的一种（通俗地讲，就是两个相等的数不会交换位置） 这里只写一个直接插入排序，其他的只是参照了其他的算法思想
 * 时间复杂度：O(n2)
 */
public class InsertSortTest {

    private int[] array;
    private int length;

    public InsertSortTest(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public void display(){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /**
     * 插入排序方法
     */
    public void doInsertSort(){
        for(int index = 1; index<length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftindex+1] = array[leftindex];
                leftindex--;
            }
            array[leftindex+1] = temp;//把temp放到空位上
        }
    }

    public static void main(String[] args){
        int[] array = {38,65,97,76,13,27,49};
        InsertSortTest is = new InsertSortTest(array);
        System.out.println("排序前的数据为：");
        is.display();
        is.doInsertSort();
        System.out.println("排序后的数据为：");
        is.display();
    }
}
