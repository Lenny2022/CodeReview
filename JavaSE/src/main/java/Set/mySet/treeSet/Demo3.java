package Set.mySet.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 比较器排序 Comparator
 * @author: lenny
 * @Date: 2022/6/20 18:47
 * @Description:
 *
 *
 */
public class Demo3 {
    public static void main(String[] args) {
        // 按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序

        /*
            实现步骤 :
            - 用TreeSet集合存储自定义对象，带参构造方法使用的是比较器排序对元素进行排序的
            - 比较器排序，就是让集合构造方法接收Comparator的实现类对象，重写compare(T o1,T o2)方法
            - 重写方法时，一定要注意排序规则必须按照要求的主要条件和次要条件来写
         */

        // 1.构造一个新的，空的树集，根据指定的比较器进行排序。
        TreeSet<Teacher> treeSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                // o1表示当前操作元素, o2已存入元素
                //Condition 1 : 年龄从小到大
                int result = o1.getAge() - o2.getAge();

                //Condition 2: age 相同时, 按照姓名字母排序
                result = result == 0 ? o1.getAge().compareTo(o2.getAge()) : result;

                return result;
            }
        });

        Teacher t1 = new Teacher("zhangsan", 28);
        Teacher t2 = new Teacher("lisi", 27);
        Teacher t3 = new Teacher("wangwu", 29);
        Teacher t4 = new Teacher("zhaoliu", 28);
        Teacher t5 = new Teacher("qianqi", 30);

        treeSet.add(t1);
        treeSet.add(t2);
        treeSet.add(t3);
        treeSet.add(t4);
        treeSet.add(t5);

        System.out.println(treeSet);

    }
}
