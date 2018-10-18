package design_pattern.static_proxy;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class CoderProxy implements ICoder {

    private ICoder iCoder;

    public CoderProxy(ICoder iCoder) {
        this.iCoder = iCoder;
    }

    @Override
    public void implDemands(String demandName) {
        iCoder.implDemands(demandName);
    }
}
