package basic;


/**
 * @author Zhuang Huang
 * @date 2018/5/11
 */
public class ValueTest {


    public static void main(String[] args) {

        int i = 10;
        System.out.println("in main, before, i = " + i);
        pass(i);
        System.out.println("in main, after, i = " + i);
        System.out.println("-------------------------");


        User user = new User("zhuang", 10);
        System.out.println("in main, before, user = "+user.toString());
        pass(user);
        System.out.println("in main, after, user = "+user.toString());
        System.out.println("-------------------------");

        String name = "zhuang";
        System.out.println("in main, before, name=" + name);
        pass(name);
        System.out.println("in mian, after, name="+name);
    }

    private static void pass(int j) {

        j = 20;//实参传给函数的是原实参的一个副本，改动不影响主方法原值
        System.out.println("in pass, i = " + j);
    }

    private static void pass(User user) {

        user = new User();//传递副本，但是关键在于有new操作，指向另一块新对象引用地址，操作不改变原对象值
        user.setName("fang");
        user.setAge(20);
        System.out.println("in pass, user = " + user.toString());
    }

    private static void pass(String name) {
        name = "song";//传递副本，对于string类型操作先new，本质还是指向新内存地址，操作不改变原对象
        System.out.println("in pass, name = "+name);
    }

    private static void pass1(String name) {
        name = "song";//传递副本，对于string类型操作先new，本质还是指向新内存地址，操作不改变原对象
        System.out.println("in pass, name = "+name);
    }
}

class User {
    private String name;
    private int age;

    public User() {

    }

    public User(String name, int age) {
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

    @Override
    public String toString() {
        return "{name=" + name + ", age=" + age + "}";
    }
}
