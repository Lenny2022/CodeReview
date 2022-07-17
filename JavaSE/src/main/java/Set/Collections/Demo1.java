package Set.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 * @author: lenny
 * @Date: 2022/6/20 10:07
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        //迭代器 Iterator
        //接口内部包含了4个方法, next() hasNext() remove()  forEachRemaining  --> 调用了Lambda表达式

        /*
    Collection接口中的常用方法:
        boolean add(E e) : 添加元素。
        boolean contains(Object o): 如果此集合包含指定的元素，则返回 true 。
        boolean isEmpty() : 如果此集合不包含元素，则返回 true 。
        boolean remove(Object o) : 根据元素本身删除集合中对应的内容。
        int size(): 返回此集合中的元素个数。

        boolean removeIf(Object o): 根据条件删除集合中的元素
        void clear(): 清空集合中的元素
 */
        Collection<String> col = new ArrayList<>();
        col.add("1");
        col.add("2");
        col.add("3");

        //System.out.println("集合的长度为: " + col.size());
        //System.out.println(col.contains("2"));
        //col.remove("1");
        //System.out.println(col);

        col.add("4");
        col.add("5");
        col.add("8");

        System.out.println(col);

        //遍历(通过迭代器)
        //1. 先获取迭代器对象
        /*
            通过反复调用 next 方法来实现访问集合中每一个元素,到大末尾时, 会返回一个NoSuchElementException
            因此,在调用 next()之前, 先调用 hasNext() ,如迭代器对象还有多个可供访问的元素,这个方法就返回true
         */
        Iterator<String> iterator = col.iterator();

        //iterator.forEachRemaining(System.out::println);


        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

        }

        Iterator<String> it = col.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println("name = " + name);
        }


        //增强 for更简洁的实现了 Iterator
        //for (String s : col) {
        //    System.out.println(s);
        //}


    }
}
