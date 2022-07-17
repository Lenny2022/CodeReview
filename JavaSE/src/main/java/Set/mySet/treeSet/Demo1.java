package Set.mySet.treeSet;

import java.util.TreeSet;

/**
 * @author: lenny
 * @Date: 2022/6/20 12:26
 * @Description:
 *      set 集合:
 *      + 不可以存储重复元素
 *      + 没有索引,不能使用普通for循环遍历
 */
public class Demo1 {
    public static void main(String[] args) {
        // treeSet: 有序,唯一,   底层红黑树结构
        // 自然排序 comparable,     比较器排序 Comparator
        TreeSet<String> set = new TreeSet<>();

        set.add(String.valueOf(11));
        set.add(String.valueOf(8));
        set.add(String.valueOf(9));
        set.add(String.valueOf(4));
        set.add(String.valueOf(6));
        // set 唯一
        set.add(String.valueOf(9));

        //有序
        System.out.println(set);

        for (String s : set) {
            System.out.println(s);
        }
    }
}
