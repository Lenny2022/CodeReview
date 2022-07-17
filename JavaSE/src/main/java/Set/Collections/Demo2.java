package Set.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 并发修改异常 : ConcurrentModificationException
 *
 * @author: lenny
 * @Date: 2022/6/20 11:02
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
    /*
    ConcurrentModificationException: 并发修改异常
    并发修改异常:
        指的是在迭代器思想遍历过程中,一遍遍历集合容器,一遍修改集合容器的长度,这时候JVM会抛出此异常
    */
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("javaSE");


        //1.Iterator遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            // ConcurrentModificationException: 并发修改异常
            String s = it.next();
            System.out.println(s);


            //特例,倒数第二个元素 remove 不会出现该异常, 见源码

            //删除倒数第二个时,cursor的值恰好等于 size, hasNext 返回false, 无法继续执行下去, 无法 触发
            // it.next(), 也就无定校验, 没有并发修改异常

            if ("java".equals(s)) {
                list.remove("java");
            }

            /*
                // ArrayList 源码
                private class Itr implements Iterator<E> {
                int cursor;       // index of next element to return
                int lastRet = -1; // index of last element returned; -1 if no such
                int expectedModCount = modCount;

                // prevent creating a synthetic constructor
                Itr() {}

                public boolean hasNext() {
                    return cursor != size;
                }
             */
        }

    }
}
