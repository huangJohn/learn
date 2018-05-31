package com.example.entity;

import java.util.*;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class Customer4 {
    private String name;
    private String sex;
    private int age;
    private Record record;
    private List<String> hobbies = new ArrayList<String>();
    private Set<String> relatives = new HashSet<String>();
    private Map<String,String> group = new HashMap<String,String>();
    private Properties properties = new Properties();

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, String> getGroup() {
        return group;
    }

    public void setGroup(Map<String, String> group) {
        this.group = group;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    //由于篇幅关系，请读者自行填充set/get方法
    public Customer4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer4(String name, String sex, int age, Record record, List<String> hobbies, Set<String> relatives, Map<String, String> group, Properties properties) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.record = record;
        this.hobbies = hobbies;
        this.relatives = relatives;
        this.group = group;
        this.properties = properties;
    }

    public Set<String> getRelatives() {
        return relatives;
    }

    public void setRelatives(Set<String> relatives) {
        this.relatives = relatives;
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
        return "Customer4{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", record=" + record +
                ", hobbies=" + hobbies +
                ", relatives=" + relatives +
                ", group=" + group +
                ", properties=" + properties +
                '}';
    }
}
