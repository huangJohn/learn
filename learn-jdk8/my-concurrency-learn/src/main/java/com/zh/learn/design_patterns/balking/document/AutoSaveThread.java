package com.zh.learn.design_patterns.balking.document;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-30
 */
public class AutoSaveThread extends Thread {

    private final Document document;

    public AutoSaveThread(Document document) {
        super("Document AutoSaveThread");
        this.document = document;
    }

    @Override
    public void run() {
        while (true) {
            try {
                document.save();
                //每个1s，保存动作
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException e) {
                //中断后终止while，线程生命周期结束
                break;
            }
        }
    }
}
