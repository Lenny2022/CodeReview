package reflection.MyReflection1;

/**
 * @author: lenny
 * @Date: 2022/6/21 04:23
 * @Description:
 */
public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("公共的无参构造");
    }

    private Student(String name) {
        System.out.println("name的值为: " + name);
        System.out.println("private -- Student -- 有参构造");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study(){
        System.out.println("学生在学习");
    }

    public void study(String subject) {
        System.out.println("学生在学习 :" + subject);
    }

    private void sleep(){
        System.out.println("学生在睡觉");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    
}
