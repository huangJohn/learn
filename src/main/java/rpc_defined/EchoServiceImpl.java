package rpc_defined;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String ping) {
        return null != ping ? ping + " i am ok" : "i am ok";
    }
}
