package concept;


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
        System.out.println("-------------------------");

        System.out.println("in main, before, user = "+user.toString());
        pass1(user);
        System.out.println("in main, after, user = "+user.toString());
        System.out.println("-------------------------");
    }

    private static void pass(int j) {

        j = 20;//实参传给函数的是原实参的一个副本，改动不影响主方法原值
        System.out.println("in pass, i = " + j);
    }

    private static void pass(User user) {

        user = new User();//传递副本，但是关键在于有new操作，指向另一块新对象引用地址，操作的地址不是原来的地址
        user.setName("fang");
        user.setAge(20);
        System.out.println("in pass, user = " + user.toString());
    }

    private static void pass(String name) {
        name = "song";//传递副本，但是对于string类型操作先new，本质还是指向新内存地址，操作不改变原对象
        System.out.println("in pass, name = "+name);
    }

    private static void pass1(User user) {
        //传递副本进来，但是副本和正本的引用指向同一个地址，set操作将改变同一个地址下的属性值，所以main方法中的对象属性已经发生改变了
        user.setName("fang");
        user.setAge(20);
        System.out.println("in pass, user = " + user.toString());
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
