package reflection.MyReflection1;

/**
 * @author: lenny
 * @Date: 2022/6/21 04:26
 * @Description:
 */
public class Worker {

    public int salary = 10000;
    public String num = "952773";

    private String name;
    private int age;

    public Worker() {
    }

    public Worker(String name, int age) {
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

    public void work() {
        System.out.println("工人在工作");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "salary=" + salary +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



