package design_pattern_test.template;

public abstract class Template {

    public  final void print(String msg) {

        System.out.println("###################");
        wrapPrint(msg);
        System.out.println("###################");
    }

    protected abstract void wrapPrint(String msg);

    public static void main(String[] args) {

        Template template = new Template() {
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("****"+msg+"****");
            }
        };

        template.print("hello");

        Template template2 = new Template() {
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("====" + msg + "====");
            }
        };

        template2.print("hello");


    }

}
