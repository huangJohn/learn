package design_pattern_test.adapter.adapter_of_interface;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Server extends Wrapper {
    @Override
    public void mysql() {
        System.out.println("server mysql is running,");
    }

    @Override
    public void ssh() {
        System.out.println("server ssh is running");
    }


    @Override
    public void net() {
        System.out.println("server net is running");
    }


    @Override
    public void tomcat() {
        System.out.println("server tomcat is running!");
    }

}
