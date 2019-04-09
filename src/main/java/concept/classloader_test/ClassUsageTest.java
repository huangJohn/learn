package concept.classloader_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class ClassUsageTest {


    /**
     * Description:classloader主要职责就是负责加载各种class文件到jvm中，classloader是一个抽象的class
     * 给定一个class的二进制文件名，classloader会尝试加载并且在jvm中生成构成这个类的各个数据结构
     * 然后使其分布在jvm对应的内存区域中
     * <p>
     * 类的加载过程一般分为加载阶段、连接阶段、初始化阶段三个大的阶段
     * <p>
     * 加载阶段-查找并加载类的二进制文件，其实就是class文件
     * 连接阶段-工作较多，细分：
     * 验证-确保类文件的正确性，比如class文件版本、class文件的魔术因子是否正确
     * 准备-为类的静态变量分配内存，并且初始化其值，注意是*****静态变量，初始化值  *****
     * 解析-把类中的符号引用转换为直接引用
     * 初始化阶段-为******类的静态变量赋真正的初始值，代码编写阶段给定的值*******
     * <p>
     * jvm对类的初始化是一个延迟的机制，当一个类首次使用时，才会被初始化
     * <p>
     * jvm规范规定，java程序首次主动使用才会对类、接口初始化，有6中场景设计主动使用类
     * <p>
     * 1、new关键导致
     * 2、访问类的静态变量，包括读和写
     * 3、访问类的静态方法
     * 4、对类进行反射操作
     * 5、初始化子类导致父类初始化
     * 6、启动类，main函数所在类会被初始化
     */
    public static void main(String[] args) {

//        System.out.println(Simple.x);

//        Simple.test();

        try {
            Class.forName("concept.classloader_test.Simple");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

class Simple {

    static {
        System.out.println("i will be initialized");
    }

    public static int x = 10;//x是一个简单变量，其他类即使不对Simple new操作，直接访问变量x，会导致类的初始化

    public static void test() {
        System.out.println("test static method");
    }
}
