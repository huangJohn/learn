package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CircuitBreakerTestGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(3000)));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("running run(): " + name + ", thread : " + Thread.currentThread().getName());
        Thread.sleep(1000);
        return name;
    }

    @Override
    protected String getFallback() {
        System.out.println("running get fallback.");
        return "CircuitBreaker fallback: " + name;
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, TimeoutException {

        Future<String> test = new CommandHelloWorld("hello").queue();

        System.out.println(">>>>" + test.isDone());
        long st = System.currentTimeMillis();
        System.out.println("====" + test.get());
        long en = System.currentTimeMillis();
        System.out.println(">>>>" + test.isDone());
        System.out.println("---" + (en - st));


    }
}
