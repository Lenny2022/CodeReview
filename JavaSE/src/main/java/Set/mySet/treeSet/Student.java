package Set.mySet.treeSet;

import java.util.Objects;

/**
 * @author: lenny
 * @Date: 2022/6/20 15:03
 * @Description:
 */
public class Student implements Comparable<Student>{

    private String name;

    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o) {
        //1. 年龄由小到大排序
        /*
            3种情况, 小于0 (当前元素小,存左边),等于0(重复,不存),大于0(当前元素较大,存右边)
         */
        int result = this.age - o.age;

        //2. 年龄相同时,姓名字母顺序排序
        // 转换为字母, 比较码表值,返回int
        result = result == 0 ? this.name.compareTo(o.getName()) : result;

        return result;
    }
}
