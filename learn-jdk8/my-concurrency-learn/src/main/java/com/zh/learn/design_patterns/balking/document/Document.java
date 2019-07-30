package com.zh.learn.design_patterns.balking.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-30
 */
public class Document {

    //如果文档发生了改变，changed置为true
    private boolean changed = false;

    //一次需要保存的内容，可理解为内容缓存
    private List<String> content = new ArrayList<>();

    //写
    private final FileWriter fileWriter;

    //自动保存文档的线程
    private static AutoSaveThread autoSaveThread;

    public Document(String documentPath, String documentName) throws IOException {
        this.fileWriter = new FileWriter(new File(documentPath, documentName));
    }

    //static create方法，启动AutoSaveThread
    public static Document create(String documentPath, String documentName) throws IOException {
        Document document = new Document(documentPath, documentName);
        autoSaveThread = new AutoSaveThread(document);
        autoSaveThread.start();
        return document;
    }

    //编辑
    public void edit(String content) {
        synchronized (this) {
            //add
            this.content.add(content);
            //文档改变
            this.changed = true;
        }
    }

    public void close() throws IOException {
        //先中断自动保存线程
        autoSaveThread.interrupt();
        fileWriter.close();
    }

    //外部显示调用保存文档
    public void save() throws IOException {
        synchronized (this) {
            //balking
            //如果已经被保存了，则不做，直接返回
            if (!changed) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + " execute to save the document action");
            for (String cacheLine : content) {
                this.fileWriter.write(cacheLine);
                this.fileWriter.write("\n");
            }
            this.fileWriter.flush();
            //被保存后，置为false，表示没发生改变
            this.changed = false;
            this.content.clear();
        }
    }
}
