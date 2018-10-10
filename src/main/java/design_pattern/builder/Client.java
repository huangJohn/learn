package design_pattern.builder;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Human humanByDirector = director.createHumanByDirector(new SmartManBuilder());
        System.out.println(humanByDirector.toString());
    }
}
