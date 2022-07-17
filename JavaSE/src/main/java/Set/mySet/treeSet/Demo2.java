package Set.mySet.treeSet;

import java.util.TreeSet;

/**
 * 自然排序
 *
 * @author: lenny
 * @Date: 2022/6/20 15:02
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();

        Student s1 = new Student("zhangsan", 28);
        Student s2 = new Student("lisi", 27);
        Student s3 = new Student("wangwu", 29);
        Student s4 = new Student("zhaoliu", 28);
        Student s5 = new Student("qianqi", 30);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        System.out.println("年龄由小到大排序(相同按照字母顺序排序 :)");

        for (Student student : set) {
            System.out.println(student);
        }

    }
}

class ComparableTest {
    public static void main(String[] args) {

        String s1 = "agc";
        String s2 = "ac";

        // 每一位转换位ASCII码十位表比较, 一样跳过, 不一样,作差, a-a, g -> 103, c -> 99.  得到4
        int result = s1.compareTo(s2);

        System.out.println(result);
    }
}
