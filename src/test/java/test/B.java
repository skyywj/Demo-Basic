package test;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class B {
    static int diff(int[] elems) {
        if (elems.length == 0) {
            return 0;
        }
        if (elems.length == 1) {
            return elems[0];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < elems.length; i++) {
            if (elems[i] > max) {
                max = elems[i];
            }
            if (elems[i] < min) {
                min = elems[i];
            }
        }
        return max - min;
    }

    public static void main(String... args) {
        int a[] = {1};
        int res = diff(a);
        System.out.print(res);
    }
}
