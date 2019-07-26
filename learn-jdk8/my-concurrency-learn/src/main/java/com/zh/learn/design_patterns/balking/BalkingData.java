package com.zh.learn.design_patterns.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class BalkingData {

    private final String fileName;

    private String content;

    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {

        //已经被服务了，直接返回
        if (!changed) {
            return;
        }

        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {

        System.out.println(Thread.currentThread().getName() + " call do save, content=" + content);
        try (Writer writer = new FileWriter(fileName, true)) {
            writer.write(content);
            writer.write("\n");
            writer.flush();
        }
    }
}
