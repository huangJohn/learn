package com.zh.learn.copy_test;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-20
 */

@Data
@ToString
public class ShallowClone implements Cloneable {

    //引用
    private String name;
    //基本类型
    private int age;
    //引用
    private List<String> books;

    @Override
    public ShallowClone clone() {

        ShallowClone shallowClone = null;
        try {
            //浅拷贝
            shallowClone = (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shallowClone;
    }

    /**
     * Description:
     * 深拷贝，就是要创建一个全新的对象，新的对象内部所有的成员也都是全新的，只是初始化的值已经由被拷贝的对象确定了而已
     */
    public ShallowClone deepClone() {
        ShallowClone clone = new ShallowClone();
        //对source每一个属性赋值
        clone.name = this.name;
        clone.age = this.age;
        if (this.books != null) {
            clone.books = new ArrayList<>(this.books);
        }
        return clone;
    }

    public static void main(String[] args) {

        ShallowClone shallowClone = new ShallowClone();
        shallowClone.setAge(10);
        shallowClone.setName("123");
        ArrayList<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        shallowClone.setBooks(list);

        //浅
        ShallowClone cloneObj = shallowClone.clone();

        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());
        System.out.println("==================");

        // 判断两个对象是否为同一个对象（即是否是新创建了一个实例）
        System.out.println(cloneObj == shallowClone ? "同一个引用" : "非同一个引用");//false
        System.out.println("===================");

        // 修改一个对象的内容是否会影响另一个对象 ?
        shallowClone.setName("newName123");//no，string是复制的引用，jvm中是常量池，受字符串驻留机制，不会对原来的值造成影响
        shallowClone.setAge(20);//no
        shallowClone.getBooks().add("c");//yes

        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());//source 影响浅拷贝的 list引用obj
        System.out.println("==================");

        cloneObj.setName("xxxxxxx123");//no
        cloneObj.setAge(99);
        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());
        System.out.println("==================");

        cloneObj.getBooks().add("sadasdsadasxxx");//引用指向原来,yes
        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());
        System.out.println("==================");

        /**
         * Description:
         * 原对象的list对象已经被指向另外一个地址
         * 所以浅拷贝的对象和原来对象已经不是同一个引用
         */
        cloneObj.setBooks(Arrays.asList("asdsa"));//新的地址，深拷贝了,不改变source
        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());
        System.out.println("==================");

        /**
         * Description:同上
         */
        shallowClone.setBooks(Arrays.asList("hello"));
        System.out.println("source: " + shallowClone.toString() + "\nclone: " + cloneObj.toString());
        System.out.println("==================");

        /**
         * Description:
         * 结果分析：
         *
         * 拷贝后获取的是一个独立的对象，和原对象拥有不同的内存地址
         * 基本元素类型，两者是隔离的（虽然上面只给出了int）
         * 基本元素类型包括:
         * int, Integer, long, Long, char, Charset, byte,Byte, boolean, Boolean, float,Float, double, Double
         * 非基本数据类型（如基本容器，其他对象等），只是拷贝了一份引用出去了，实际指向的依然是同一份
         * 其实，浅拷贝有个非常简单的理解方式：
         *
         * 浅拷贝的整个过程就是，创建一个新的对象，然后新对象的每个值都是由原对象的值，通过 = 进行赋值
         *
         * - Object clone = new Object();
         * - clone.a = source.a
         * - clone.b = source.b
         * - ...
         *
         * 基本数据类型是值赋值；非基本的就是引用赋值
         *
         * 浅拷贝出来的对象修改值属性不能影响原对象
         */

        System.out.println("------------深复制测试---------");

        ShallowClone shallowClone2 = new ShallowClone();
        shallowClone2.setName("SourceName");
        shallowClone2.setAge(new Integer(1280));
        List<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("c++");
        shallowClone2.setBooks(list2);

        ShallowClone cloneObj2 = shallowClone2.deepClone();

        // 判断两个对象是否为同一个对象（即是否是新创建了一个实例）
        System.out.println(shallowClone2 == cloneObj2);//false
        System.out.println("source: " + shallowClone2.toString() + "\nclone:" + cloneObj2.toString());
        System.out.println("=================");

        // 修改一个对象的内容是否会影响另一个对象
        shallowClone2.setName("newName");
        shallowClone2.setAge(2000);
        shallowClone2.getBooks().add("javascript");
        //no
        System.out.println("source: " + shallowClone2.toString() + "\nclone:" + cloneObj2.toString());
        System.out.println("=================");

        //no
        shallowClone2.setBooks(Arrays.asList("hello"));
        System.out.println("source: " + shallowClone2.toString() + "\nclone:" + cloneObj2.toString());
        System.out.println("=================");

        cloneObj2.getBooks().add("nginx");
        System.out.println("source: " + shallowClone2.toString() + "\nclone:" + cloneObj2.toString());
        System.out.println("=================");

        /**
         * Description:
         * 结果分析：
         *
         * 深拷贝独立的对象
         * 拷贝后对象的内容，与原对象的内容完全没关系，都是独立的
         * 简单来说，深拷贝是需要自己来实现的，对于基本类型可以直接赋值，而对于对象、容器、数组来讲，需要创建一个新的出来，然后重新赋值
         */
    }
}
