package com.zh.learn.concurrency_test.design.event_bus.watch_service;

import com.zh.learn.concurrency_test.design.event_bus.EventBus;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class DirectoryTargetMonitor {

    private WatchService watchService;

    private final EventBus eventBus;

    private final Path path;

    private volatile boolean start = false;


    public DirectoryTargetMonitor(final EventBus eventBus, final String targetPath) {
        this(eventBus, targetPath, "");
    }

    public DirectoryTargetMonitor(final EventBus eventBus, final String targetPath, final String... morePaths) {
        this.eventBus = eventBus;
        this.path = Paths.get(targetPath, morePaths);
    }

    public void startMonitor() throws IOException {

        this.watchService = FileSystems.getDefault().newWatchService();
        //为路径注册感兴趣的事件
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.printf("the directory [%s] is monitoring...\n", path);
        this.start = true;
        while (start) {
            WatchKey watchKey = null;
            try {
                watchKey = watchService.take();
                watchKey.pollEvents().forEach(event->{
                    WatchEvent.Kind<?> kind = event.kind();
                    Path path = (Path) event.context();
                    Path child = DirectoryTargetMonitor.this.path.resolve(path);
                    //提交FileChangeEvent到EventBus
                    eventBus.post(new FileChangeEvent(child, kind),"file-monitor");
                });
            } catch (InterruptedException e) {
                this.start = false;
            }finally {
                if (watchKey != null) {
                    watchKey.reset();
                }
            }
        }
    }

    public void stopMonitor() throws IOException {

        System.out.printf("the directory [%s] monitor will be stop...\n", path);
        Thread.currentThread().interrupt();
        this.start = false;
        this.watchService.close();
        System.out.printf("the directory [%s] monitor will be stop done\n", path);
    }
}