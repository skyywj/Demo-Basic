package test;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class A {
    /**
     * 不考虑输入非法字符
     */
    //合法值或非法值标志，true为非法
    public static boolean inValid = false;
    public static int binary_to_integer(String binary) {
        if(binary.length()==0 || binary.length() == 1){
            inValid = true;
            return 0;
        }
        int res = 0;
        char[] binaryArray = binary.toCharArray();
        for (int i = 1; i < binaryArray.length; i++) {
            res = res + binaryArray[i] - '0';
            if (i != binaryArray.length - 1) {
                res = res << 1;
            }
        }
        return binaryArray[0] == '0' ? res : -1 * res;
    }

    public static void main(String... args) {
        int res = binary_to_integer("");
        System.out.print(res);
    }
}
