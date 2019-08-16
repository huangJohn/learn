package com.zh.learn.design_patterns.event_driven.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class EventLoop {

    public static void handleEventA(Event event) {
        System.out.println(event.getData().toLowerCase());
    }

    public static void handleEventB(Event event) {
        System.out.println(event.getData().toUpperCase());
    }

    public static void main(String[] args) {

        Queue<Event> events = new LinkedList<>();
        events.add(new Event("A", "Hello"));
        events.add(new Event("A", "World"));
        events.add(new Event("B", "Hello"));
        events.add(new Event("B", "World"));

        Event event;
        while (!events.isEmpty()) {
            event = events.remove();
            switch (event.getType()) {
                case "A":
                    handleEventA(event);
                    break;
                case "B":
                    handleEventB(event);
                    break;
                default:
                    break;
            }
        }
    }

}
