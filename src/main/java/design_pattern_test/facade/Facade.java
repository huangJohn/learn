package design_pattern_test.facade;

public class Facade {

    /**
     * 外观模式
     * 为子系统中的各类（或结构、方法）提供一个简明的界面，隐藏子系统的复杂性，使子系统更加容易使用
     * 本身也可以定义为一个Facade接口，进行实现
     *
     * */

    public interface ServiceA {
        public void helloA();
    }

    class ServiceAImpl implements ServiceA {
        @Override
        public void helloA() {
            System.out.println("this is helloA ----- serviceA");
        }
    }

    public interface ServiceB {
        public void helloB();


    }

    class ServiceBImpl implements ServiceB {
        @Override
        public void helloB() {
            System.out.println("this is helloB ----- serviceB");
        }
    }


    public interface ServiceC {
        public void helloC();
    }

    class ServiceCImpl implements ServiceC {
        @Override
        public void helloC() {
            System.out.println("this is helloC ----- serviceC");
        }
    }

    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facade() {
        serviceA = new ServiceAImpl();
        serviceB = new ServiceBImpl();
        serviceC = new ServiceCImpl();
    }

    public static void main(String[] args) {

        Facade facade_ = new Facade();
        facade_.serviceA.helloA();
        facade_.serviceB.helloB();
        facade_.serviceC.helloC();
    }

}
