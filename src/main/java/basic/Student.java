package basic;

/**
 * @author zhuanghuang@corp.netease.com
 * @date 2018/6/19
 */

public class Student extends BaseToString{

    private String name;

    @StringHidden
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Student student = new Student("a", 10);
        System.out.println(student);
    }
}
