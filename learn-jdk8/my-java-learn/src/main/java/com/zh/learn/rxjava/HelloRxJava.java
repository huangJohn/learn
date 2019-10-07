package com.zh.learn.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-30
 */
public class HelloRxJava {

    public static void main(String[] args) {

        Observable<String> producer = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("apple");
                subscriber.onNext("orange");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onCompleted();
            }
        });


        Subscriber<String> consumer = new Subscriber<String>() {


            @Override
            public void onStart() {
                System.out.println("我开始订阅");
            }

            @Override
            public void onNext(String s) {
                System.out.println("我收到水果:" + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("水果收到完毕");
            }

            @Override
            public void onError(Throwable e) {
            }


        };

        producer.subscribe(consumer);


    }

}
