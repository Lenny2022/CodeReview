package sort;

import java.util.Arrays;

/**
 * 随机数组
 * @author lenny
 */
public class RandomArr {
    public static void main(String[] args) {
        int[] str = new int[100];
        for (int i = 0; i < str.length; i++) {
            // Math.random() 表示随机数 [0,1)之间
            str[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(str));
    }
}
