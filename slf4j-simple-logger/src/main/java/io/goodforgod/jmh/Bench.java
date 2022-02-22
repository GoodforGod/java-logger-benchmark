package io.goodforgod.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class Bench {

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(Bench.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }

    private Logger logger;
    private String arg1;
    private String arg2;
    private String[] argArray;
    private Exception exception;

    @Setup
    public void setup() {
        try {
            throwEx();
        } catch (Exception e) {
            exception = e;
        }

        arg1 = "FirstArgument";
        arg2 = "SecondArgument";
        argArray = new String[] { arg1, arg2, "ThirdArgument" };
        logger = LoggerFactory.getLogger(Bench.class);
    }

    @Benchmark
    public void messageOneArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with the argument: {}", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with arguments '{}' and '{}'", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with arguments '{}' and '{}' and '{}'", argArray);
    }

    @Benchmark
    public void messageOneArgumentInTheStart() {
        logger.debug("'{}' argument and message is printed for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheStart() {
        logger.debug("'{}' and '{}' arguments and message is printed for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheStart() {
        logger.debug("'{}' and '{}' and '{}' argument and message is printed for this logger", argArray);
    }

    @Benchmark
    public void messageOneArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' argument for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' and '{}' argument for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' and '{}' and '{}' argument for this logger", argArray);
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.warn("Message is printed for this logger and there is stacktrace", exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Some unknown exception happen and have some stacktrace and message info");
    }
}
