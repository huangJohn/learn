package com.zh.learn.design_patterns.balking.document;

import java.io.IOException;
import java.util.Scanner;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-30
 */
public class DocumentEditThread extends Thread {

    private final String documentPath;
    private final String documentName;
    private final Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String documentPath, String documentName) {
        super("DocumentEditThread");
        this.documentPath = documentPath;
        this.documentName = documentName;
    }

    @Override
    public void run() {
        int time = 0;
        try {
            Document document = Document.create(documentPath, documentName);
            while (true) {
                String text = scanner.next();
                if ("quit".equals(text)) {
                    document.close();
                    break;
                }

                //用户输入编辑5次后，进行文档保存
                document.edit(text);
                if (time == 5) {
                    document.save();
                    time = 0;
                }
                time++;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
