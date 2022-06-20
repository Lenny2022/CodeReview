package com.google;

/**
 * 冒泡排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] str = new int[50000];
        for (int i = 0; i < str.length; i++) {
            // Math.random() 表示随机数 [0,1)之间
            str[i] = (int) (Math.random() * 1000);
        }
//        System.out.println(Arrays.toString(str));
        long start = System.currentTimeMillis();
        mpSort(str);
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start) + "ms");
//        System.out.println(Arrays.toString(str));

    }

    private static void mpSort(int[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            // 内循环得到一个最大值， 比较到str[length-2]  ( -->  str[j]) && str[length -1]号元素停止
            // 第二次循环少一个数，得到 (length-1个最大值即可， 即比较 length-1 次即可)
            for (int j = 0; j < str.length - i - 1; j++) {
                if (str[j] > str[j + 1]) {
                    int tmp;
                    tmp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = tmp;
                }
            }
        }
    }
}
