package sort;


public class Sort2 {
    public static void main(String[] args) {
        int[] str = new int[50000];
        for (int i = 0; i < str.length; i++) {
            // Math.random() 表示随机数 [0,1)之间
            str[i] = (int) (Math.random() * 1000);
        }
//        System.out.println(Arrays.toString(str));
        long start = System.currentTimeMillis();
        shellSort(str);
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start) + "ms");
//        System.out.println(Arrays.toString(str));

    }

    private static void shellSort(int[] str) {
        int gap = str.length / 2;
        while (gap > 0) {
            for (int i = 0; i < str.length; i++) {
                for (int j = i; j >= gap && str[j] < str[j - gap]; j -= gap) {
                    int tmp = str[j];
                    str[j] = str[j - gap];
                    str[j - gap] = tmp;
                }
            }
            gap /= 2;
        }
    }

}
