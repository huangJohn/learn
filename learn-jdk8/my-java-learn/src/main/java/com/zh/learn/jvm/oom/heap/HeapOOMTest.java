package com.zh.learn.jvm.oom.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 堆用于存储对象实例，只要不断创建对象，保证GC Root到对象之间有
 * 可达路径避免gc回收清楚这些对象，则达到最大堆容量后产生内存溢出异常
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/20
 */
public class HeapOOMTest {


    static class OOMObj {

    }


    public static void main(String[] args) {

        List<OOMObj> list = new ArrayList<>();


        while (true) {
            list.add(new OOMObj());
        }

    }



}
