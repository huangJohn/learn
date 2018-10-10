package design_pattern.builder;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class SmartManBuilder implements IBuildHuman {

    Human human;

    public SmartManBuilder() {
        human = new Human();
    }

    @Override
    public void buildHead() {
        human.setHead("智商180的头");
    }

    @Override
    public void buildBody() {
        human.setBody("八块腹肌的身体");
    }

    @Override
    public void buildHand() {
        human.setHand("小手");
    }

    @Override
    public void buildFoot() {
        human.setFoot("1米长的脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
