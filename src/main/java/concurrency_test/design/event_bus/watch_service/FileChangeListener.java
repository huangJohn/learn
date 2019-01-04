package concurrency_test.design.event_bus.watch_service;

import concurrency_test.design.event_bus.Subscribe;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class FileChangeListener {

    @Subscribe(topic = "file-monitor")
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }
}
