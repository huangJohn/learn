package com.example.entity;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class Customer3 {
    private String name;
    private String sex;
    private int age;
    private Record record = new Record();

    //由于篇幅关系，请读者自行填充set/get方法
    public Customer3() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer3(String name, String sex, int age, Record record) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Customer3{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", record=" + record +
                '}';
    }
}
