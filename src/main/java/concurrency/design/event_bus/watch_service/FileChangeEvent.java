package concurrency.design.event_bus.watch_service;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class FileChangeEvent {

    private final Path path;
    private WatchEvent.Kind<?> kind;


    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }

    public Path getPath() {
        return path;
    }

    public WatchEvent.Kind<?> getKind() {
        return kind;
    }
}
