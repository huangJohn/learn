package com.zh.learn.design_patterns.two_phase_termination.reference.phantom;

import com.zh.learn.design_patterns.two_phase_termination.reference.strong.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class PhantomReferenceTest {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        Reference reference = new Reference();
        PhantomReference<Reference> phantomReference = new PhantomReference<>(reference, queue);
        reference = null;
        System.out.println(phantomReference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        java.lang.ref.Reference<? extends Reference> remove = queue.remove();
        System.out.println(remove);

    }

}
