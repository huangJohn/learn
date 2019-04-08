package concept.exception;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-08
 */
public class UnCheckedExceptionTest {

    public static void main(String[] args) {

//        throw new Exception("123");//checked 异常，编译是不允许通过的


//        throw new NullPointerException();//unchecked 异常，编译通过


        /**
         * Description:
         * 如果创建一个自定义的异常类，它是 Checked Exception 还是 Unchecked Exception 则依赖其父类的类型。
         * * 如果它继承于一个 Unchecked Exception 类，那么它就是一个 Unchecked Exception，反之依然。
         *
         * *  Throwable(Checked)
         *                  *          -> Exception(Checked)
         *                  *                  -> RuntimeException(Unchecked)
         *                  *                  -> Other checked exception subclasses
         *                  *          -> Error(Unchecked)
         *                  *                  -> Other unchecked exception subclasses
         */


        /**
         * Description:
         * 在对 Checked Exception 进行 catch 操作时，也需要遵循一定的规则：在 catch 块中捕获的异常，必须在 try 块中有出现这种异常的可能性。
         * 例子就不能成功编译，因为在 try 块中永远都不会抛出 IOException，所以你也不能去捕获这种异常。但是如果你捕获的是一个 Unchecked Exception，那么就不会有这种问题。
         */
//        try {
//            System.out.println("...");
//        } catch(java.io.IOException e) {
//        }


        /**
         * Description:
         * 前面所说的规则对于 Exception 和 Throwable 这两个类并不是完全适用，
         * 这是因为对 Exception 和 Throwable 这两个类都有 Unchecked Exception 类型的子类，所以编译器允许你捕获它们（编译器认为你是在捕获一个 Unchecked Exception）。
         * 要清楚一点，编译器并不会检查 Unchecked Exception，RuntimeException 是 Exception 的子类，Error 是 Throwable的子类,
         * 而 RuntimeException 和 Error 都是 Unchecked Exception 类。
         * 因此，上面的代码是可以正确编译的，编译允许这样做的原因就是因为这种方式是可以捕获到 Unchecked Exception 的。
         */
        try {
            System.out.println("...");
        } catch(Exception ex) {
        }


        /**
         * Description:
         * JVM Exception 是由 JVM 自己抛出的异常，比如：如果调用的方法使用一个 null 引用，然后 JVM 就会抛出 NullPointerException，或者如果在程序中出现10除以0的情况，JVM 会抛出一个 ArithmeticException。这些异常都是自动地由 JVM 抛出。
         *
         * 除了 JVM Exception 外，其他所有的异常都是由程序引起的异常。程序中，我们可以显式地使用 throw 语句抛出异常，这里以 NumberFormatException 为例。NumberFormatException 可能被方法 Integer.parseInt 或 Float.parseFloat 抛出，都是程序中可能出现的异常
         *
         *
         * if (s == null) {
         *       throw new NumberFormatException("null");
         * }
         *
         * 而 JVM 不会抛出这种类型的异常，这些异常是使用 throw 语句显式地程序中抛出。当然也可以如下所示在程序中抛出 JVM Exception。
         *
         * if (s == null) {
         *       throw new NullPointerException("I told you s shouldn't be null");
         * }
         *
         * 但是一般情况下，JVM Exception 是不会被开发者抛出的（JVM 自己抛出的），
         * 所有的 JVM Exception 都是 unchecked，而程序中的异常则可能是 checked 的或者 unchecked 的。
         */

    }

}
