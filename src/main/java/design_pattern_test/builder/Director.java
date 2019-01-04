package design_pattern_test.builder;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Director {

    public Human createHumanByDirector(IBuildHuman buildHuman) {
        buildHuman.buildBody();
        buildHuman.buildFoot();
        buildHuman.buildHand();
        buildHuman.buildHead();
        return buildHuman.createHuman();
    }
}
