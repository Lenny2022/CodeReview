package Set.mySet.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 练习
 *
 * @author: lenny
 * @Date: 2022/6/20 19:24
 * @Description: 需求: 集合添加一些字符串, 要求按字符串长度进行排序,如果长度一致,则按字典顺序排序.
 */
public class Demo4 {
    public static void main(String[] args) {
        //1,比较器排序 ,自然排序
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //1. 长度排序(升序)
                int result = o1.length() - o2.length();

                // 2.字典顺序
                result = result == 0 ? o1.compareTo(o2) : result;

                return result;
            }
        });

        set.add("jsflf");
        set.add("sj");
        set.add("jksdhfkjserhfg");
        set.add("jksakldfhlwfjk");
        set.add("jksadldfhjgffjk");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
