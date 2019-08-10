package com.zh.learn.design_patterns.two_phase_termination.hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "/Users/kevin/IdeaProjects/learn/learn-jdk8/my-concurrency-learn/src/main/java/com/zh/learn/design_patterns/two_phase_termination/hooks";

    private final static String LOCK_FILE = ".lock";

    //隐藏
    private final static String PERMISSION = "rw-------";

    public static void main(String[] args) throws IOException {

        //线程收到中断信号或者退出信号才执行，直接杀死进程 kill -9，hook逻辑不会执行
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("the program received kill signal");
                getLockFile().toFile().delete();
            }
        });

        checkRunning();

        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(3);
                System.out.println("program is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static void checkRunning() throws IOException {
        Path lockFile = getLockFile();
        if (lockFile.toFile().exists()) {
            //lock文件存在了，程序已经执行，不能再运行
            throw new RuntimeException("the program is already running");
        }

        Set<PosixFilePermission> posixFilePermissions =
                PosixFilePermissions.fromString(PERMISSION);

        Files.createFile(lockFile, PosixFilePermissions.asFileAttribute(posixFilePermissions));
    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }

}
