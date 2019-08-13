package com.zh.learn.design_patterns.two_phase_termination.reference.weak;

import com.zh.learn.design_patterns.two_phase_termination.reference.strong.Reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class WeakTest {

    public static void main(String[] args) throws InterruptedException {

        Reference reference = new Reference();
        WeakReference<Reference> weakReference = new WeakReference<>(reference);

        reference = null;
        System.gc();

        /**
         * Description:
         * 无论是soft还是weak，被垃圾回收器回收后都会存在与之关联的ReferenceQueue中
         */

        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        reference = new Reference();
        weakReference = new WeakReference<>(reference, queue);
        reference = null;
        System.out.println(weakReference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        java.lang.ref.Reference<? extends Reference> remove = queue.remove();
        System.out.println(remove);

    }

}
